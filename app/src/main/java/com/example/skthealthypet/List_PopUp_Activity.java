package com.example.skthealthypet;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class List_PopUp_Activity extends AppCompatActivity {

    Button okBtn, cancleBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_list_pop_up_);

        okBtn = findViewById(R.id.okBtn);
        cancleBtn = findViewById(R.id.cancleBtn);
    }

    public void mOk(View v){//ok 버튼 클릭
        ListValues.mMyAdapter.deleteItem(ListValues.possi);
        ListValues.mMyAdapter.notifyDataSetChanged();
        Toast.makeText(this, getString(R.string.deleted), Toast.LENGTH_SHORT).show();
        final SharedPreferences pref = getSharedPreferences("ListInventory" , Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        editor.remove("NAME_"+ListValues.possi);
        editor.remove("CONTENT_"+ListValues.possi);
        editor.remove("ISDAILY_"+ListValues.possi);
        editor.commit();
        ListValues.p--;
        for(int i=(ListValues.possi); i<=(ListValues.p); i++){
            editor.putString("NAME_"+i,pref.getString("NAME_"+(i+1),"ERROR"));
            editor.putString("CONTENT_"+i,pref.getString("CONTENT_"+(i+1),"ERROR"));
            editor.putBoolean("ISDAILY_"+i,pref.getBoolean("ISDAILY_"+(i+1),false));
            editor.commit();
        }
        editor.remove("NAME_"+pref.getInt("Index",0));
        editor.remove("CONTENT_"+pref.getInt("Index",0));
        editor.remove("ISDAILY_"+pref.getInt("Index",0));
        editor.putInt("Index",pref.getInt("Index",0)-1);
        editor.commit();
        finish();

    }
    public void mCancle(View v){//cancle 버튼 클릭
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