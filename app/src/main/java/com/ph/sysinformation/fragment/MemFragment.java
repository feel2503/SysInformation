package com.ph.sysinformation.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ph.sysinformation.R;

import java.io.IOException;
import java.io.InputStream;

public class MemFragment extends Fragment{
    private static MemFragment mInstance;
    public static MemFragment getInstance()
    {
        if(mInstance == null)
            mInstance = new MemFragment();

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

        contentView.append(getMemoryInfo() + "\n");
    }

    private String getMemoryInfo()
    {
        ProcessBuilder cmd;
        String result="";

        try {
            String[] args = {"/system/bin/cat", "/proc/meminfo"};
            cmd = new ProcessBuilder(args);

            Process process = cmd.start();
            InputStream in = process.getInputStream();
            byte[] re = new byte[1024];
            while(in.read(re) != -1){
                System.out.println(new String(re));
                result = result + new String(re);
            }
            in.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
