package com.example.imbizo_foundation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    ArrayList<CoursesModel> coursesModels = new ArrayList<>();

    int[] coursesImages = {R.drawable.va_programming, R.drawable.va_stocks, R.drawable.va_photography, R.drawable.va_teaching,
            R.drawable.va_fitness, R.drawable.va_music, R.drawable.va_art };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpCoursesModels();
        C_RecyclerViewAdapter adapter = new C_RecyclerViewAdapter(this, coursesModels);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpCoursesModels() {
        String[] coursesNames = getResources().getStringArray(R.array.Courses_txt);
        String[] coursesTime = getResources().getStringArray(R.array.Courses_Time);
        String[] coursesRating = getResources().getStringArray(R.array.Courses_Rating);

        for (int i = 0; i < coursesNames.length; i++) {
            coursesModels.add(new CoursesModel(coursesNames[i],
                    coursesTime[i],
                    coursesRating[i],
                    coursesImages[i]));
        }
    }
}