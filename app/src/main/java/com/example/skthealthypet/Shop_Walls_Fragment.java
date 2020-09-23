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
        Context mCon = getContext();
        final SharedPreferences pref = mCon.getSharedPreferences("Inventory" , Activity.MODE_PRIVATE);

        final TextView NAME_VIEW = v.findViewById(R.id.NameView);
        final TextView CONTENT_VIEW = v.findViewById(R.id.ContentView);
        final TextView PRICE_VIEW = v.findViewById(R.id.PriceView);
        ImageView Item_View = v.findViewById(R.id.ItemImage);
        Button BUY = v.findViewById(R.id.BuyButton);
        final TextView Money_View = v.findViewById(R.id.MoneyView);
        AppCompatImageButton Slot1 =  v.findViewById(R.id.slot1);
        AppCompatImageButton Slot2 =  v.findViewById(R.id.slot2);
        AppCompatImageButton Slot3 =  v.findViewById(R.id.slot3);
        AppCompatImageButton Slot4 =  v.findViewById(R.id.slot4);
        AppCompatImageButton Slot5 =  v.findViewById(R.id.slot5);
        AppCompatImageButton Slot6 =  v.findViewById(R.id.slot6);
        NAME_VIEW.setText(walls_name[0]);
        CONTENT_VIEW.setText(walls_content[0]);
        PRICE_VIEW.setText(String.valueOf(walls_price[0]));
        final int [] Number = new int[1];
        Number[0]=0;
//        if( pref.getInt("walls_num_0",0) == 1)
//            sh1.setText("구매 완료");
//        else
//            sh1.setText(walls_price[0]+"코인");
//        if( pref.getInt("walls_num_1",0) == 1)
//            sh2.setText("구매 완료");
//        else
//            sh2.setText(walls_price[1]+"코인");
//        if( pref.getInt("walls_num_2",0) == 1)
//            sh3.setText("구매 완료");
//        else
//            sh3.setText(walls_price[2]+"코인");
//        if( pref.getInt("walls_num_3",0) == 1)
//            sh4.setText("구매 완료");
//        else
//            sh4.setText(walls_price[3]+"코인");
//
        FillChanged(Money_View);

        Button Go_Clothes = v.findViewById(R.id.gotocloth);
        Go_Clothes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Shop_Clothes_Fragment Shop_Clothes_Fragment=new Shop_Clothes_Fragment();
                transaction.replace(R.id.framlayout,Shop_Clothes_Fragment).commitAllowingStateLoss();
            }
        });
        Button Go_Hats = v.findViewById(R.id.gotohat);
        Go_Hats.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Shop_Hats_Fragment Shop_Hats_Fragment=new Shop_Hats_Fragment();
                transaction.replace(R.id.framlayout,Shop_Hats_Fragment).commitAllowingStateLoss();
            }
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
        Go_Closets.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Shop_Closets_Fragment Shop_Closets_Fragment=new Shop_Closets_Fragment();
                transaction.replace(R.id.framlayout,Shop_Closets_Fragment).commitAllowingStateLoss();
            }
        });
        Button Go_Floors = v.findViewById(R.id.gotofloor);
        Go_Floors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Shop_Floors_Fragment Shop_Floors_Fragment=new Shop_Floors_Fragment();
                transaction.replace(R.id.framlayout,Shop_Floors_Fragment).commitAllowingStateLoss();
            }
        });


        Slot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number[0]=0;
                NAME_VIEW.setText(walls_name[0]);
                CONTENT_VIEW.setText(walls_content[0]);
                PRICE_VIEW.setText(String.valueOf(walls_price[0]));
            }
        });
        Slot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number[0]=1;
                NAME_VIEW.setText(walls_name[1]);
                CONTENT_VIEW.setText(walls_content[1]);
                PRICE_VIEW.setText(String.valueOf(walls_price[1]));
            }
        });
        Slot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number[0]=2;
                NAME_VIEW.setText(walls_name[2]);
                CONTENT_VIEW.setText(walls_content[2]);
                PRICE_VIEW.setText(String.valueOf(walls_price[2]));
            }
        });
        Slot4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number[0]=3;
                NAME_VIEW.setText(walls_name[3]);
                CONTENT_VIEW.setText(walls_content[3]);
                PRICE_VIEW.setText(String.valueOf(walls_price[3]));
            }
        });
        Slot5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number[0]=4;
                NAME_VIEW.setText(walls_name[4]);
                CONTENT_VIEW.setText(walls_content[4]);
                PRICE_VIEW.setText(String.valueOf(walls_price[4]));
            }
        });
        Slot6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Number[0]=5;
                NAME_VIEW.setText(walls_name[5]);
                CONTENT_VIEW.setText(walls_content[5]);
                PRICE_VIEW.setText(String.valueOf(walls_price[5]));
            }
        });

        BUY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PURCHASE(walls[Number[0]],walls_price[Number[0]],"walls_num_"+Number[0],Money_View);
            }
        });

        return v;
    }
    private void FillChanged(final TextView Money_View){
        final Context mCon = getContext();
        SharedPreferences pref = mCon.getSharedPreferences("Inventory" , Activity.MODE_PRIVATE);
        for(int i=0; i<6; i++)
            walls[i] = pref.getInt("walls_num_"+i,0);
        money = pref.getInt("money",0);
        Money_View.setText(String.valueOf(money));
    }
    private void PURCHASE(final int quantity, final int price, final String method, final TextView Money_View){       // 수량, 가격, 저장이름, 텍스트뷰
        final Context mCon = getContext();
        final SharedPreferences pref = mCon.getSharedPreferences("Inventory" , Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        AlertDialog.Builder dialog = new AlertDialog.Builder(mCon);
        dialog .setTitle("구매 확인")
                .setMessage("구매하시겠습까?")
                .setPositiveButton("예",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        if(quantity==1) {
                            Toast.makeText(mCon,
                                    "이미 소지하고 계신 아이템입니다!",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            if (money >= price) {
                                Toast.makeText(mCon,
                                        "구매하였습니다.",
                                        Toast.LENGTH_SHORT).show();
                                money -= price;
                                editor.putInt("money",money);
                                editor.commit();
                                FillChanged(Money_View);
                                editor.putInt(method,1);
                                editor.commit();
                                FillChanged(Money_View);
                                //TV.setText("구매 완료");
                            } else {
                                Toast.makeText(mCon,
                                        "돈이 부족합니다!",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                })
                .setNegativeButton("아니오",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Toast.makeText(mCon,
                                "취소하였습니다.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        dialog.create();
        dialog.show();
    }
}