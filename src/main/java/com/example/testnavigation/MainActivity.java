package com.example.testnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.testnavigation.bottom_navi.GroupFragment;
import com.example.testnavigation.bottom_navi.HomeFragment;
import com.example.testnavigation.bottom_navi.InfoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final BottomNavigationView.OnNavigationItemSelectedListener yes = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_home:
                    loadFragment(HomeFragment.newInstance());
                    return true;
                case R.id.menu_group:
                    loadFragment(GroupFragment.newInstance());
                    return true;
                case R.id.menu_info:
                    loadFragment(InfoFragment.newInstance());
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.fl_id,fragment);
        fT.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction fT = getSupportFragmentManager().beginTransaction();
        fT.replace(R.id.fl_id,HomeFragment.newInstance());
        fT.commit();
        BottomNavigationView bottom = findViewById(R.id.bnv);
        bottom.setOnNavigationItemSelectedListener(yes);
    }
}
