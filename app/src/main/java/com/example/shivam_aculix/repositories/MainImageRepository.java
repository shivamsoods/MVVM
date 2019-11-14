package com.example.shivam_aculix.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.shivam_aculix.models.MainImageModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainImageRepository {

    private static MainImageRepository instance;
    private ArrayList<MainImageModel> dataSet = new ArrayList<>();
    private MutableLiveData<List<MainImageModel>> LiveData = new MutableLiveData<>();

    public static MainImageRepository getInstance() {
        if (instance == null) {
            instance = new MainImageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<MainImageModel>> getMainImages() {

        APIService apiCall = retrofit.create(APIService.class);
        Call<List<MainImageModel>> call = apiCall.getImageList();

        call.enqueue(new Callback<List<MainImageModel>>() {
            @Override
            public void onResponse(Call<List<MainImageModel>> call, Response<List<MainImageModel>> response) {
                List<MainImageModel> list = response.body();

                assert list != null;
                for (MainImageModel imageModel : list) {
                    dataSet.add(new MainImageModel(imageModel.getAuthor(),imageModel.getDownload_url())
                    );
                }

            }

            @Override
            public void onFailure(Call<List<MainImageModel>> call, Throwable t) {

            }
        });
        LiveData.setValue(dataSet);
        return LiveData ;
    }


    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl("https://picsum.photos/v2/")
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();



}





