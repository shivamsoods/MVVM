package com.example.shivam_aculix.repositories;


import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.shivam_aculix.models.PicsumApiResponse;
import com.example.shivam_aculix.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDataSource extends PageKeyedDataSource<Integer, PicsumApiResponse> {

    public static final String TAG="ITEM DATA SOURCE";
    public static final int LIST_SIZE = 15;
    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, PicsumApiResponse> callback) {
        RetrofitClient.getInsance()
                       .getApi()
                       .getImageList(FIRST_PAGE, LIST_SIZE)
                       .enqueue(new Callback<List<PicsumApiResponse>>() {
            @Override
            public void onResponse(Call<List<PicsumApiResponse>> call, Response<List<PicsumApiResponse>> response) {
                if (response.body() != null) {
                    callback.onResult(response.body(), null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<List<PicsumApiResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PicsumApiResponse> callback) {

        RetrofitClient.getInsance()
                        .getApi()
                        .getImageList(params.key, LIST_SIZE)
                        .enqueue(new Callback<List<PicsumApiResponse>>() {
            @Override
            public void onResponse(Call<List<PicsumApiResponse>> call, Response<List<PicsumApiResponse>> response) {
                Log.d(TAG, "onResponse: load before "+params.key);
                if (response.body() != null) {
                    Integer key = (params.key > 1) ? params.key - 1 : null;
                    callback.onResult(response.body(), key);
                }
            }

            @Override
            public void onFailure(Call<List<PicsumApiResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, PicsumApiResponse> callback) {
        RetrofitClient.getInsance()
                .getApi()
                .getImageList(params.key, LIST_SIZE)
                .enqueue(new Callback<List<PicsumApiResponse>>() {
            @Override
            public void onResponse(Call<List<PicsumApiResponse>> call, Response<List<PicsumApiResponse>> response) {
                if (response.body() != null) {
                    //Integer key = (response.body()) ? params.key + 1 : null;
                    Log.d(TAG, "onResponse: after load "+ params.key);
                    callback.onResult(response.body(), params.key+1);
                }
            }

            @Override
            public void onFailure(Call<List<PicsumApiResponse>> call, Throwable t) {

            }
        });
    }
}
