package com.example.imbizo_foundation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseContent extends AppCompatActivity {

    DatabaseReference courseDatabase;

    ArrayList<CourseContentModel> courseContentList = new ArrayList<CourseContentModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);

        TextView courseName = findViewById(R.id.tv_courseContentName);
        TextView courseDescription = findViewById(R.id.tv_courseContentDescription);
        TextView firstParagraphTitle = findViewById(R.id.tv_courseContentFirstParagraphTitle);
        TextView firstParagraph = findViewById(R.id.tv_courseContentFirstParagraph);
        TextView secondParagraphTitle = findViewById(R.id.tv_courseContentSecondParagraphTitle);
        TextView secondParagraph = findViewById(R.id.tv_courseContentSecondParagraph);
        TextView youtubeLink = findViewById(R.id.tv_courseContentYoutubeLink);

        courseDatabase = FirebaseDatabase.getInstance().getReference("Course Content");

        String courseNameText = "";

        Intent intent = getIntent();

        courseNameText = intent.getStringExtra("Course Name");
        int coursePosition = intent.getIntExtra("Course Position", 10);
        int listCourseSize = intent.getIntExtra("List Size", 10);

        courseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    CourseContentModel coursesContentModel = dataSnapshot.getValue(CourseContentModel.class);

                    courseContentList.add(coursesContentModel);

                    int listSize = courseContentList.size();

                    if(listSize == listCourseSize){
                        CourseContentModel selectedCourse = courseContentList.get(coursePosition);

                        courseName.setText(selectedCourse.courseName);
                        courseDescription.setText(selectedCourse.courseDescription);
                        firstParagraphTitle.setText(selectedCourse.getFirstParagraphTitle());
                        firstParagraph.setText(selectedCourse.firstParagraph);
                        secondParagraphTitle.setText(selectedCourse.getSecondParagraphTitle());
                        secondParagraph.setText(selectedCourse.secondParagraph);
                        youtubeLink.setText(selectedCourse.youtubeLink);
                    }


                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}