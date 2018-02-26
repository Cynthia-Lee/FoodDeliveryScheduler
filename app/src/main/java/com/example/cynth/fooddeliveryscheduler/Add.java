package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        source = (EditText)this.findViewById(R.id.source); // associates xml objects into java
        dest = (EditText)this.findViewById(R.id.dest);
        instruct = (EditText) this.findViewById(R.id.instruct);
    }

    EditText source;
    EditText dest;
    EditText instruct;
    public void add(View view) { // tells android that it can call this method
        String s = source.getText().toString(); // gets string that the user enters in the text box
        String d = dest.getText().toString();
        String i = instruct.getText().toString();
        Delivery newDelivery = new Delivery(s,d,i);
        MainActivity.current.insertAfterCursor(newDelivery);
        source.setText(""); // clear the box so they can enter a new name
        dest.setText("");
        instruct.setText("");
    }
}
