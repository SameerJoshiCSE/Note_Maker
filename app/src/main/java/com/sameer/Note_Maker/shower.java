package com.sameer.Note_Maker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class shower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Show();

    }
    public void Show(){
        try{
            SQLiteDatabase data=this.openOrCreateDatabase("Notes",MODE_PRIVATE,null);
            Cursor c=data.rawQuery("SELECT * FROM notes",null);
            int sub=c.getColumnIndex("subject");
            int n=c.getColumnIndex("note");
            int dt=c.getColumnIndex("current");
            c.moveToFirst();
            c.moveToFirst();
            StringBuffer buffer=new StringBuffer();
            if(c.moveToFirst()){
                do{
                    buffer.append("Subject: "+ c.getString(sub)+ "\n");
                    buffer.append("Note: "+ c.getString(n)+ "\n");
                    buffer.append("Date and time: "+ c.getString(dt)+ "\n");
                    buffer.append("\n");
                }while(c.moveToNext());
                showmessage("Data",buffer.toString());
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void showmessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}