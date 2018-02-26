package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Tail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tail);
        out = (EditText)this.findViewById(R.id.editText7); // associates xml objects into java
        MainActivity.current.resetCursorToTail();
        if (MainActivity.current.getCursor() != null) {
            out.setText("Cursor is at tail.");
        } else {
            out.setText("Cursor cannot be set to tail because tail does not exist.");
        }
    }
    EditText out;
}
