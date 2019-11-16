package com.example.shivam_aculix.repositories;


import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.shivam_aculix.network.PicsumApiResponse;
import com.example.shivam_aculix.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, PicsumApiResponse> {

    private static final int PAGE_FIRST = 1;
    public static final int LIST_SIZE = 20;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PicsumApiResponse> callback) {
        RetrofitClient.getInsance().getApi().getImageList(PAGE_FIRST, LIST_SIZE).enqueue(new Callback<PicsumApiResponse>() {
            @Override
            public void onResponse(Call<PicsumApiResponse> call, Response<PicsumApiResponse> response) {
                if (response.body() != null) {
                    callback.onResult(response.body().getImageList(), null, PAGE_FIRST + 1);
                }
            }

            @Override
            public void onFailure(Call<PicsumApiResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PicsumApiResponse> callback) {

        RetrofitClient.getInsance().getApi().getImageList(params.key,LIST_SIZE).enqueue(new Callback<PicsumApiResponse>() {
            @Override
            public void onResponse(Call<PicsumApiResponse> call, Response<PicsumApiResponse> response) {
                 if(response.body()!=null){
                     Integer key=(params.key>1)?params.key-1:null;
                     callback.onResult(response.body().getImageList(),key);
                 }
            }

            @Override
            public void onFailure(Call<PicsumApiResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PicsumApiResponse> callback) {
        RetrofitClient.getInsance().getApi().getImageList(params.key,LIST_SIZE).enqueue(new Callback<PicsumApiResponse>() {
            @Override
            public void onResponse(Call<PicsumApiResponse> call, Response<PicsumApiResponse> response) {
                if(response.body()!=null){
                    Integer key =(response.body().isHas_more())?params.key+1: null;
                    callback.onResult(response.body().getImageList(),key);
                }
            }

            @Override
            public void onFailure(Call<PicsumApiResponse> call, Throwable t) {

            }
        });
    }
}
