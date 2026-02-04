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
import android.widget.ListView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import androidx.fragment.app.Fragment;

import com.example.skthealthypet.databinding.FragmentListMainBinding;

public class List_Main_Fragment extends Fragment {
    public List_Main_Fragment() {
        // Required empty public constructor
    }
    public static Context mCon;
    private ListView mListView;
    static int opend = 0;
    private FragmentListMainBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_list_main_, null);
        /* 위젯과 멤버변수 참조 획득 */
        mCon = container.getContext();
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_main_,container, false);
        mListView = v.findViewById(R.id.listView);
        SharedPreferences pref = mCon.getSharedPreferences("ListInventory", Activity.MODE_PRIVATE);
        ListValues.p = pref.getInt("Index", -1);
        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();
        v.findViewById(R.id.feb_list_main).setOnClickListener(this::pressAddBtn);

        return v;
    }

    private void dataSetting() {
        // 리스트뷰에 어댑터 등록
        mListView.setAdapter(ListValues.mMyAdapter);

        final SharedPreferences pref = mCon.getSharedPreferences("ListInventory", Activity.MODE_PRIVATE);
        String inName, inContent;
        boolean isDaily;
        if (opend == 0) {
            for (int i = 0; i <= pref.getInt("Index", -10); i++) {
                inName = pref.getString("NAME_" + i, "ERROR");
                inContent = pref.getString("CONTENT_" + i, "ERROR");
                isDaily = pref.getBoolean("ISDAILY_" + i, false);
                ListValues.mMyAdapter.addItem(inName, inContent, isDaily);
            }
            opend++;
        }
    }

    public void pressAddBtn(View v) {
        Intent intent = new Intent(mCon, List_AddPopUp_Activity.class);
        startActivity(intent);
    }
}