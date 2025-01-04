package com.example.booklibrary;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PurchaseActivity extends AppCompatActivity {

    private TextView reservedBooksText;
    private Button purchaseButton, continueShoppingButton;
    private ArrayList<Model> reservedBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);


        reservedBooksText = findViewById(R.id.reserved_books_text);
        purchaseButton = findViewById(R.id.purchase_button);

        // Get reserved books from intent
        reservedBooks = (ArrayList<Model>) getIntent().getSerializableExtra("reservedBooks");
        if (reservedBooks != null && !reservedBooks.isEmpty()) {
            StringBuilder details = new StringBuilder();
            for (Model book : reservedBooks) {
                details.append("Book Name: ").append(book.getBookName()).append("\n");
                details.append("Author: ").append(book.getBookAuthors()).append("\n");
                details.append("Reserved From: ").append(book.getStartDate()).append("\n");
                details.append("Reserved Until: ").append(book.getEndDate()).append("\n");
                details.append("---------------------------------\n");
            }
            reservedBooksText.setText(details.toString());
        } else {
            reservedBooksText.setText("No books reserved.");
        }

        // Purchase button closes the app
        purchaseButton.setOnClickListener(v -> finishAffinity());


    }
}