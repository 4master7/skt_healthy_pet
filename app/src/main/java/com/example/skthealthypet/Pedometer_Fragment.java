package com.example.skthealthypet;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Pedometer_Fragment extends Fragment  implements SensorEventListener {
    ImageButton mReset;
    TextView mwalknum;
    //현재 걸음 수
    private int mSteps = 0;
    //리스너가 등록되고 난 후의 step count
    private int mCounterSteps = 0;


    private SensorManager sensorManager;
    //private Sensor accelerormeterSensor;
    private Sensor stepCountSensor;



    private View view;

    public Pedometer_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_pedometer_, container, false);
        TextView reword=(TextView)view.findViewById(R.id.reword);
        //센서 연결[걸음수 센서를 이용한 흔듬 감지]
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        //accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

        if (stepCountSensor == null) {
            // Toast.makeText(this,"No Step Detect Sensor",Toast.LENGTH_SHORT).show();
        }

        mReset = view.findViewById(R.id.reset_btn);
        mwalknum = view.findViewById(R.id.walknum);
        //초기화 버튼 : 다시 숫자를 0으로 만들어준다.

        if(mSteps>=1){
            reword.setText(R.string.reword1);
            mReset.setVisibility(View.VISIBLE);
        }

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SharedPreferences p = container.getContext().getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
                final SharedPreferences.Editor e = p.edit();
                final SharedPreferences p2 = container.getContext().getSharedPreferences("Infomation", Activity.MODE_PRIVATE);
                final SharedPreferences.Editor e2 = p2.edit();

                reword.setText(Integer.toString(mSteps/10)+(getString(R.string.get)));
                e.putInt("money", p.getInt("money", 0)+mSteps/10);
                e2.putInt("exp",p2.getInt("exp",0)+mSteps/50);
                e.commit();
                e2.commit();
                mwalknum.setText(Integer.toString(mSteps));
                mReset.setVisibility(View.INVISIBLE);
                mSteps=0;
                mCounterSteps=0;
            }
        });

        return view;
    }
    public void onStart () {
        super.onStart();
        if (stepCountSensor != null) {
            sensorManager.registerListener(this,stepCountSensor,SensorManager.SENSOR_DELAY_GAME);
        }
    }

    public void onStop () {
        super.onStop();
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_STEP_COUNTER){

            //stepcountsenersor는    앱이 꺼지더라도 초기화 되지않는다. 그러므로 우리는 초기값을 가지고 있어야한다.
            if (mCounterSteps < 1) {
                // initial value
                mCounterSteps = (int) sensorEvent.values[0];
            }
            //리셋 안된 값 + 현재값 - 리셋 안된 값
            mSteps = (int) sensorEvent.values[0] - mCounterSteps;
            mwalknum.setText(Integer.toString(mSteps));
            Log.i("log: ", "New step detected by STEP_COUNTER sensor. Total step count: " + mSteps );
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}