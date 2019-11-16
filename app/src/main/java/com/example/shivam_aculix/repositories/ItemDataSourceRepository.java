package com.example.shivam_aculix.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.shivam_aculix.models.PicsumApiResponse;

public class ItemDataSourceRepository extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, PicsumApiResponse>> picsumLiveDataSource = new MutableLiveData<>();

    @NonNull
    @Override
    public DataSource create() {
        ItemDataSource itemDataSource=new ItemDataSource();
        picsumLiveDataSource.postValue(itemDataSource);

        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, PicsumApiResponse>> getPicsumLiveDataSource() {
        return picsumLiveDataSource;
    }
}
