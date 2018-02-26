package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Print extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        //in = (EditText)this.findViewById(R.id.input); // associates xml objects into java
        list = (EditText)this.findViewById(R.id.list);
        subtitle = (TextView)this.findViewById(R.id.listName);
    }
    @Override
    protected void onResume() { // saves the previous names when startup
        super.onResume();
        //in.setText(""); // clear the box so they can enter a new name
        if (MainActivity.current == MainActivity.billy) {
            subtitle.setText("Biz Billy's Deliveries:");
        } else if (MainActivity.current == MainActivity.mike) {
            subtitle.setText("Money Mike's Deliveries:");
        }
        list.setText(MainActivity.current.toString());
        //subtitle.setText(Hat.hatSize()+" people in the hat so far.");
    }
    //EditText in;
    EditText list;
    TextView subtitle;
}
