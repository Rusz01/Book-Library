
package com.example.booklibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<ItemHolder> {

    Context myContext;
    ArrayList<Model> books;
    private Basket myBasket;

    public MainAdapter(Context myContext, ArrayList<Model> books) {
        this.myContext = myContext;
        this.books = books;
        myBasket = new Basket(myContext);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.activity_book_list, parent, false);
        return new ItemHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Model bookId = books.get(position);
        holder.setBasket(myBasket);
        holder.bookName.setText(books.get(position).getBookName());
        holder.bookAuthors.setText(books.get(position).getBookAuthors());
        holder.bookPublisher.setText(books.get(position).getBookPublisher());



        // Load book image using Picasso
        Picasso.get().load(books.get(position).getBookImage()).into(holder.bookImage);

    }


    @Override
    public int getItemCount() {
        return books.size();
    }



}