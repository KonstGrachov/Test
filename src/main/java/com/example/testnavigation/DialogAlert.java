package com.example.testnavigation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.work.impl.utils.ForceStopRunnable;

public class DialogAlert extends AppCompatDialogFragment {

    private FragmentManager fragmentManager;
    private int index;

    public DialogAlert(FragmentManager fragmentManage,int index){
        this.fragmentManager = fragmentManager;
        this.index=index;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Меню выбора")
                .setMessage("Какое действие выберете")
                .setPositiveButton("Изменить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent in = new Intent(getContext(),ChangeScreen.class);
                        in.putExtra("ID",index);
                        startActivity(in);
                    }
                })
                .setNegativeButton("Удалить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent in = new Intent(getContext(),DeleteScreen.class);
                        in.putExtra("ID",index);
                        startActivity(in);
                    }
                })
                .setNeutralButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }

    public void show( @Nullable String tag) {
        super.show(fragmentManager, tag);
    }
}
