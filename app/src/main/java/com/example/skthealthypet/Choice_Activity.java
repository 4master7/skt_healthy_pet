package com.example.skthealthypet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Choice_Activity extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_);
        Button chosedog=findViewById(R.id.dogbutton);
        Button chosecat=findViewById(R.id.catbutton);
        backPressCloseHandler = new BackPressCloseHandler(this);
        final SharedPreferences pref = getSharedPreferences("Infomation", Activity.MODE_PRIVATE);
        SharedPreferences pref2 = getSharedPreferences("IsFirst" , Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = pref2.edit();
        final SharedPreferences.Editor editor = pref.edit();

        chosedog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putInt("DogOrCat",1);
                editor2.putBoolean("isFirst", true);
                editor.commit();
                editor2.commit();
                Intent intent=new Intent(Choice_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        chosecat.setOnClickListener(view -> {
            editor.putInt("DogOrCat",2);
            editor2.putBoolean("isFirst", true);
            editor.commit();
            editor2.commit();
            Intent intent=new Intent(Choice_Activity.this,MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed(getString(R.string.backmore));
    }
}