package com.example.skthealthypet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.example.skthealthypet.databinding.ActivityFireStoreTestBinding;

import java.util.Arrays;

import static com.example.skthealthypet.RankingIntoStore.input;
import static com.example.skthealthypet.RankingIntoStore.readRank;

public class FireStoreTestActivity extends AppCompatActivity {

    private ActivityFireStoreTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_store_test);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fire_store_test);
        binding.setN("");
        binding.setStep("");

        binding.btnTest.setOnClickListener(view -> {

            RankingIntoStore.input(this,
                    Integer.parseInt(binding.getN()),
                    Integer.parseInt(binding.getStep()));
        });

        binding.btnTest2.setOnClickListener(view -> Toast.makeText(this, ""+ Arrays.toString(readRank()), Toast.LENGTH_SHORT).show());

    }
}