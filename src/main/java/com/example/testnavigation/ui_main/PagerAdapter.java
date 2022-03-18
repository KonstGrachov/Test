package com.example.testnavigation.ui_main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private Context con;
    public PagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        con = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return PagerFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
