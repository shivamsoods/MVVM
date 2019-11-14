package com.example.shivam_aculix.repositories;

import com.example.shivam_aculix.models.MainImageModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("list")
    Call<List<MainImageModel>>getImageList();
}
