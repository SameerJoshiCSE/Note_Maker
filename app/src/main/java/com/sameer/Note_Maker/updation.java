package com.sameer.Note_Maker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updation);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //This Project is done by Sameer Joshi Don Bosco Institute of Technology, Mumbai.
    public void update(View view){
        EditText sub=(EditText)findViewById(R.id.editTextTextPersonName6);
        EditText newnote=(EditText)findViewById(R.id.editTextTextPersonName7);
        String valuesub=sub.getText().toString();
        String valuenote=newnote.getText().toString();
        try{
            if(valuenote.equals("")==false && valuesub.equals("")==false){
                SQLiteDatabase data=openOrCreateDatabase("Notes",MODE_PRIVATE,null);
                Cursor c=data.rawQuery("SELECT EXISTS(SELECT * FROM notes WHERE subject='"+valuesub+"' LIMIT 1)",null);
                c.moveToFirst();
                if(c.getInt(0)==1){
                    data.execSQL("UPDATE notes SET note='"+valuenote+"' WHERE subject='"+valuesub+"'");
                    Toast.makeText(updation.this,"Note is updated",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(updation.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(updation.this, "Note does not exist", Toast.LENGTH_LONG).show();
                }

            }

            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}