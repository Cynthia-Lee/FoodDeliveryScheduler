package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Swap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap);
        out = (EditText)this.findViewById(R.id.editText8); // associates xml objects into java
        if (MainActivity.current == MainActivity.billy) { // switch to mike
            MainActivity.current = MainActivity.mike;
            out.setText("Money Mike's List Selected.");
        } else if (MainActivity.current == MainActivity.mike) { // switch to billy
            MainActivity.current = MainActivity.billy;
            out.setText("Biz Billy's List Selected.");
        }
    }
    EditText out;
}
