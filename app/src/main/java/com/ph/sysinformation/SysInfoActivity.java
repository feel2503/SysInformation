package com.ph.sysinformation;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SysInfoActivity extends AppCompatActivity{

    private ViewPager mViewPager;
    private ViewPagerAdapter mPageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mPageradapter = new ViewPagerAdapter (getSupportFragmentManager());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("DEVICE"));
        tabLayout.addTab(tabLayout.newTab().setText("SOC"));
        tabLayout.addTab(tabLayout.newTab().setText("CPU"));
        tabLayout.addTab(tabLayout.newTab().setText("MEMORY"));
        tabLayout.addTab(tabLayout.newTab().setText("OS"));
        tabLayout.addTab(tabLayout.newTab().setText("RADIO"));
        tabLayout.addTab(tabLayout.newTab().setText("SENSOR"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        mViewPager.setAdapter(mPageradapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
