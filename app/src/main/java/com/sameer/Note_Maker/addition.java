package com.sameer.Note_Maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    //This Project is done by Sameer Joshi Don Bosco Institute of Technology, Mumbai.
    public void add(View view){
        EditText sub=(EditText)findViewById(R.id.editTextTextPersonName3);
        EditText n=(EditText)findViewById(R.id.editTextTextPersonName2);
        String valuesub=sub.getText().toString();
        String valuenote=n.getText().toString();
        Log.i("sub",""+valuesub);
        Log.i("note",""+valuenote);
        try{
            if(valuesub.equals("")==false || valuenote.equals("")==false){
                SQLiteDatabase data=this.openOrCreateDatabase("Notes",MODE_PRIVATE,null);
                data.execSQL("CREATE TABLE IF NOT EXISTS notes(note VARCHAR,subject VARCHAR,current VARCHAR)");
                data.execSQL("INSERT INTO notes VALUES('"+valuenote+"','"+valuesub+"',datetime('now'));");
                Toast.makeText(addition.this,"Note is added",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(addition.this,MainActivity.class);
                startActivity(intent);
                Log.i("value added","value added");
                //data.execSQL("DROP TABLE notes");
            }
            else{
                Toast.makeText(addition.this, "Please enter valid values", Toast.LENGTH_LONG).show();
            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}