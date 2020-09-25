package com.example.skthealthypet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Input_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_);
        final EditText ageinput=(EditText)findViewById(R.id.ageinput);
        final  EditText heightinput=(EditText) findViewById(R.id.heightinput);
        final EditText kginput=(EditText)findViewById(R.id.kginput);
        final EditText nameinput=findViewById(R.id.nameinput);
        Button complete=(Button)findViewById(R.id.complete);
        Context mcon = this;
        final SharedPreferences pref = getSharedPreferences("Infomation", Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        editor.putInt("exp",0);
        editor.putInt("level",0);
        editor.commit();
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age=ageinput.getText().toString();
                String height=heightinput.getText().toString();
                String weight=kginput.getText().toString();
                String name=nameinput.getText().toString();

                if(!age.isEmpty()&&!height.isEmpty()&&!weight.isEmpty()&&!name.isEmpty()){
                    editor.putString("PetName",name);
                    editor.putString("Height",height);
                    editor.putString("Weight",weight);
                    editor.putString("Age",age);
                    editor.commit();
                    Intent intent=new Intent(Input_Activity.this,Choice_Activity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(mcon, getString(R.string.fiilall), Toast.LENGTH_SHORT).show();
            }
        });


    }


}