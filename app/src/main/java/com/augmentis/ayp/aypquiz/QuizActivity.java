package com.augmentis.ayp.aypquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    Button trueButton;
    Button falseButton;
    Button nextButton;
    TextView questionText;

    Question[] questions = new Question[]{
            new Question(R.string.question1_nile, true),
            new Question(R.string.question2_rawin, true),
            new Question(R.string.question3_math, false),
            new Question(R.string.question4_mars, false),
    };

    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        trueButton = (Button)findViewById(R.id.true_button);
        falseButton = (Button)findViewById(R.id.false_button);
        nextButton = (Button)findViewById(R.id.next_button);
        questionText = (TextView) findViewById(R.id.text_question);

        currentIndex = 0;
        updateQuestion();
        questionText.setText(questions[currentIndex].getQuestionId());

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

