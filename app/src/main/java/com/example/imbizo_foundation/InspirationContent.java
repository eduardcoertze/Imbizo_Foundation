package com.example.imbizo_foundation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class InspirationContent extends AppCompatActivity {

    DatabaseReference inspirationDatabase;

    ArrayList<InspirationContentModel> inspirationContentList = new ArrayList<InspirationContentModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration_content);

        TextView inspirationName = findViewById(R.id.tv_inspirationContentName);
        TextView inspirationIntroduction = findViewById(R.id.tv_inspirationContentIntroduction);
        TextView inspirationFirstParagraph = findViewById(R.id.tv_inspirationContentFirstParagraph);
        TextView inspirationSecondParagraph = findViewById(R.id.tv_inspirationContentSecondParagraph);
        ImageView imageView = findViewById(R.id.imageView);

        inspirationDatabase = FirebaseDatabase.getInstance().getReference("Inspiration Content");
        String inspirationNameText = "";
        Intent intent = getIntent();

        inspirationNameText = intent.getStringExtra("Inspiration Name");
        int inspirationPosition = intent.getIntExtra("Inspiration Position", 10);
        int listInspirationSize = intent.getIntExtra("List Size", 10);

        inspirationDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    InspirationContentModel inspirationContentModel = dataSnapshot.getValue(InspirationContentModel.class);

                    inspirationContentList.add(inspirationContentModel);

                    int listSize = inspirationContentList.size();

                    if(listSize == listInspirationSize){
                        InspirationContentModel selectedInspiration = inspirationContentList.get(inspirationPosition);

                        inspirationName.setText(selectedInspiration.entrepreneurName);
                        inspirationIntroduction.setText(selectedInspiration.entrepreneurIntro);
                        inspirationFirstParagraph.setText(selectedInspiration.entrepreneurPara1);
                        inspirationSecondParagraph.setText(selectedInspiration.entrepreneurPara2);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}