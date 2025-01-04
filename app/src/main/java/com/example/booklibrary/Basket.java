package com.example.booklibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Basket {
    private Context context;
    private ArrayList<Model> myBasket;
    private AlertDialog.Builder builder;

    public Basket(Context context) {
        this.context = context;
        this.myBasket = new ArrayList<>();
    }

    private String basketItemsInString(){

        String output="\n Products in the Basket";
        output += "\n ---------------------------------";
        int overallTotal=0;

        for (Model eachModel : myBasket){


            output += "\n Book Name: " + eachModel.getBookName();
            output += "\n Author: " + eachModel.getBookAuthors();
            output += "\n ---------------------------------";
        }


        return output;
    }

    public void showBasket() {
        builder = new AlertDialog.Builder(context);

        builder.setTitle("Items in the basket");

        String basketItems = basketItemsInString();

        //Setting message manually and performing action on button click
        builder.setMessage(basketItems + "\nDo you want to Continue shopping?")
                .setCancelable(false)
                .setNegativeButton("Go to Purchase Screen", (dialog, id) -> {
                    //  Action for 'NO' Button
                    Toast.makeText(context.getApplicationContext(),"GO TO PURCHASES",
                            Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setPositiveButton("Stay on the Products Page", (dialog, id) -> {
                    dialog.cancel();
                    /* finish();
                    Toast.makeText(getApplicationContext(),"you choose yes action for alert-box",
                            Toast.LENGTH_SHORT).show();*/
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("My Basket");
        alert.show();
    }

    public boolean addToBasket(Model m) {
        if (!myBasket.contains(m)) {
            myBasket.add(m);
            return true;
        }
        return false;
    }

    public boolean clearBasket(Model m) {
        Iterator<Model> iterator = myBasket.iterator();
        while (iterator.hasNext()) {
            Model eachModel = iterator.next();
            if (Objects.equals(eachModel.getBookName(), m.getBookName())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }


}