package com.example.imbizo_foundation;

import android.icu.lang.UProperty;

public class  Question {

    //Question property declarations
    private int questionID;
    private String question;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private String optionFive;
//    private int correctAnswer;

    public Question(int questionID, String question, String optionOne, String optionTwo, String optionThree, String optionFour, String optionFive) {
        this.questionID = questionID;
        this.question = question;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.optionFive = optionFive;
//        this.correctAnswer = correctAnswer;
    }

    public String getOptionFive() {
        return optionFive;
    }

    public void setOptionFive(String optionFive) {
        this.optionFive = optionFive;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(String optionOne) {
        this.optionOne = optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(String optionTwo) {
        this.optionTwo = optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(String optionThree) {
        this.optionThree = optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public void setOptionFour(String optionFour) {
        this.optionFour = optionFour;
    }
//
//    public int getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    public void setCorrectAnswer(int correctAnswer) {
//        this.correctAnswer = correctAnswer;
//    }

}
