package com.example.imbizo_foundation;

import java.util.ArrayList;
import java.util.List;

public class Result {

    public int resultID;
    private String personalityType;
    private String personalityDescription;
    private ArrayList<String> personalityCareers;

    public Result(int resultID, String personalityType, String personalityDescription, ArrayList<String> personalityCareers) {
        this.resultID = resultID;
        this.personalityType = personalityType;
        this.personalityDescription = personalityDescription;
        this.personalityCareers = personalityCareers;
    }

    public ArrayList<String> getPersonalityCareers() {
        return personalityCareers;
    }

    public void setPersonalityCareers(ArrayList<String> personalityCareers) {
        this.personalityCareers = personalityCareers;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public void setPersonalityType(String personalityType) {
        this.personalityType = personalityType;
    }

    public void setPersonalityDescription(String personalityDescription) {
        this.personalityDescription = personalityDescription;
    }

    public int getResultID() {
        return resultID;
    }

    public String getPersonalityType() {
        return personalityType;
    }

    public String getPersonalityDescription() {
        return personalityDescription;
    }


}
