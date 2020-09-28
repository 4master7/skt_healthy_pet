package com.example.skthealthypet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Loding_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding_);
        Handler mHandler = new Handler();

        SharedPreferences pref = getSharedPreferences("Inventory" , Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        mHandler.postDelayed(() -> {

            if (CheckAppFirstExecute()) {
                editor.putInt("money", 0);
                for (int i = 0; i < 6; i++) {
                    editor.putInt("hats_num_" + i, 0);
                    editor.putInt("beds_num_" + i, 0);
                    editor.putInt("closets_num_" + i, 0);
                    editor.putInt("walls_num_" + i, 0);
                    editor.putInt("floors_num_" + i, 0);
                }
                editor.commit();
                Intent intent=new Intent(Loding_Activity.this,Input_Activity.class);
                startActivity(intent);
                finish();
            }
            else{
                Intent intent=new Intent(Loding_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    public boolean CheckAppFirstExecute(){
        SharedPreferences pref = getSharedPreferences("IsFirst" , Activity.MODE_PRIVATE);
        boolean isFirst = pref.getBoolean("isFirst", false);
        return !isFirst;
    }
    @Override
    public void onBackPressed() {
    }
}