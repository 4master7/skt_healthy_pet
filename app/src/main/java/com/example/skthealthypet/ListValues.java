package com.example.skthealthypet;

import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

public class ListValues extends AppCompatActivity implements MyAdapter.onItemDelete, MyAdapter.onItemComplete
{
    public static int possi;
    public static MyAdapter mMyAdapter = new MyAdapter();
    public static int p;
    public static boolean IS;

    public static void SaveInfo(String inName, String inContent, Boolean isDaily, int po, SharedPreferences.Editor editor){
        editor.putString("NAME_"+po,inName);
        editor.putString("CONTENT_"+po,inContent);
        editor.putBoolean("ISDAILY_"+po,isDaily);
        editor.commit();
    }

    @Override
    public void onDelete(int Position) {
        possi = Position;
        (List_Main_Fragment.mCon).startActivity(new Intent(List_Main_Fragment.mCon, List_PopUp_Activity.class));
    }

    @Override
    public void onComplete(boolean isD, int Position) {
        IS = isD;
        possi = Position;
        (List_Main_Fragment.mCon).startActivity(new Intent(List_Main_Fragment.mCon, List_CompletePopUp_Activity.class));
    }
}
