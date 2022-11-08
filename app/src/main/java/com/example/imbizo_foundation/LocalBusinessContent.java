package com.example.imbizo_foundation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LocalBusinessContent extends AppCompatActivity {

    DatabaseReference businessDatabase;

    ArrayList<LocalBusinessContentModel> businessContentList = new ArrayList<LocalBusinessContentModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_business_content);

        TextView businessName = findViewById(R.id.tv_businessContentName);
        TextView businessIntroduction = findViewById(R.id.tv_businessContentIntroduction);
        TextView businessFirstParagraph = findViewById(R.id.tv_businessContentFirstParagraph);
        TextView businessSecondParagraph = findViewById(R.id.tv_businessContentSecondParagraph);
        ImageView imageView = findViewById(R.id.imageView);

        businessDatabase = FirebaseDatabase.getInstance().getReference("Local Business Content");
        String businessNameText = "";
        Intent intent = getIntent();

        businessNameText = intent.getStringExtra("Business Name");
        int businessPosition = intent.getIntExtra("Business Position", 10);
        int listBusinessSize = intent.getIntExtra("List Size", 10);

        businessDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    LocalBusinessContentModel businessContentModel = dataSnapshot.getValue(LocalBusinessContentModel.class);

                    businessContentList.add(businessContentModel);

                    int listSize = businessContentList.size();

                    if(listSize == listBusinessSize){
                        LocalBusinessContentModel selectedInspiration = businessContentList.get(businessPosition);

                        Glide.with(getApplicationContext()).load(selectedInspiration.businessURL).into(imageView);
                        businessName.setText(selectedInspiration.businessName);
                        businessIntroduction.setText(selectedInspiration.businessIntro);
                        businessFirstParagraph.setText(selectedInspiration.businessPara1);
                        businessSecondParagraph.setText(selectedInspiration.businessPara2);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });


    }
}