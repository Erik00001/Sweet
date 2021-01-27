package com.example.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Win extends AppCompatActivity {
    public void again(View view){
        startActivity(new Intent(this,Easy.class));
        finish();
    }
    public void menu(View view){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
    }
}