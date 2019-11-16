package com.example.shivam_aculix.network;


import com.example.shivam_aculix.models.PicsumApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("list")
    Call<List<PicsumApiResponse>> getImageList(@Query("page") int page_no,
                                               @Query("limit") int limit);

}
