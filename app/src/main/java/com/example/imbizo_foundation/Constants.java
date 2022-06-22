package com.example.imbizo_foundation;

import java.util.ArrayList;

public class Constants {

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
                1,
                "I prefer to work in an active, bustling office",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que2);

        Question que3 = new Question(
                1,
                "I like to do things the way they have been done in the past",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que3);

        Question que4 = new Question(
                1,
                "I enjoy trying to understand complicated ideas",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que4);

        Question que5 = new Question(
                1,
                "I need support from other people",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que5);

        Question que6 = new Question(
                1,
                "I start tasks in advance, so that I have plenty of time to finish",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que6);

        Question que7 = new Question(
                1,
                "I am a private person I am a private person",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que7);

        Question que8 = new Question(
                1,
                "I enjoy chatting with new acquaintances",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que8);

        Question que9 = new Question(
                1,
                "I am an ambitious person",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que9);

        Question que10 = new Question(
                1,
                "I try to avoid conflict",
                "Strongly Agree",
                "Agree",
                "Neutral",
                "Disagree",
                "Strongly Disagree"
        );

        questionsList.add(que10);


        return questionsList;

    }


}
