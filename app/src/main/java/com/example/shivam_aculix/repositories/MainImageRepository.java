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

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MainImageRepository {

    private static MainImageRepository instance;
    private ArrayList<MainImageModel> dataSet = new ArrayList<>();
    private Call<List<MainImageModel>> call;

    public static MainImageRepository getInstance() {
        if (instance == null) {
            instance = new MainImageRepository();
        }
        return instance;
    }

    public MutableLiveData<List<MainImageModel>> getMainImages() {
        makeAPICall();

        MutableLiveData<List<MainImageModel>> data = new MutableLiveData<>();
        data.setValue(dataSet);
        Log.d(TAG, "getMainImages: "+dataSet);
        return data;
    }


    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl("https://picsum.photos/v2/")
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private APIService apiCall = retrofit.create(APIService.class);


    private void makeAPICall() {

        call = apiCall.getImageList();
        call.enqueue(new Callback<List<MainImageModel>>() {
            @Override
            public void onResponse(Call<List<MainImageModel>> call, Response<List<MainImageModel>> response) {
                List<MainImageModel> list = response.body();

                assert list != null;
                setDataSet(list);
            }

            @Override
            public void onFailure(Call<List<MainImageModel>> call, Throwable t) {

            }
        });
    }

    private void setDataSet(List<MainImageModel> list) {
        for (MainImageModel imageModel : list) {
            Log.d(TAG, "setDataSet: "+imageModel.getAuthor());
            dataSet.add(new MainImageModel(imageModel.getAuthor(),
                    imageModel.getDownload_url())
            );
        }

    }
}





