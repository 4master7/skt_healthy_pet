package com.example.skthealthypet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class ReInput_Fragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_re_input_, null);
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        final EditText ageinput=v.findViewById(R.id.ageinput);
        final  EditText heightinput=v.findViewById(R.id.heightinput);
        final EditText kginput=v.findViewById(R.id.kginput);
        Button complete=v.findViewById(R.id.complete);
        Context mcon = container.getContext();
        final SharedPreferences pref = mcon.getSharedPreferences("Infomation", Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        complete.setOnClickListener(view -> {
            String age=ageinput.getText().toString();
            String height=heightinput.getText().toString();
            String weight=kginput.getText().toString();

            if(!age.isEmpty()&&!height.isEmpty()&&!weight.isEmpty()){
                editor.putString("Height",height);
                editor.putString("Weight",weight);
                editor.putString("Age",age);
                editor.commit();
                Pet_Fragment Pet_Fragment = new Pet_Fragment();
                transaction.replace(R.id.framlayout, Pet_Fragment ).commitAllowingStateLoss();
            }
            else
                Toast.makeText(mcon, getString(R.string.fiilall), Toast.LENGTH_SHORT).show();
        });

        return v;
    }
}