package com.example.imbizo_foundation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity{

    ArrayList<CoursesModel> coursesModels = new ArrayList<>();

    ImageView btnNav;

    int[] coursesImages = {R.drawable.va_programming, R.drawable.va_stocks, R.drawable.va_photography, R.drawable.va_teaching,
            R.drawable.va_fitness, R.drawable.va_music, R.drawable.va_art };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnNav = findViewById(R.id.btnNav);

        NavigationView navView = findViewById(R.id.navigation_view);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpCoursesModels();
        C_RecyclerViewAdapter adapter = new C_RecyclerViewAdapter(this, coursesModels);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Opens the side menu
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Gets selected item
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {


                    case R.id.nav_test:
                        //Go to Tutorial activity
                        Intent quizIntent = new Intent(HomePage.this, QuizActivity.class);
                        startActivity(quizIntent);
                        finish();
                        break;
                    default:
                        return true;

                }

                return true;
            }
        });


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