package com.androapp.emmployeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchemployeeActivity extends AppCompatActivity {
    EditText ed1;
    AppCompatButton b1;
    String getid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchemployee);
        ed1=(EditText) findViewById(R.id.eid);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getid=ed1.getText().toString();
                Toast.makeText(getApplicationContext(), getid, Toast.LENGTH_SHORT).show();

            }
        });
    }
}