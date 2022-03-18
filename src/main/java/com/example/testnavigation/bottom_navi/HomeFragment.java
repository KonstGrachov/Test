package com.example.testnavigation.bottom_navi;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testnavigation.DeleteScreen;
import com.example.testnavigation.databinding.GroupFragmentBindingImpl;
import com.example.testnavigation.DateBase;
import com.example.testnavigation.MainActivity;
import com.example.testnavigation.R;
import com.example.testnavigation.RecyclerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private AdView adV;
    private Button b;
    private EditText ed1;
    private EditText ed2;
    private String name;
    private String number;

    public HomeFragment(){}
    public static HomeFragment newInstance(){
        return  new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragmrnt,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DateBase dbHelper = new DateBase(getContext());

        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        adV = view.findViewById(R.id.adView);
        AdRequest adR = new AdRequest.Builder().build();
        adV.loadAd(adR);
        adV.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
//                Идёт сюда
//                adV.loadAd(adR);
                Log.i("ADWASNTLOADED","THATSNOTYOURFAULT");
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.i("KEY-LOADERRORE","AD LOADING");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        ed1 = view.findViewById(R.id.ed_1);
        ed2 = view.findViewById(R.id.ed_2);
        b = view.findViewById(R.id.button);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (ed2 != null && ed1 != null && !ed1.getText().toString().equals("")) {
                        name = ed1.getText().toString();
                        number = ed2.getText().toString();
                        values.put(DateBase.KEY_NAME,name);
                        values.put(DateBase.KEY_NUMBER,number);
                        database.insert(DateBase.TABLE_NAME,null,values);
                        Snackbar.make(view,"Успешно добавлено!",Snackbar.LENGTH_SHORT).show();
                    } else {
                        ed1.setText("");
                        ed2.setText("");
                        Snackbar.make(view,"Введите во все поля данные",Snackbar.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e){
                    ed1.setText("");
                    ed2.setText("");
                    Snackbar.make(view,"Введите во все поля данные",Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}
/**
    Ссылка на сайт про SQLite в Android Studio: https://www.internet-technologies.ru/articles/ispolzovanie-prostoy-bazy-dannyh-sqlite-v-android-prilozhenii.html
 */
