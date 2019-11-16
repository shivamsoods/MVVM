package com.example.shivam_aculix.network;

import com.example.shivam_aculix.models.MainImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("list")
    Call<List<MainImageModel>>getImageList();

    @GET("list")
    Call<PicsumApiResponse> getImageList(@Query("page") int page_no,
                                                   @Query("limit") int limit);

}
