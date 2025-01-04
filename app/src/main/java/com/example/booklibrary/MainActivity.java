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

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.bookList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Firebase Database Reference
        databaseReference = FirebaseDatabase.getInstance().getReference("books");

        // Initialize ArrayList
        books = new ArrayList<>();

        // Load Data from Firebase
        fetchDataFromFirebase();
    }

    private void fetchDataFromFirebase() {
        databaseReference.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                books.clear(); // Clear the list to avoid duplication
                for (DataSnapshot bookSnapshot : snapshot.getChildren()) {
                    // Extract individual book data
                    Model model = bookSnapshot.getValue(Model.class);
                    if (model != null) {
                        books.add(model); // Add to the list
                    }
                }

                // Log the size of the list to debug
                String TAG = "MainActivity_debug";
                Log.d(TAG, "Total books loaded: " + books.size());

                // Notify adapter of data changes
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
