package com.androapp.emmployeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchemployeeActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1,b2;
    String getId,getName,getDes,getMob;
    DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchemployee);
        ed1=(EditText) findViewById(R.id.eid);
        ed2=(EditText) findViewById(R.id.ename);
        ed3=(EditText) findViewById(R.id.des);
        ed4=(EditText) findViewById(R.id.mob);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.delete);
        mydb=new DbHelper(this);
        mydb.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getId=ed1.getText().toString();
                Cursor c=mydb.searchEmployee(getId);
                if (c.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(), "No Employee Fount", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getName=c.getString(2);
                        getDes=c.getString(3);
                        getMob=c.getString(4);
                    }
                    ed2.setText(getName);
                    ed3.setText(getDes);
                    ed4.setText(getMob);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}