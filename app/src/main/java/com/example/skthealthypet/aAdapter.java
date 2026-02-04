package com.example.skthealthypet;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class aAdapter extends RecyclerView.Adapter<aAdapter.MyViewHolder>{
    private ArrayList<item> mDataset;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        //ViewHolder
        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
        }
    }

    public aAdapter(ArrayList<item> myData){
        this.mDataset = myData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mDataset.get(position).getTitle());

//        holder.title.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                activity.getFragmentManager().beginTransaction().replace(R.id.fragment_place, new Fragment1()).addToBackStack(null).commit();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

