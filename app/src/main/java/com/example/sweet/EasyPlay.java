package com.example.sweet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.gridlayout.widget.GridLayout;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class EasyPlay extends AppCompatActivity {

    GridLayout gridLayout;
   // HashSet<Integer> numbersHash=new HashSet<>();
    ArrayList<ImageView> images=new ArrayList<>();
    ArrayList<Integer> numbers2 =new ArrayList<>();
    ArrayList<Integer> getNumbers=new ArrayList<>();

    ImageView img1,img2,img3,img4,img5,img6,
              img7,img8,img9,img10,img11,img12;
    int selectedImg[]=new int[4];
    int greenCount=0;





    public void setImages(){
        images.add(img1);
        images.add(img2);
        images.add(img3);
        images.add(img4);
        images.add(img5);
        images.add(img6);
        images.add(img7);
        images.add(img8);
        images.add(img9);
        images.add(img10);
        images.add(img11);
        images.add(img12);

     /*  for(int i=0;i<Easy.selected.length;i++){
           numbersHash.add(Easy.selected[i]);
       }*/
       for(int i=0;i<=27;i++){
           numbers2.add(i);
       }
       for(int i=0;i<12;i++){
           getNumbers.add(i);
       }




        Collections.shuffle(getNumbers);

        for(int i=0;i<Easy.selected.length;i++){
            String imgName="cake"+Easy.selected[i];
            int id=getResources().getIdentifier(imgName,"drawable",EasyPlay.this.getPackageName());
           images.get(new Integer(getNumbers.get(i))).setImageResource(id);
           selectedImg[i]=getNumbers.get(i);
            numbers2.remove(new Integer(Easy.selected[i]));

        }

        Collections.shuffle(numbers2);

      for(int i=0;i<images.size();i++){
          if(images.get(i).getDrawable()==null){
           String imgName="cake"+numbers2.get(i);
           int id=getResources().getIdentifier(imgName,"drawable",EasyPlay.this.getPackageName());
           images.get(i).setImageResource(id);
           }
       }

    }

    public void check(View view) throws InterruptedException {
        //check for lose
        ImageView imgView=(ImageView) view;
        boolean t=true;
        for(int i=0;i<selectedImg.length;i++){
            if(Integer.parseInt(imgView.getTag().toString())==selectedImg[i]){
                t=false;
                break;
            }
        }
        if(t==true){
            imgView.setBackgroundColor(getResources().getColor(R.color.green));
            greenCount++;
        }
        else if(t==false){
            imgView.setBackgroundColor(getResources().getColor(R.color.red));
            startActivity(new Intent(this,Lose.class));
            finish();
        }
        if(greenCount==8){
            startActivity(new Intent(this,Win.class));
            finish();
        }
        imgView.setClickable(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_play);

        gridLayout=(GridLayout)findViewById(R.id.gridLayout);

        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);
        img4=findViewById(R.id.img4);
        img5=findViewById(R.id.img5);
        img6=findViewById(R.id.img6);
        img7=findViewById(R.id.img7);
        img8=findViewById(R.id.img8);
        img9=findViewById(R.id.img9);
        img10=findViewById(R.id.img10);
        img11=findViewById(R.id.img11);
        img12=findViewById(R.id.img12);

        setImages();
       // Log.i("ssdsdsd45454cscsc",numbersHash.size()+"");



    }
}