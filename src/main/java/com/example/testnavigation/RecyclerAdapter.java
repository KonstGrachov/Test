package com.example.testnavigation;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HolderRecycler>{


    private Cursor cursor;
    private FragmentManager fragmentManager;
    private Context context;

    public RecyclerAdapter (Cursor cursor, FragmentManager fragmentManager,Context context){
        this.cursor=cursor;
        this.fragmentManager=fragmentManager;
        this.context=context;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public HolderRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context con = parent.getContext();
        int layout_id=R.layout.holder_recycler;
        LayoutInflater inflater = LayoutInflater.from(con);
        View view = inflater.inflate(layout_id,parent,false);
        HolderRecycler holder = new HolderRecycler(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecycler holder, int position) {
        cursor.moveToPosition(position);
        holder.bind(cursor);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    class HolderRecycler extends RecyclerView.ViewHolder {

        TextView text;
        TextView textAlpha;

        @RequiresApi(api = Build.VERSION_CODES.M)
        public HolderRecycler(@NonNull View itemView) {
            super(itemView);
            textAlpha = itemView.findViewById(R.id.tv_rv_2);
            text = itemView.findViewById(R.id.tv_rv);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    DialogAlert alert = new DialogAlert(fragmentManager,getAdapterPosition());
                    alert.show(fragmentManager,"Work");
                    return true;
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cursor.moveToPosition(getAdapterPosition());
                    Log.i("OBJECT_ID", String.valueOf(cursor.getPosition()));
                    Snackbar.make(view, "Имя: " + cursor.getString(cursor.getColumnIndexOrThrow(DateBase.KEY_NAME)) + " \nГруппа: " + cursor.getString(cursor.getColumnIndexOrThrow(String.valueOf(DateBase.KEY_NUMBER))),Snackbar.LENGTH_SHORT).show();
                }
            });
        }

        public void bind(Cursor cursor){
            text.setText(cursor.getString(cursor.getColumnIndexOrThrow(DateBase.KEY_NAME)));
        }
    }
}
// getAdapterPosition() Возвращает позицию элемента
// getLayoutPosition() тоже что и getAdapterPosition()