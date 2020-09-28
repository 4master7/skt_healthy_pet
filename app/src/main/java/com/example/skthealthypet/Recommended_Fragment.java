package com.example.skthealthypet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Recommended_Fragment extends Fragment {

    private ObservableArrayList<item> itemList = new ObservableArrayList<>();
    private RecyclerView recyclerView;
    private aAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_recommended_, container, false);
        itemList.clear();
        prepareData();
        //recyclerview
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        mAdapter = new aAdapter(itemList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        return v;
    }

    //데이터 준비(최종적으로는 동적으로 추가하거나 삭제할 수 있어야 한다. 이 데이터를 어디에 저장할지 정해야 한다.)
    private void prepareData() {

        itemList.add(new item(getString(R.string.squat)));
        itemList.add(new item(getString(R.string.pushup)));
        itemList.add(new item(getString(R.string.plank)));
        itemList.add(new item(getString(R.string.walking)));
        itemList.add(new item(getString(R.string.lunge)));
        itemList.add(new item(getString(R.string.burpee)));
    }



}