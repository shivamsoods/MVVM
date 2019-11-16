package com.example.shivam_aculix.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.shivam_aculix.network.APIService;
import com.example.shivam_aculix.network.PicsumApiResponse;
import com.example.shivam_aculix.network.RetrofitClient;
import com.example.shivam_aculix.models.MainImageModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;


public class MainImageRepository {

    private static String BASE_URL="https://picsum.photos/v2/";
    private static MainImageRepository instance;
    private MutableLiveData<List<MainImageModel>> LiveDataList = new MutableLiveData<>();


    public static MainImageRepository getInstance() {
        if (instance == null) {
            instance = new MainImageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<MainImageModel>> getMainImages() {
        APIService apiCall = retrofit.create(APIService.class);
        Call<List<MainImageModel>> call = apiCall.getImageList();


Call<PicsumApiResponse> call1=RetrofitClient.getInsance()
        .getApi().getImageList(2,2);


call1.enqueue(new Callback<PicsumApiResponse>() {
    @Override
    public void onResponse(Call<PicsumApiResponse> call, Response<PicsumApiResponse> response) {
        PicsumApiResponse picsumApiResponse=response.body();

    }

    @Override
    public void onFailure(Call<PicsumApiResponse> call, Throwable t) {

    }
});


        call.enqueue(new Callback<List<MainImageModel>>() {
            @Override
            public void onResponse(Call<List<MainImageModel>> call, Response<List<MainImageModel>> response) {
            LiveDataList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MainImageModel>> call, Throwable t) {
            }
        });

        Log.d(TAG, "getMainImagesRepository: " + LiveDataList.getValue());

        return LiveDataList;
    }

    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

}





