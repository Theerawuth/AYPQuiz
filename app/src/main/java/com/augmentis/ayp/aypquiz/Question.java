package com.augmentis.ayp.aypquiz;

/**
 * Created by Theerawuth on 7/14/2016.
 */
public class Question {
    private int questionId;
    private  boolean answer;

    public Question(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean getAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }


}
