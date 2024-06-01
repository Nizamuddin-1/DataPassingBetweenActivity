package com.example.datapassingbetweenactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
TextView number;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        number=findViewById(R.id.text2);
        button=findViewById(R.id.btn);
        Intent i=getIntent();
        String userName=i.getStringExtra("name");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int random_num=generateRandomNumber();
                shareData(userName,random_num);
            }
        });
    }
    public void shareData(String userName,int random_num){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plaintext");
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" got today lunky number");
        i.putExtra(Intent.EXTRA_TEXT,"hi"+random_num);
        startActivity(Intent.createChooser(i,"Choose your platform"));
    }
    public int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
        int randomNumberGenerated=random.nextInt();
        return randomNumberGenerated;
    }
}