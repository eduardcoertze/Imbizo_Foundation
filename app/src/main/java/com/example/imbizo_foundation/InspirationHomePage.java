package com.example.imbizo_foundation;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class InspirationHomePage extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<InspirationModel> inspirationList = new ArrayList<>();
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration_home_page);
        database = FirebaseDatabase.getInstance().getReference("Inspiration");
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        InspirationAdapter adapter = new InspirationAdapter(this, inspirationList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    InspirationModel inspirationModel = dataSnapshot.getValue(InspirationModel.class);
                    inspirationList.add(inspirationModel);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onItemClick(int position) {

        String Inspiration = "";
        Inspiration = inspirationList.get(position).entrepreneurName;

        Intent inspirationContentIntent = new Intent(InspirationHomePage.this, InspirationContent.class);
        inspirationContentIntent.putExtra("Inspiration Name", Inspiration);
        inspirationContentIntent.putExtra("Inspiration Position", position);
        inspirationContentIntent.putExtra("List Size", inspirationList.size());
        startActivity(inspirationContentIntent);
    }
}