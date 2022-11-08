package com.example.imbizo_foundation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LocalBusiness extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<LocalBusinessModel> localBusinessModelArrayList = new ArrayList<>();
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_business);

        database = FirebaseDatabase.getInstance().getReference("Local Business");
        RecyclerView recyclerView = findViewById(R.id.mRecyclerViewLocalBusiness);

        LocalBusinessAdapter adapter = new LocalBusinessAdapter(this, localBusinessModelArrayList, this);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    LocalBusinessModel businessModelModel = dataSnapshot.getValue(LocalBusinessModel.class);
                    localBusinessModelArrayList.add(businessModelModel);
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

        String Business = "";
        Business = localBusinessModelArrayList.get(position).localBusinessName;

        Intent businessContentIntent = new Intent(LocalBusiness.this, LocalBusinessContent.class);
        businessContentIntent.putExtra("Business Name", Business);
        businessContentIntent.putExtra("Business Position", position);
        businessContentIntent.putExtra("List Size", localBusinessModelArrayList.size());
        startActivity(businessContentIntent);

    }
}