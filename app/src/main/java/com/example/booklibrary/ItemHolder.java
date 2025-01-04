package com.example.booklibrary;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder {


    private Basket myBasket;
    private Context myContext;

    TextView bookName, bookAuthors, bookPublisher;
    ImageView bookImage;
    Button addBook, clearBook;


    public void setBasket(Basket myBasket) {
        this.myBasket = myBasket;

    }





    public ItemHolder(@NonNull View itemView) {
        super(itemView);

        bookName = itemView.findViewById(R.id.book_name);
        bookAuthors = itemView.findViewById(R.id.book_author);
        bookPublisher = itemView.findViewById(R.id.book_publisher);
        bookImage = itemView.findViewById(R.id.book_image);

        addBook = itemView.findViewById(R.id.book_btn);
        clearBook = itemView.findViewById(R.id.clear_btn);

        clearBook.setVisibility(View.GONE);

//        Model m = SelectedModel();

        addBook.setOnClickListener(v -> {

            showDatePicker(addBook, clearBook);
            addBook.setVisibility(View.GONE);
            clearBook.setVisibility(View.VISIBLE);

        });

        clearBook.setOnClickListener(v -> {
//            myBasket.clearBasket(m);
            myBasket.showBasket();
            clearBook.setVisibility(View.GONE);
            addBook.setVisibility(View.VISIBLE);
        });
    }

    private void showDatePicker(Button addBook, Button clearBook) {

        DatePickerDialog datePickerDialog = new DatePickerDialog(itemView.getContext(), (view, year, month, dayOfMonth) -> {
            String startDate = year + "-" + (month + 1) + "-" + dayOfMonth;

            DatePickerDialog endDatePicker = new DatePickerDialog(itemView.getContext(), (view1, year1, month1, dayOfMonth1) -> {
                String endDate = year1 + "-" + (month1 + 1) + "-" + dayOfMonth1;

//                Model m = SelectedModel();


//                myBasket.addToBasket(m);

//                String sDate = String.valueOf(startDate);
//                String eDate = String.valueOf(endDate);


                myBasket.showBasket();




            }, year, month, dayOfMonth);
            endDatePicker.setTitle("Select End Date");

            endDatePicker.setOnCancelListener(dialog -> {
                clearBook.setVisibility(View.GONE);
                addBook.setVisibility(View.VISIBLE);
            });

            endDatePicker.show();
        }, 2025, 0, 1); // Default date
        datePickerDialog.setTitle("Select Start Date");

        datePickerDialog.setOnCancelListener(dialog -> {
            clearBook.setVisibility(View.GONE);
            addBook.setVisibility(View.VISIBLE);
        });
        datePickerDialog.show();

    }

//    private Model SelectedModel() {
//        String m_name = bookName.getText().toString();
//
//        Model m = new Model(m_name);
//        return m;
//    }


}