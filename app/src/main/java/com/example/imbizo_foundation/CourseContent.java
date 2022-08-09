package com.example.imbizo_foundation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CourseContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);

        String courseName = "";

        TextView txt = findViewById(R.id.tv_courseContentName);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            courseName = extras.getString("courseName");
        }

        txt.setText(courseName);
    }
}