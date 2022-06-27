package com.example.imbizo_foundation;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static int resultTotal;

    public static ArrayList<Question> getQuestions(){

        ArrayList<Question> questionsList = new ArrayList<Question>();

        Question que1 = new Question(
            1,
                "I like to follow a daily schedule",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que1);

        Question que2 = new Question(
                2,
                "I prefer to work in a quiet environment",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que2);

        Question que3 = new Question(
                3,
                "I like to do things the way they have been done in the past",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que3);

        Question que4 = new Question(
                4,
                "I enjoy trying to understand complicated ideas",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que4);

        Question que5 = new Question(
                5,
                "I usually don't need the support from other people to complete tasks",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que5);

        Question que6 = new Question(
                6,
                "I start tasks in advance, so that I have plenty of time to finish",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que6);

        Question que7 = new Question(
                7,
                "I am a private person",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que7);

        Question que8 = new Question(
                8,
                "I prefer keeping to myself rather than chatting with new acquaintances",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que8);

        Question que9 = new Question(
                9,
                "I am an ambitious person",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que9);

        Question que10 = new Question(
                10,
                "I try to avoid conflict whenever possible",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que10);


        return questionsList;

    }

    public static ArrayList<Result> getResults(){

        ArrayList<Result> resultsList = new ArrayList<Result>();

        ArrayList<String> introvertList = new ArrayList<String>();
        introvertList.add("- Accountancy");
        introvertList.add("- Digital Marketing");
        introvertList.add("- Graphic Design");
        introvertList.add("- Video Editing");

        ArrayList<String> omnivertList = new ArrayList<String>();
        omnivertList.add("- Software Development");
        omnivertList.add("- Actuarial Science");
        omnivertList.add("- Architecture");
        omnivertList.add("- Content Management");

        ArrayList<String> ambivertList = new ArrayList<String>();
        ambivertList.add("- Occupational Therapy");
        ambivertList.add("- General Management");
        ambivertList.add("- Financial Advisor");
        ambivertList.add("- Criminal Investigation");

        ArrayList<String> extrovertList = new ArrayList<String>();
        extrovertList.add("- Law");
        extrovertList.add("- Teaching");
        extrovertList.add("- Event Planning");
        extrovertList.add("- Sales Representative");

        Result result1 = new Result(
                1,
                "Introvert",
                "A typically reserved or quiet person who tends to be introspective and enjoys spending time alone",
                introvertList

        );
        resultsList.add(result1);

        Result result2 = new Result(
                2,
                "Omnivert",
                "Someone who is an introvert and extrovert depending on situations",
                omnivertList
        );
        resultsList.add(result2);

        Result result3 = new Result(
                3,
                "Ambivert",
                "A person who has a balance of extrovert and introvert features in their personality.",
                ambivertList
        );
        resultsList.add(result3);

        Result result4 = new Result(
                4,
                "Extrovert",
                "A typically gregarious and unreserved person who enjoys and seeks out social interaction",
                extrovertList
        );
        resultsList.add(result4);


        return resultsList;
    }


}
