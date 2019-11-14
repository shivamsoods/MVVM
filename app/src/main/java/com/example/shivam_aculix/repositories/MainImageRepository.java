package com.example.shivam_aculix.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.shivam_aculix.models.MainImageModel;

import java.util.ArrayList;
import java.util.List;

public class MainImageRepository {

    private static MainImageRepository instance;
    private ArrayList<MainImageModel> dataSet = new ArrayList<>();

    public static MainImageRepository getInstance(){
        if(instance == null){
            instance = new MainImageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<MainImageModel>> getMainImages(){
        setMainImages();
        MutableLiveData<List<MainImageModel>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        return data;
    }

    private void setMainImages(){


    }
}





