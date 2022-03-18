package com.example.testnavigation.ui_main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testnavigation.databinding.PagerFargmentBinding;

public class PagerFragment extends Fragment {
    private PagerModel model;
    private PagerFargmentBinding infoFB;

    static PagerFragment newInstance(int index){
        PagerFragment pagerF = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Key",index);
        pagerF.setArguments(bundle);
        return pagerF;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ViewModelProvider(this).get(PagerModel.class);
        int index = 1;
        if (getArguments() != null){
            index = getArguments().getInt("Key");
        }
        model.setIntMLD(index);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        infoFB = PagerFargmentBinding.inflate(inflater,container,false);
        View view = infoFB.getRoot();

        final TextView text = infoFB.textView2;
        model.getStrLD().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                text.setText(s);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        infoFB = null;
    }
}
