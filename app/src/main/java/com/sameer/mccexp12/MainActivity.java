package com.sameer.mccexp12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void toAdd(View view){
        Intent intent=new Intent(MainActivity.this,addition.class);
        startActivity(intent);

    }
    //This Project is done by Sameer Joshi Don Bosco Institute of Technology, Mumbai.
    public void toDelete(View view){
        Intent intent=new Intent(MainActivity.this,deletion.class);
        startActivity(intent);
    }
    public void toUpdate(View view){
        Intent intent=new Intent(MainActivity.this,updation.class);
        startActivity(intent);
    }
    public void toShow(View view){
        Intent intent=new Intent(MainActivity.this,shower.class);
        startActivity(intent);
    }
}