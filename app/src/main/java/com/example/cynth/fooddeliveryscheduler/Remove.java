package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Remove extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
        out = (EditText)this.findViewById(R.id.editText); // associates xml objects into java
        try {
            out.setText("Delivery to " + MainActivity.current.removeCursor().getDest() + " removed.");
        } catch (EndOfListException ex) {
            out.setText("Invalid order at cursor. Cannot remove.");
        }
    }
    EditText out;

}
