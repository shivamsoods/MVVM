package com.example.shivam_aculix.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shivam_aculix.models.MainImageModel;
import com.example.shivam_aculix.repositories.MainImageRepository;

import java.util.List;

public class MainViewModel  extends ViewModel {

    private MutableLiveData<List<MainImageModel>> mMainImages;
    private MainImageRepository mRepo;

    public void init(){
        if(mMainImages != null){
            return;
        }
        mRepo = MainImageRepository.getInstance();
        mMainImages = mRepo.getMainImages();

    }


    public LiveData<List<MainImageModel>> getMainImages(){
        return mMainImages;
    }


}

