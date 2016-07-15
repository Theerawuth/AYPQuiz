package com.augmentis.ayp.aypquiz;

import android.os.Bundle;

/**
 * Created by Theerawuth on 7/14/2016.
 */
public class Question {

    private boolean cheated;
    private int questionId;
    private  boolean answer;

    public Question(int questionId, boolean answer) {
        this.questionId = questionId;
        this.answer = answer;
        this.cheated = false;
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

    public boolean getCheated() {
        return cheated;
    }

    public void setCheated(boolean cheated) {
        this.cheated = cheated;
    }
}
