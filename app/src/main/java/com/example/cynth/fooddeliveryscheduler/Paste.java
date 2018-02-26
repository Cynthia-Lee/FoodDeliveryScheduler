package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Paste extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paste);
        out = (EditText)this.findViewById(R.id.editText3); // associates xml objects into java
        try {
            MainActivity.current.insertAfterCursor(MainActivity.tempDel);
            MainActivity.tempDel = null;
            out.setText("Delivery pasted successfully.");
        } catch (IllegalArgumentException ex) {
            out.setText("No order could be pasted. Cannot paste order.");
        }
    }
    EditText out;
}
