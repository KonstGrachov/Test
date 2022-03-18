package com.example.testnavigation.ui_main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PagerModel extends ViewModel {
    private MutableLiveData<Integer> intMLD = new MutableLiveData<>();
    private LiveData<String> strLD = Transformations.map(intMLD, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "This is " + input;
        }
    });

    public void setIntMLD(int index) {
        intMLD.setValue(index);
    }

    public LiveData<String> getStrLD() {
        return strLD;
    }
}
