package com.example.testnavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.testnavigation.fragments_viewpager1.FirstPager;
import com.example.testnavigation.fragments_viewpager1.SecondPager;
import com.example.testnavigation.fragments_viewpager1.ThirdPager;

import java.util.ArrayList;

public class RecyclerCarusuel extends FragmentPagerAdapter {

    private ArrayList<String> arrayLS= new ArrayList<>();
    private Fragment fragment;

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayLS.get(position);
    }

    public RecyclerCarusuel(@NonNull FragmentManager fm) {
        super(fm);
        arrayLS.add("Распростронение");
        arrayLS.add("Ошибки");
        arrayLS.add("О программе");
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
         switch(position){
            case 0:
                fragment = new FirstPager();
                break;
            case 1:
                fragment = new SecondPager();
                break;
            case 2:
                fragment = new ThirdPager();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return arrayLS.size();
    }
}
