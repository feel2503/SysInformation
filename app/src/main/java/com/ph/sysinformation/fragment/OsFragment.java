package com.ph.sysinformation.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ph.sysinformation.R;

import java.text.SimpleDateFormat;

public class OsFragment extends Fragment{
    private static OsFragment mInstance;
    public static OsFragment getInstance()
    {
        if(mInstance == null)
            mInstance = new OsFragment();

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

        contentView.append("Build release: " + Build.VERSION.RELEASE + "\n");
        contentView.append("Incremental release: " + Build.VERSION.INCREMENTAL + "\n");
        contentView.append("Base OS: " + Build.VERSION.BASE_OS + "\n");
        contentView.append("CODE Name: " + Build.VERSION.CODENAME + "\n");
        contentView.append("Security patch: " + Build.VERSION.SECURITY_PATCH + "\n");
        contentView.append("Preview SDK: " + Build.VERSION.PREVIEW_SDK_INT + "\n");
        contentView.append("SDK/API version: " + Build.VERSION.SDK_INT + "\n");
        contentView.append("Display build: " + Build.DISPLAY + "\n");
        contentView.append("Finger print: " + Build.FINGERPRINT + "\n") ;
        contentView.append("Build ID: " + Build.ID + "\n");

        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy 'at' h:mm a");
        String date = sdf.format(Build.TIME);

        contentView.append("Build Time: " + date + "\n");
        contentView.append("Build Type: " + Build.TYPE + "\n");
        contentView.append("Build User: " + Build.USER + "\n");
        contentView.append("Bootloader: " + Build.BOOTLOADER + "\n");
        contentView.append("Kernel version: " + System.getProperty("os.version") + "\n");


    }
}
