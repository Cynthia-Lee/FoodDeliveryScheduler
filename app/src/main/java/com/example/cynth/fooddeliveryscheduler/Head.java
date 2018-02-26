package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Head extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        out = (EditText)this.findViewById(R.id.editText6); // associates xml objects into java
        MainActivity.current.resetCursorToHead();
        if (MainActivity.current.getCursor() != null) {
            out.setText("Cursor is at head.");
        } else {
            out.setText("Cursor cannot be set to head because head does not exist.");
        }
    }
    EditText out;
}
