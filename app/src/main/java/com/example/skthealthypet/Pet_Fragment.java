package com.example.skthealthypet;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class Pet_Fragment extends Fragment {
    public Pet_Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_pet_, null);
        Context c = container.getContext();
        SharedPreferences pref = c.getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
        SharedPreferences pref2 = c.getSharedPreferences("Infomation", Activity.MODE_PRIVATE);
        TextView MONEY_VIEW = v.findViewById(R.id.cointext);
        MONEY_VIEW.setText(String.valueOf(pref.getInt("money", 0))+" "+getString(R.string.coins));
        TextView INFO_VIEW = v.findViewById(R.id.info);
        TextView NAME_VIEW = v.findViewById(R.id.petname);
        ImageView GAGU = v.findViewById(R.id.GAGU);
        ImageView BED = v.findViewById(R.id.BED);
        ImageView PET = v.findViewById(R.id.Pet);
        if (pref2.getInt("exp", 0) >= 500) {
            SharedPreferences.Editor e = pref2.edit();
            e.putInt("level", pref2.getInt("level", 0) + 1);
            e.putInt("exp", pref2.getInt("exp", 0) - 500);
            e.commit();
        }
        INFO_VIEW.setText(String.valueOf(pref2.getInt("level", 0)) + " Lv  " + String.valueOf(pref2.getInt("exp", 0)) + "/500");
        NAME_VIEW.setText(pref2.getString("PetName", "ERROR"));


        if(pref2.getInt("DogOrCat",0)==1){
            NAME_VIEW.setBackgroundResource(R.drawable.dogname);
            if (pref2.getInt("level", 0) == 1) {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.dog1)
                        .into(PET);
            }
            else if (pref2.getInt("level", 0) == 2) {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.dog2)
                        .into(PET);
            }
            else if (pref2.getInt("level", 0) == 3) {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.dog33)
                        .into(PET);
            }
            else {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.dog4)
                        .into(PET);
            }
        }
        else if(pref.getInt("DogOrCat",0)==2){
            NAME_VIEW.setBackgroundResource(R.drawable.catname);
            if (pref2.getInt("level", 0) == 1) {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.cat1)
                        .into(PET);
            }
            else if (pref2.getInt("level", 0) == 2) {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.cat2)
                        .into(PET);
            }
            else if (pref2.getInt("level", 0) == 3) {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.cat3)
                        .into(PET);
            }
            else {
                Glide.with(c.getApplicationContext())
                        .asBitmap()
                        .load(R.drawable.cat4)
                        .into(PET);
            }
        }

        int i;
            for (i = 0; i < 6; i++)
                if (pref.getInt("beds_num_" + i, 0) == 2)
                    break;
            switch (i) {
                case 0:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.bed1)
                            .into(BED);
                    break;
                case 1:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.bed2)
                            .into(BED);
                    break;
                case 2:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.bed3)
                            .into(BED);
                    break;
                case 3:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.tent1)
                            .into(BED);
                    break;
                case 4:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.tent2)
                            .into(BED);
                    break;
                case 5:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.tent3)
                            .into(BED);
                    break;
            }
            for (i = 0; i < 5; i++)
                if (pref.getInt("closets_num_" + i, 0) == 2)
                    break;
            switch (i) {
                case 0:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.closet)
                            .into(GAGU);
                    break;
                case 1:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.closet_white)
                            .into(GAGU);
                    break;
                case 2:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.closet_black)
                            .into(GAGU);
                    break;
                case 3:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.clock)
                            .into(GAGU);
                    break;
                case 4:
                    Glide.with(c.getApplicationContext())
                            .asBitmap()
                            .load(R.drawable.clock_elec)
                            .into(GAGU);
                    break;
            }
            return v;

        }
    }