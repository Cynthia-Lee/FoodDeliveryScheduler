package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Forward extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forward);
        out = (EditText)this.findViewById(R.id.editText4); // associates xml objects into java
        try {
            MainActivity.current.cursorForward();
            out.setText("Cursor moved forward.");
        } catch (EndOfListException ex) {
            out.setText("Cursor already at the end of the list. Cannot move cursor forward.");
        }
    }
    EditText out;
}
