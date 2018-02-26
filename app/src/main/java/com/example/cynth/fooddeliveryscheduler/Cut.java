package com.example.cynth.fooddeliveryscheduler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Cut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut);
        out = (EditText)this.findViewById(R.id.editText2); // associates xml objects into java
        try {
            MainActivity.tempDel = MainActivity.current.removeCursor();
            out.setText("Cursor is cut.");
        } catch (EndOfListException ex) {
            out.setText("Invalid order at cursor. Cannot remove order from the place to be cut.");
        } catch (IllegalArgumentException ex) {
            out.setText("Invalid order at cursor. Cannot cut.");
        }
    }
    EditText out;

}
