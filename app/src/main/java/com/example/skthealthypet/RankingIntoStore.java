package com.example.skthealthypet;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
public class RankingIntoStore {



    public static void input(Context mContext, int ranking, int step) {
        //ranking : 0,1,2,3,4,5,6,7,8,9
        //step : integer type step number
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put(""+ranking, step);

        firebaseFirestore
                .collection("Rank")
                .document(ranking+"")
                .set(map)
                .addOnSuccessListener(runnable ->{})
                .addOnFailureListener(e ->
                    Toast.makeText(mContext, "Failed", Toast.LENGTH_SHORT).show());
    }

    public static int[] readRank(){
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        int[] k  = {0,0,0,0,0,0,0,0,0,0};
        firebaseFirestore.collection("Rank")
                .document("0")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    // Document found in the offline cache
                    DocumentSnapshot document = task.getResult();
                    for(int i = 0; i<10; i++)
                        k[i] = (int)document.getData().get(""+i);
                }
            }
        });
        return k;
    }


}