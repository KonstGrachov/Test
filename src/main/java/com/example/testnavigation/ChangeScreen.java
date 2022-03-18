package com.example.testnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class ChangeScreen extends AppCompatActivity {

    private EditText ed1;
    private EditText ed2;
    private Button b;
    private Button b2;
    private String name;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_screen);

        int id = getIntent().getExtras().getInt("ID");

        ed1 = findViewById(R.id.ed_cs1);
        ed2 = findViewById(R.id.ed_cs2);
        b2 = findViewById(R.id.b_cs);
        b = findViewById(R.id.b_cs2);

        DateBase dbhelper = new DateBase(this);
        SQLiteDatabase database = dbhelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (ed2 != null && ed1 != null && !ed1.getText().toString().equals("")) {
                        name = ed1.getText().toString();
                        number = ed2.getText().toString();
                        values.put(DateBase.KEY_NAME,name);
                        values.put(String.valueOf(DateBase.KEY_NUMBER),number);
                        database.update(DateBase.TABLE_NAME,values,DateBase.KEY_ID+" = "+id,null);
                        Snackbar.make(view,"Успешно изменено!",Snackbar.LENGTH_SHORT).show();
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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(in);
            }
        });
    }
}
