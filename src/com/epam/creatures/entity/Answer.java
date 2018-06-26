package com.epam.creatures.entity;

public class Answer {

    public enum AnswerType {
        FORWARD,
        REDIRECT
    }

    private AnswerType answerType;
    private String answerPage;

    public Answer(AnswerType answerType, String answerPage) {
        this.answerType = answerType;
        this.answerPage = answerPage;
    }

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public String getAnswerPage() {
        return answerPage;
    }

    public void setAnswerPage(String answerPage) {
        this.answerPage = answerPage;
    }
}
