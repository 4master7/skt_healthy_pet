package com.example.skthealthypet;

import android.app.Activity;
import android.widget.Toast;
public class BackPressCloseHandler {
    private long backKeyPressedTime = 0;
    private Toast toast;
    private Activity activity;
    public BackPressCloseHandler(Activity context) {
        this.activity = context;
    }
    public void onBackPressed(String a) {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            showGuide(a); return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            activity.finish();
            toast.cancel();
        }
    }
    public void showGuide(String a) {
        toast = Toast.makeText(activity, a, Toast.LENGTH_SHORT);
        toast.show();
    }
}