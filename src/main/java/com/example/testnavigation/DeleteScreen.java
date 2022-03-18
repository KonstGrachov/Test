package com.example.testnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class DeleteScreen extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_screen);

        int id = getIntent().getExtras().getInt("ID");

        b1 = findViewById(R.id.b_delete);
        b2 = findViewById(R.id.b_main);
        tv1 = findViewById(R.id.tv_name);
        tv2 = findViewById(R.id.tv_group);

        DateBase db = new DateBase(this);
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor cursor = database.query(DateBase.TABLE_NAME,null,null,null,null,null,null);
        if (cursor.moveToPosition(id)) {
            Log.i("OBJECT","FOUND");
            tv1.setText(cursor.getString(cursor.getColumnIndexOrThrow(DateBase.KEY_NAME)));
            tv2.setText(cursor.getString(cursor.getColumnIndexOrThrow(String.valueOf(DateBase.KEY_NUMBER))));
        } else {
            Log.i("OBJECT","NOTFOUND");
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.delete(DateBase.TABLE_NAME, DateBase.KEY_ID +" = "+ id,null);
                Snackbar.make(view,"Успешно удаленено!",Snackbar.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });

    }
}