package com.example.skthealthypet;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Menu_Fragment extends Fragment {
    public Menu_Fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_menu_, null);
        // Inflate the layout for this fragment
        Button enterinformation=(Button)v.findViewById(R.id.enterinformation);
        final Button ranking=(Button)v.findViewById(R.id.ranking);
        Button shop=(Button)v.findViewById(R.id.shop);
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        Button test1=(Button)v.findViewById(R.id.test1);
        Button test2=(Button)v.findViewById(R.id.test2);
        TextView cm=(TextView)v.findViewById(R.id.cm);
        TextView kg=(TextView)v.findViewById(R.id.kg);
        Context c = container.getContext();
        SharedPreferences pref2 = c.getSharedPreferences("Infomation", Activity.MODE_PRIVATE);

        cm.setText(pref2.getString("Height", "ERROR")+" cm");
        kg.setText(pref2.getString("Weight","ERROR")+" kg");

        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences p = container.getContext().getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
                final SharedPreferences.Editor e = p.edit();
                e.putInt("money", p.getInt("money", 0)+1000);
                e.commit();
            }
        });
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final SharedPreferences p2 = container.getContext().getSharedPreferences("Infomation", Activity.MODE_PRIVATE);
                final SharedPreferences.Editor e2 = p2.edit();
                e2.putInt("exp",p2.getInt("exp",0)+500);
                e2.commit();
            }
        });
        enterinformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReInput_Fragment ReInput_Fragment=new ReInput_Fragment();
                transaction.replace(R.id.framlayout,ReInput_Fragment).commitAllowingStateLoss();
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ranking_Fragment Ranking_Fragment=new Ranking_Fragment();
                transaction.replace(R.id.framlayout,Ranking_Fragment).commitAllowingStateLoss();
            }
        });

        shop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Shop_Beds_Fragment Shop_Beds_Fragment=new Shop_Beds_Fragment();
                transaction.replace(R.id.framlayout,Shop_Beds_Fragment).commitAllowingStateLoss();
            }
        });
        return v;

    }
}