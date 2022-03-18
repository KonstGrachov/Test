package com.example.testnavigation.bottom_navi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testnavigation.R;
import com.example.testnavigation.RecyclerCarusuel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class InfoFragment extends Fragment {


    public InfoFragment(){}
    public static InfoFragment newInstance(){
        return new InfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_fragment,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = view.findViewById(R.id.vp_1);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        viewPager.setAdapter(new RecyclerCarusuel(getParentFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}
