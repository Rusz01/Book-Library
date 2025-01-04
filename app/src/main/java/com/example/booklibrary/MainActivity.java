package com.example.booklibrary;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MainAdapter adapter;
    ArrayList<Model> books;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.bookList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        databaseReference = FirebaseDatabase.getInstance().getReference("books");


        books = new ArrayList<>();


        fetchDataFromFirebase();
    }

    private void fetchDataFromFirebase() {
        databaseReference.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                books.clear();
                for (DataSnapshot bookSnapshot : snapshot.getChildren()) {

                    Model model = bookSnapshot.getValue(Model.class);
                    if (model != null) {
                        books.add(model);
                    }
                }


                String TAG = "MainActivity_debug";
                Log.d(TAG, "Total books loaded: " + books.size());


                if (adapter == null) {
                    adapter = new MainAdapter(MainActivity.this, books);
                    recyclerView.setAdapter(adapter);
                } else {
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, error.getMessage());
            }
        });
    }
}
