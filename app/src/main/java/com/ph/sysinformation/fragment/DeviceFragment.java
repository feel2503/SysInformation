package com.ph.sysinformation.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ph.sysinformation.R;

public class DeviceFragment extends Fragment{
    private static DeviceFragment mInstance;

    public static DeviceFragment getInstance()
    {
        if(mInstance == null)
            mInstance = new DeviceFragment();

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
        String arch = System.getProperty("os.arch");

        contentView.append("Model: " + Build.MODEL + "\n");
        contentView.append("Board: " + Build.BOARD + "\n");
        contentView.append("Brand: " + Build.BRAND + "\n");
        contentView.append("Manufacturer: " + Build.MANUFACTURER + "\n");
        contentView.append("Device: " + Build.DEVICE + "\n");
        contentView.append("Product: " + Build.PRODUCT + "\n");
        contentView.append("TAGS: " + Build.TAGS + "\n");
        contentView.append("Serial: " + Build.SERIAL + "\n");

    }
}
