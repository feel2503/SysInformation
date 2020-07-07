package com.ph.sysinformation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ph.sysinformation.fragment.CpuFragment;
import com.ph.sysinformation.fragment.DeviceFragment;
import com.ph.sysinformation.fragment.MemFragment;
import com.ph.sysinformation.fragment.OsFragment;
import com.ph.sysinformation.fragment.RadioFragment;
import com.ph.sysinformation.fragment.SensorFragment;
import com.ph.sysinformation.fragment.SocFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter{
    private int mTabsCount = 7;

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        switch (position) {
            case 0:
                DeviceFragment devFragment = DeviceFragment.getInstance();
                return devFragment;
            case 1:
                SocFragment socFragment = SocFragment.getInstance();
                return socFragment;
            case 2:
                CpuFragment cpuFragment = CpuFragment.getInstance();
                return cpuFragment;
            case 3:
                MemFragment memFragment = MemFragment.getInstance();
                return memFragment;
            case 4:
                OsFragment osFragment = OsFragment.getInstance();
                return osFragment;
            case 5:
                RadioFragment radioFragment = RadioFragment.getInstance();
                return radioFragment;
            case 6:
                SensorFragment sensorFragment = SensorFragment.getInstance();
                return sensorFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount(){
        return mTabsCount;
    }
}
