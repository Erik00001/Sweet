package com.example.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Easy extends AppCompatActivity {
    TextView tvTime;
    int easyTime=21;
    public static int selected[]= selected=new int[4];

    ArrayList<Integer> numbers=new ArrayList<>();
    ArrayList<ImageView> images=new ArrayList<>();
    ImageView img1,img2,img3,img4;

    public void updateTimer(int secondsLeft){
        String secondPart=Integer.toString(secondsLeft);
        if(secondsLeft<=9){
            secondPart="0"+secondsLeft;
        }
        tvTime.setText(0+":"+secondPart);

    }

    public void activityEasyPlay(){
        Intent intent=new Intent(this,EasyPlay.class);
        startActivity(intent);
    }

    public void setImages(){

        images.add(img1);
        images.add(img2);
        images.add(img3);
        images.add(img4);

       /* numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        numbers.add(15);
        numbers.add(16);
        numbers.add(17);
        numbers.add(18);
        numbers.add(19);
        numbers.add(20);
        numbers.add(21);
        numbers.add(22);
        numbers.add(23);
        numbers.add(24);
        numbers.add(25);
        numbers.add(26);
        numbers.add(27);*/
      for(int j=0;j<=27;j++){
          numbers.add(j);
      }




        Collections.shuffle(numbers);


        for(int i=0;i<images.size();i++){
            selected[i]=numbers.get(i);
            String imgName="cake"+numbers.get(i);
            int id=getResources().getIdentifier(imgName,"drawable",Easy.this.getPackageName());
            images.get(i).setImageResource(id);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        tvTime=findViewById(R.id.tvTime);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);


        setImages();



        new CountDownTimer(20000,1000){

            @Override
            public void onTick(long l) {

                updateTimer(--easyTime);
            }

            @Override
            public void onFinish() {
                tvTime.setText("0:00");
                activityEasyPlay();
                finish();

            }
        }.start();
    }
}