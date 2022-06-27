package com.example.imbizo_foundation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizResult extends AppCompatActivity {

    TextView tvPersonalityType, tvPersonalityDesc;
    int quizScore;
    Result mResult;
    ArrayList<Result> mResultList = new ArrayList<Result>();
    Button btn_home;
    ListView careerListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        tvPersonalityType = findViewById(R.id.tv_personality_type);
        tvPersonalityDesc = findViewById(R.id.tv_description);
        btn_home = findViewById(R.id.btn_home_page);
        careerListView = findViewById(R.id.lv_career);

        mResultList = Constants.getResults();

        quizScore = Constants.resultTotal;

        if(quizScore<=5){
            mResult = mResultList.get(3);
        }else if(quizScore>15&&quizScore<=25){
            mResult = mResultList.get(2);
        }else if(quizScore>25&&quizScore<=35){
            mResult = mResultList.get(1);
        }else{
            mResult = mResultList.get(0);
        }

        tvPersonalityType.setText(mResult.getPersonalityType());
        tvPersonalityDesc.setText(mResult.getPersonalityDescription());

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mResult.getPersonalityCareers());

        careerListView.setAdapter(arrayAdapter);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHome = new Intent(QuizResult.this, HomePage.class);
                startActivity(intentHome);
                finish();
            }
        });



    }
}