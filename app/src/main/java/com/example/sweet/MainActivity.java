package com.example.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public void playEasy(View view){
        startActivity(new Intent(this,Easy.class));
    }
    public void playMiddle(View view){
        startActivity(new Intent(this,Middle.class));
    }
    public void playHard(View view){
        startActivity(new Intent(this,Hard.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}