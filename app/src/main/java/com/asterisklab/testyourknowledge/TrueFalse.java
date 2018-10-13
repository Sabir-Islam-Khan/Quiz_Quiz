package com.asterisklab.testyourknowledge;

public class TrueFalse {

    private String userAns;
    private int questionID;
    private Boolean answer;
    public String testValue;

    public TrueFalse(int questionResource, Boolean trueOrFalse){
        questionID = questionResource;
        answer = trueOrFalse;
    }

    public String choice(String choosen){
        userAns = choosen;
        return userAns;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public Boolean getAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
        this.answer = answer;
    }
}
