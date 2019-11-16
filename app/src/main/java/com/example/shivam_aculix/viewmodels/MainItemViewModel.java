package com.example.shivam_aculix.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.shivam_aculix.network.PicsumApiResponse;
import com.example.shivam_aculix.repositories.ItemDataSource;
import com.example.shivam_aculix.repositories.ItemDataSourceRepository;

public class MainItemViewModel extends ViewModel {

    public LiveData<PagedList<PicsumApiResponse>> picsumPagedList;
    public LiveData<PageKeyedDataSource<Integer, PicsumApiResponse>> picsumLiveDataSource;


    public MainItemViewModel() {
        ItemDataSourceRepository itemDataSourceRepository = new ItemDataSourceRepository();
        picsumLiveDataSource = itemDataSourceRepository.getPicsumLiveDataSource();

        PagedList.Config config = (new PagedList.Config.Builder())
                                    .setEnablePlaceholders(false)
                                    .setPageSize(ItemDataSource.LIST_SIZE)
                                    .build();

        picsumPagedList = (new LivePagedListBuilder(itemDataSourceRepository, config)).build();
    }
}
