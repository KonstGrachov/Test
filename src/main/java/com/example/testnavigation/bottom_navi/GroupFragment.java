package com.example.testnavigation.bottom_navi;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.example.testnavigation.DateBase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testnavigation.R;
import com.example.testnavigation.RecyclerAdapter;

public class GroupFragment extends Fragment {

    static RecyclerView recycler;

    public GroupFragment(){}
    public static GroupFragment newInstance(){
        return  new GroupFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.group_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.rv_yes);
        registerForContextMenu(recycler);
        setHasOptionsMenu(true);

        DateBase dBhelp = new DateBase(getContext());
        SQLiteDatabase database = dBhelp.getReadableDatabase();
        Cursor cursor = database.query(DateBase.TABLE_NAME,null,null,null,null,null,null);
        recycler.setAdapter(new RecyclerAdapter(cursor,getParentFragmentManager(),getContext()));
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

//        for(int i=0; i < MainActivity.listOfStringGroup.size();i++){
//            for(int l= i+1; l<MainActivity.listOfStringGroup.size();l++){
//                if(!MainActivity.listOfStringGroup.get(i).equals(MainActivity.listOfStringGroup.get(l))){
//                }
//            }
//        }

//        for (String str : MainActivity.listOfStringGroup){
//            menu.add(str);
//        }

        inflater.inflate(R.menu.group_manu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        DateBase dateBase = new DateBase(getContext());
        SQLiteDatabase database = dateBase.getWritableDatabase();
        Cursor cursor = null;
        switch(item.getItemId()){
            case R.id.first_item_in_group:
                database.delete(DateBase.TABLE_NAME,null,null);
                break;
            case R.id.second_item_in_group:
                cursor = database.query(DateBase.TABLE_NAME,null,DateBase.KEY_NUMBER+"=1",null,null,null,null);
                recycler.setAdapter(new RecyclerAdapter(cursor,getParentFragmentManager(),getContext()));
                break;
            case R.id.third_item_in_group:
                cursor = database.query(DateBase.TABLE_NAME,null,null,null,null,null,null);
                recycler.setAdapter(new RecyclerAdapter(cursor,getParentFragmentManager(),getContext()));
        }
        return true;
    }
}
