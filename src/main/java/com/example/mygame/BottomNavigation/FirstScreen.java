package com.example.mygame.BottomNavigation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mygame.R;

import java.util.ArrayList;

public class FirstScreen extends Fragment {
    private int progress=0;
    private int damage = 6;
    private TextView textView;
    private ProgressBar progressBar;
    private ImageView imageView;
    private Handler handler;
    private ArrayList<Image> icons = new ArrayList<>();
    public FirstScreen(){}
    public static FirstScreen newInstance(){
        return new FirstScreen();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_screen,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView3);
        Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.animation_1);
        imageView.setImageResource(R.drawable.ic_monster_3);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_style));
        progressBar.setProgress(100);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("-"+damage);
                progress = progressBar.getProgress() - damage;
                progressBar.setProgress(progress);
            }
        });
    }
}
