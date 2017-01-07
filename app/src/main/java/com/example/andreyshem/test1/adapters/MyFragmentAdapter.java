package com.example.andreyshem.test1.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.andreyshem.test1.FirstFragment;
import com.example.andreyshem.test1.R;
import com.example.andreyshem.test1.SecondFragment;

/**
 * Created by andreyshem on 06.01.2017.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private static int NUM_FRAGMENTS = 2;

    public static String[] items = {"Line 1", "Line 2"};
    public static Integer[] imgID = {R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new FirstFragment();
            case 1: return new SecondFragment();
            default: return null;
        }
    }

    @Override
    public float getPageWidth(int position) {
        return 0.93f;
    }

    @Override
    public int getCount() {
        return NUM_FRAGMENTS;
    }
}
