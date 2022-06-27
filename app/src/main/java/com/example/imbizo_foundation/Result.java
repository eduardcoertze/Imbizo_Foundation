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




//    public static ArrayList<Result> getResults(){
//
//        ArrayList<Result> resultsList = new ArrayList<Result>();
//
//        Result result1 = new Result(
//                1,
//                "Introvert",
//                "a typically reserved or quiet person who tends to be introspective and enjoys spending time alone"
//        );
//        resultsList.add(result1);
//
//        Result result2 = new Result(
//                2,
//                "Extrovert",
//                "A typically gregarious and unreserved person who enjoys and seeks out social interaction"
//        );
//        resultsList.add(result2);
//
//        Result result3 = new Result(
//                3,
//                "Ambivert",
//                "A person who has a balance of extrovert and introvert features in their personality."
//        );
//        resultsList.add(result3);
//
//        Result result4 = new Result(
//                3,
//                "Omnivert",
//                "Someone who is an introvert and extrovert depending on situations"
//        );
//        resultsList.add(result4);
//
//        return resultsList;
//    }
}
