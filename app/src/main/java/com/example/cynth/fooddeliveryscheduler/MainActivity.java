package com.example.cynth.fooddeliveryscheduler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected static DeliveryList billy = new DeliveryList();
    protected static DeliveryList mike = new DeliveryList();
    protected static DeliveryList current = billy;
    protected static Delivery tempDel = null;

    public void switchToPick(View view) {
        Intent i = new Intent(getApplicationContext(),Print.class);
        startActivity(i);
    }
    public void switchToAdd(View view) {
        Intent i = new Intent(getApplicationContext(),Add.class);
        startActivity(i);
    }
    public void remove(View view) {
        Intent i = new Intent(getApplicationContext(),Remove.class);
        startActivity(i);
    }
    public void cut(View view) {
        Intent i = new Intent(getApplicationContext(),Cut.class);
        startActivity(i);
    }
    public void paste(View view) {
        Intent i = new Intent(getApplicationContext(),Paste.class);
        startActivity(i);
    }
    public void head(View view) {
        Intent i = new Intent(getApplicationContext(),Head.class);
        startActivity(i);
        //current.resetCursorToHead();
    }
    public void tail(View view) {
        Intent i = new Intent(getApplicationContext(),Tail.class);
        startActivity(i);
        //current.resetCursorToTail();
    }
    public void forward(View view) {
        Intent i = new Intent(getApplicationContext(),Forward.class);
        startActivity(i);
    }
    public void backward(View view) {
        Intent i = new Intent(getApplicationContext(),Backward.class);
        startActivity(i);
    }
    public void swap(View view) {
        Intent i = new Intent(getApplicationContext(),Swap.class);
        startActivity(i);
    }
}
