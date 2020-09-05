package com.sameer.mccexp12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class deletion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletion);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void delete(View view){
        EditText sub=(EditText)findViewById(R.id.editTextTextPersonName);
        String valuesub=sub.getText().toString();
        try{
            SQLiteDatabase data=this.openOrCreateDatabase("Notes",MODE_PRIVATE,null);
            Cursor c=data.rawQuery("SELECT EXISTS(SELECT * FROM notes WHERE subject='"+valuesub+"' LIMIT 1)",null);
            c.moveToFirst();
            if(c.getInt(0)==1){
                /*while(c!=null){
                    Log.i("in while s",c.getString('s'));
                    c.moveToNext();
                    j++;
                    Log.i("valeu",""+j);
                }*/
                data.execSQL("DELETE FROM notes WHERE subject='"+valuesub+"'");
                c.close();
                Toast.makeText(deletion.this,"Note is deleted",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(deletion.this,MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(deletion.this, "Note does not exist", Toast.LENGTH_LONG).show();
                c.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //This Project is done by Sameer Joshi Don Bosco Institute of Technology, Mumbai.
    public void alldelete(View view){
        try{
            SQLiteDatabase data=this.openOrCreateDatabase("Notes",MODE_PRIVATE,null);
            Cursor c=data.rawQuery("SELECT EXISTS(SELECT * FROM notes LIMIT 1)",null);
            c.moveToFirst();
            if(c.getInt(0)==1){
                data.execSQL("DELETE FROM notes");
                Toast.makeText(deletion.this,"All notes are deleted",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(deletion.this,MainActivity.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(deletion.this, "No record Exist", Toast.LENGTH_LONG).show();
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}