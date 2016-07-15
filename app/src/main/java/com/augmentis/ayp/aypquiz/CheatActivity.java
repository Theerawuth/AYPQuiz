package com.augmentis.ayp.aypquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    boolean answer;
    TextView answerText;
    Button  confirmButton;
    boolean isCheated;

    private static final String ANSWER_EXTRA_KEY = "Answer";
    private static final String CHEATED_EXTRA_KEY = "Cheated";

    public static Intent createIntent(Context context, boolean answer){
        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra(ANSWER_EXTRA_KEY, answer);
        return intent;
    }

    public static boolean wasCheated(Intent intent){
        return intent.getExtras().getBoolean(CHEATED_EXTRA_KEY);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        // get answer from intent
        answer = getIntent().getExtras().getBoolean(ANSWER_EXTRA_KEY);
        isCheated = false;

        confirmButton = (Button) findViewById(R.id.confirm_button);
        answerText = (TextView) findViewById(R.id.text_answer);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                if(answer){
                    answerText.setText(R.string.answer_is_true);
                }else{
                    answerText.setText(R.string.answer_is_false);
                }


                isCheated = true;
                returnResult();

            }
        });


    }

    private void returnResult(){
        Intent newIntent =new Intent();
        newIntent.putExtra(CHEATED_EXTRA_KEY,isCheated);
        setResult(RESULT_OK,newIntent);
        }
}
