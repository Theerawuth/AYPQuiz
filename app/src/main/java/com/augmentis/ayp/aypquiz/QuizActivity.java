package com.augmentis.ayp.aypquiz;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    Button trueButton;
    Button falseButton;
    Button nextButton;
    Button previousButton;
    TextView questionText;

    Question[] questions = new Question[]{
            new Question(R.string.question1_nile, true),
            new Question(R.string.question2_rawin, true),
            new Question(R.string.question3_math, false),
            new Question(R.string.question4_mars, false),
    };

    int currentIndex;

    private static final String TAG = "AYPQUIZ";
    private static final String INDEX = "INDEX";

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "On Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "On Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "On Start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "On Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "On Pause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG,"State is saving");
        outState.putInt(INDEX,currentIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = (Button)findViewById(R.id.true_button);
        falseButton = (Button)findViewById(R.id.false_button);
        nextButton = (Button)findViewById(R.id.next_button);
        previousButton = (Button)findViewById(R.id.previous_button);
        questionText = (TextView) findViewById(R.id.text_question);


        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(INDEX, 0);
        }else{
            currentIndex=0;
        }
        updateQuestion();

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click previous
                currentIndex--;
                if(currentIndex <0) currentIndex = questions.length-1;
                questionText.setText(questions[currentIndex].getQuestionId());
                updateQuestion();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click next
                currentIndex++;
                if(currentIndex == questions.length) currentIndex = 0;
                questionText.setText(questions[currentIndex].getQuestionId());
                updateQuestion();
            }
        });

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click true
                checkAnswer(true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // click false
                checkAnswer(false);
            }
        });
        Log.d(TAG, "On Create");
    }

    public void checkAnswer(boolean answer){

        boolean correctAnswer = questions[currentIndex].getAnswer();

        if(answer == correctAnswer){
            Toast.makeText(QuizActivity.this, R.string.Corrected, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(QuizActivity.this, R.string.Incorrect, Toast.LENGTH_SHORT).show();
        }

    }
    public void updateQuestion(){
        questionText.setText(questions[currentIndex].getQuestionId());
    }

}

