package com.example.recyclerviewandfragmentexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> mutableLiveData;

    public void initialize(){
        mutableLiveData = new MutableLiveData<String>();
    }

    public void setDataValue(String value){
        mutableLiveData.setValue(value);
    }

    public MutableLiveData<String> getMutableLiveData(){
        return mutableLiveData;
    }
}
