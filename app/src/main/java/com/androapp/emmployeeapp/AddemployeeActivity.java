package com.androapp.emmployeeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddemployeeActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4;
    AppCompatButton b1;
    String getcode,getname,getdes,getmob;
    DbHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);
        ed1=(EditText) findViewById(R.id.eid);
        ed2=(EditText) findViewById(R.id.ename);
        ed3=(EditText) findViewById(R.id.des);
        ed4=(EditText) findViewById(R.id.mob);
        b1=(AppCompatButton) findViewById(R.id.sub);
        mydb=new DbHelper(this);
        mydb.getReadableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcode=ed1.getText().toString();
                getname=ed2.getText().toString();
                getdes=ed3.getText().toString();
                getmob=ed4.getText().toString();
                boolean status=mydb.insertEmployee(getcode,getname,getdes,getmob);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext() ,"Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}