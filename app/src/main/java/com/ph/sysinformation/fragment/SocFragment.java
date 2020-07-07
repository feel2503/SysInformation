package com.ph.sysinformation.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ph.sysinformation.R;

public class SocFragment extends Fragment {

    private static SocFragment mInstance;
    public static SocFragment getInstance()
    {
        if(mInstance == null)
            mInstance = new SocFragment();

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

        contentView.append("Hardware: " + Build.HARDWARE + "\n");
        contentView.append("Number of cores: " + getNumberOfCores() + "\n");
        contentView.append("Architecture: " + arch +  "\n");


    }

    private int getNumberOfCores() {
        if(Build.VERSION.SDK_INT >= 17) {
            return Runtime.getRuntime().availableProcessors();
        }else {
            //Code for old SDK values
            return 0;
            //return Runtime.getRuntime().availableProcessors();
        }
    }
}