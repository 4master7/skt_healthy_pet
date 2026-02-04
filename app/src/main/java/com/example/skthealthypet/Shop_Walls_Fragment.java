package com.example.skthealthypet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;

public class Shop_Walls_Fragment extends ShopValues {
    public Shop_Walls_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_shop_walls_, null);
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        final Context mCon = getContext();
        final SharedPreferences pref = mCon.getSharedPreferences("Inventory" , Activity.MODE_PRIVATE);

        final TextView NAME_VIEW = v.findViewById(R.id.NameView);
        final TextView CONTENT_VIEW = v.findViewById(R.id.ContentView);
        final TextView PRICE_VIEW = v.findViewById(R.id.PriceView);
        final ImageView Item_View = v.findViewById(R.id.ItemImage);
        final Button BUY = v.findViewById(R.id.BuyButton);
        AppCompatImageButton Slot1 =  v.findViewById(R.id.slot1);
        AppCompatImageButton Slot2 =  v.findViewById(R.id.slot2);
        AppCompatImageButton Slot3 =  v.findViewById(R.id.slot3);
        AppCompatImageButton Slot4 =  v.findViewById(R.id.slot4);
        AppCompatImageButton Slot5 =  v.findViewById(R.id.slot5);
        AppCompatImageButton Slot6 =  v.findViewById(R.id.slot6);
        NAME_VIEW.setText(walls_name[0]);
        CONTENT_VIEW.setText(walls_content[0]);
        PRICE_VIEW.setText(String.valueOf(walls_price[0]));
        Glide.with(mCon.getApplicationContext())
                .asBitmap()
                .load(R.drawable.w1)
                .into(Item_View);
        if(pref.getInt("walls_num_"+0,0)!=0)
            BUY.setText(getString(R.string.usebtn));
        else
            BUY.setText(getString(R.string.buy));

        final int [] Number = new int[1];
        Number[0]=0;
        FillChanged();

        Button Go_Hats = v.findViewById(R.id.gotohat);
        Go_Hats.setOnClickListener(view -> {
            Shop_Hats_Fragment Shop_Hats_Fragment=new Shop_Hats_Fragment();
            transaction.replace(R.id.framlayout,Shop_Hats_Fragment).commitAllowingStateLoss();
        });
        Button Go_Beds = v.findViewById(R.id.gotobed);
        Go_Beds.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Shop_Beds_Fragment Shop_Beds_Fragment=new Shop_Beds_Fragment();
                transaction.replace(R.id.framlayout,Shop_Beds_Fragment).commitAllowingStateLoss();
            }
        });
        Button Go_Closets = v.findViewById(R.id.gotocloset);
        Go_Closets.setOnClickListener(view -> {
            Shop_Closets_Fragment Shop_Closets_Fragment=new Shop_Closets_Fragment();
            transaction.replace(R.id.framlayout,Shop_Closets_Fragment).commitAllowingStateLoss();
        });
        Button Go_Floors = v.findViewById(R.id.gotofloor);
        Go_Floors.setOnClickListener(view -> {
            Shop_Floors_Fragment Shop_Floors_Fragment=new Shop_Floors_Fragment();
            transaction.replace(R.id.framlayout,Shop_Floors_Fragment).commitAllowingStateLoss();
        });


        Slot1.setOnClickListener(v1 -> {
            if(pref.getInt("walls_num_"+0,0)!=0)
                BUY.setText(getString(R.string.usebtn));
            else
                BUY.setText(getString(R.string.buy));
            Number[0]=0;
            NAME_VIEW.setText(walls_name[0]);
            CONTENT_VIEW.setText(walls_content[0]);
            PRICE_VIEW.setText(String.valueOf(walls_price[0]));
            Glide.with(mCon.getApplicationContext())
                    .asBitmap()
                    .load(R.drawable.w1)
                    .into(Item_View);
        });
        Slot2.setOnClickListener(v12 -> {
            if(pref.getInt("walls_num_"+1,0)!=0)
                BUY.setText(getString(R.string.usebtn));
            else
                BUY.setText(getString(R.string.buy));
            Number[0]=1;
            NAME_VIEW.setText(walls_name[1]);
            CONTENT_VIEW.setText(walls_content[1]);
            PRICE_VIEW.setText(String.valueOf(walls_price[1]));
            Glide.with(mCon.getApplicationContext())
                    .asBitmap()
                    .load(R.drawable.w2)
                    .into(Item_View);
        });
        Slot3.setOnClickListener(v13 -> {
            if(pref.getInt("walls_num_"+2,0)!=0)
                BUY.setText(getString(R.string.usebtn));
            else
                BUY.setText(getString(R.string.buy));
            Number[0]=2;
            NAME_VIEW.setText(walls_name[2]);
            CONTENT_VIEW.setText(walls_content[2]);
            PRICE_VIEW.setText(String.valueOf(walls_price[2]));
            Glide.with(mCon.getApplicationContext())
                    .asBitmap()
                    .load(R.drawable.w3)
                    .into(Item_View);
        });
        Slot4.setOnClickListener(v14 -> {
            if(pref.getInt("walls_num_"+3,0)!=0)
                BUY.setText(getString(R.string.usebtn));
            else
                BUY.setText(getString(R.string.buy));
            Number[0]=3;
            NAME_VIEW.setText(walls_name[3]);
            CONTENT_VIEW.setText(walls_content[3]);
            PRICE_VIEW.setText(String.valueOf(walls_price[3]));
            Glide.with(mCon.getApplicationContext())
                    .asBitmap()
                    .load(R.drawable.w4)
                    .into(Item_View);
        });

        BUY.setOnClickListener(v15 -> PURCHASE(BUY,walls[Number[0]],walls_price[Number[0]],"walls_num_"+Number[0],"walls_num_"));

        return v;
    }
    private void FillChanged(){
        final Context mCon = getContext();
        SharedPreferences pref = mCon.getSharedPreferences("Inventory" , Activity.MODE_PRIVATE);
        for(int i=0; i<6; i++)
            walls[i] = pref.getInt("walls_num_"+i,0);
        money = pref.getInt("money",0);
    }
    private void PURCHASE(final Button buy, final int quantity, final int price, final String method, final String pmethod) {       // 수량, 가격, 저장이름, 텍스트뷰
        final Context mCon = getContext();
        final SharedPreferences pref = mCon.getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        AlertDialog.Builder dialog = new AlertDialog.Builder(mCon);
        if (quantity == 0) {
            dialog.setTitle(getString(R.string.buy))
                    .setMessage(getString(R.string.buy_confirm))
                    .setPositiveButton(getString(R.string.yes), (dialog1, which) -> {
                        if (money >= price) {
                            Toast.makeText(mCon,
                                    getString(R.string.bought),
                                    Toast.LENGTH_SHORT).show();
                            money -= price;
                            editor.putInt("money", money);
                            editor.commit();
                            FillChanged();
                            editor.putInt(method, 1);
                            editor.commit();
                            FillChanged();
                            buy.setText(getString(R.string.usebtn));
                        } else {
                            Toast.makeText(mCon,
                                    getString(R.string.nomoney),
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(getString(R.string.no), (dialog12, which) -> Toast.makeText(mCon,
                            getString(R.string.cancelled),
                            Toast.LENGTH_SHORT).show());
            dialog.create();
            dialog.show();
        }
        else {
            dialog.setTitle(getString(R.string.announce))
                    .setMessage(getString(R.string.use))
                    .setPositiveButton(getString(R.string.yes), (dialog13, which) -> {
                        for(int i=0; i<6; i++){
                            if(pref.getInt(pmethod+i,0)==2)
                                editor.putInt(pmethod+i,1);
                        }
                        editor.commit();
                        editor.putInt(method,2);
                        editor.commit();
                        Toast.makeText(mCon, getString(R.string.used), Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton(getString(R.string.no), (dialog14, which) -> Toast.makeText(mCon,
                            getString(R.string.cancelled),
                            Toast.LENGTH_SHORT).show());
            dialog.create();
            dialog.show();
        }
    }
}