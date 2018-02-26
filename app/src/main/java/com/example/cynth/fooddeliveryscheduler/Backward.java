package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Backward extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backward);
        out = (EditText)this.findViewById(R.id.editText5); // associates xml objects into java
        try {
            MainActivity.current.cursorBackward();
            out.setText("Cursor moved backwards.");
        } catch (EndOfListException ex) {
            out.setText("Cursor is at the head and has nothing behind it. Cannot move cursor backwards.");
        }
    }
    EditText out;
}
