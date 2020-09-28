package com.example.skthealthypet;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class List_AddPopUp_Activity extends AppCompatActivity {
    Button okBtn, cancleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPreferences pref = getSharedPreferences("ListInventory" , Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_add_pop_up_);

        okBtn = findViewById(R.id.okBtn);
        cancleBtn = findViewById(R.id.cancleBtn);
    }

    public void m1Ok(View v){//ok 버튼 클릭
        EditText nm = findViewById(R.id.editname);
        EditText ct = findViewById(R.id.editcontent);
        CheckBox isDaily = findViewById(R.id.isDaily);
        String inName = nm.getText().toString();
        String inContent = ct.getText().toString();
        if(!inName.isEmpty()&&!inContent.isEmpty()){
            ListValues.p++;
            ListValues.mMyAdapter.addItem(inName,inContent,isDaily.isChecked());
            Toast.makeText(this, getString(R.string.added), Toast.LENGTH_SHORT).show();
            final SharedPreferences pref = getSharedPreferences("ListInventory" , Activity.MODE_PRIVATE);
            final SharedPreferences.Editor editor = pref.edit();
            ListValues.SaveInfo(inName,inContent,isDaily.isChecked(),ListValues.p,editor);
            editor.putInt("Index",ListValues.p);
            editor.commit();
            finish();
        }
        else
            Toast.makeText(this, getString(R.string.fiilall), Toast.LENGTH_SHORT).show();
    }
    public void m1Cancle(View v){//cancle 버튼 클릭
        Toast.makeText(this, getString(R.string.cancelled), Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }
    @Override
    public void onBackPressed(){
        return;
    }

}