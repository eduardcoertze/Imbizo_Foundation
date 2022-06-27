package com.example.imbizo_foundation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    TextView tvProgress, tvQuestion, tvOptionOne, tvOptionTwo, tvOptionThree, tvOptionFour, tvOptionFive;
    Button btnSubmit;

    int currentPosition = 1;
    int selectedOptionPosition = 0;
    int resultSum = 0;
    ArrayList<Question> mQuestionsList = new ArrayList<Question>();
    ArrayList<Integer> resultArrayList = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        progressBar=findViewById(R.id.progress_bar);
        tvProgress = findViewById(R.id.tv_progress);
        tvQuestion = findViewById(R.id.tv_question);
        tvOptionOne = findViewById(R.id.tv_option1);
        tvOptionTwo = findViewById(R.id.tv_option2);
        tvOptionThree = findViewById(R.id.tv_option3);
        tvOptionFour = findViewById(R.id.tv_option4);
        tvOptionFive = findViewById(R.id.tv_option5);

        btnSubmit = findViewById(R.id.btn_submit);
        mQuestionsList = Constants.getQuestions();

        setQuestion();

        tvOptionOne.setOnClickListener(this);
        tvOptionTwo.setOnClickListener(this);
        tvOptionThree.setOnClickListener(this);
        tvOptionFour.setOnClickListener(this);
        tvOptionFive.setOnClickListener(this);

        btnSubmit.setOnClickListener(this);

    }

    private void setQuestion() {

        Question question = mQuestionsList.get(currentPosition-1);

        defaultOptionView();

        if (currentPosition == mQuestionsList.size()) {
            btnSubmit.setText("SUBMIT");
        } else {
            btnSubmit.setText("SUBMIT");
        }

        progressBar.setProgress(currentPosition);

        tvProgress.setText(currentPosition + "/" + progressBar.getMax());

        tvQuestion.setText(question.getQuestion());
        tvOptionOne.setText(question.getOptionOne());
        tvOptionTwo.setText(question.getOptionTwo());
        tvOptionThree.setText(question.getOptionThree());
        tvOptionFour.setText(question.getOptionFour());
        tvOptionFive.setText(question.getOptionFive());
    }

    @Override
    public void onClick(View view) {

        final int id = view.getId();

        switch (id){

            case R.id.tv_option1:
                selectedOptionView(tvOptionOne,1);
                break;
            case R.id.tv_option2:
                selectedOptionView(tvOptionTwo,2);
                break;
            case R.id.tv_option3:
                selectedOptionView(tvOptionThree,3);
                break;
            case R.id.tv_option4:
                selectedOptionView(tvOptionFour,4);
                break;
            case R.id.tv_option5:
                selectedOptionView(tvOptionFive,5);
                break;
            case R.id.btn_submit:

                resultArrayList.add(selectedOptionPosition);

                if (selectedOptionPosition == 0) {

                    currentPosition++;

                    if(currentPosition <= mQuestionsList.size()) {

                            setQuestion();
                        }
                        else {

                            for (int i =0; i < resultArrayList.size(); i++){
                                resultSum += resultArrayList.get(i);
                            }

                            Constants.resultTotal = resultSum;

                        Intent resultActivity = new Intent(QuizActivity.this, QuizResult.class);
                        //resultActivity.putExtra(String.valueOf(Constants.resultTotal),resultSum);
                        startActivity(resultActivity);
                        finish();
                        }

                }else {
                    Question question = mQuestionsList.get(currentPosition - 1);

                    if (currentPosition == mQuestionsList.size()) {
                        btnSubmit.setText("VIEW RESULTS");
                    } else {
                        btnSubmit.setText("GO TO NEXT QUESTION");
                    }

                    selectedOptionPosition = 0;
                }



                //

                break;
        }

    }


    private void defaultOptionView(){

        ArrayList<TextView> options = new ArrayList<TextView>();

        options.add(tvOptionOne);
        options.add(tvOptionTwo);
        options.add(tvOptionThree);
        options.add(tvOptionFour);
        options.add(tvOptionFive);

        for (TextView option:options ) {
           // option.setTextColor(Integer.parseInt("#7A8089"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }


    }

    private void selectedOptionView(TextView tv, int selectedOptionNum){

        defaultOptionView();

        selectedOptionPosition = selectedOptionNum;

        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setBackground(ContextCompat.getDrawable(this,R.drawable.selected_option_border_background));

    }


}