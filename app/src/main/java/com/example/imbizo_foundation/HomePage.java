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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity{

    ArrayList<CoursesModel> courseList = new ArrayList<>();

    ImageView btnNav;

    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        database = FirebaseDatabase.getInstance().getReference("Course");

        btnNav = findViewById(R.id.btnNav);

        NavigationView navView = findViewById(R.id.navigation_view);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        //setUpCoursesModels();


        C_RecyclerViewAdapter adapter = new C_RecyclerViewAdapter(this, courseList);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    CoursesModel coursesModel = dataSnapshot.getValue(CoursesModel.class);


                    courseList.add(coursesModel);
                }

                adapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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

//    private void setUpCoursesModels() {
//        String[] coursesNames = getResources().getStringArray(R.array.Courses_txt);
//        String[] coursesTime = getResources().getStringArray(R.array.Courses_Time);
//        String[] coursesRating = getResources().getStringArray(R.array.Courses_Rating);
//
//        for (int i = 0; i < coursesNames.length; i++) {
//            courseList.add(new CoursesModel(coursesNames[i],
//                    coursesTime[i],
//                    coursesRating[i],
//                    coursesImages[i]));
//        }
//    }

//    private void setUpCoursesModels() {
//        String[] coursesNames = getResources().getStringArray(R.array.Courses_txt);
//        String[] coursesTime = getResources().getStringArray(R.array.Courses_Time);
//        String[] coursesRating = getResources().getStringArray(R.array.Courses_Rating);
//
//        for (int i = 0; i < coursesNames.length; i++) {
//            courseList.add(new CoursesModel(coursesNames[i],
//                    coursesTime[i],
//                    coursesImages[i]));
//        }
//    }


}