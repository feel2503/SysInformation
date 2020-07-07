package com.ph.sysinformation.fragment;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ph.sysinformation.R;

import java.util.List;

public class SensorFragment extends Fragment{
    private static SensorFragment mInstance;
    public static SensorFragment getInstance()
    {
        if(mInstance == null)
            mInstance = new SensorFragment();

        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_device, container, false);
        TextView textContnt = (TextView)rootView.findViewById(R.id.text_content);

        initInfo(textContnt);
        return rootView;
    }

    private void initInfo(TextView contentView)
    {
        SensorManager sm = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> list = sm.getSensorList(Sensor.TYPE_ALL);

        for(Sensor s : list) {
            //Log.d("SENSORS", s.getName());
            contentView.append(s.getName() + "\n");
        }


    }
}
