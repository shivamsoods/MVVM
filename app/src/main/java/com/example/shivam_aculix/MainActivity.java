package com.example.shivam_aculix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shivam_aculix.adapters.MainRecyclerPagedAdapter;

import com.example.shivam_aculix.models.PicsumApiResponse;
import com.example.shivam_aculix.viewmodels.MainItemViewModel;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        MainItemViewModel mMainViewModel = ViewModelProviders.of(this).get(MainItemViewModel.class);
        final MainRecyclerPagedAdapter mAdapter = new MainRecyclerPagedAdapter(this);

        mMainViewModel.picsumPagedList.observe(this, new Observer<PagedList<PicsumApiResponse>>() {
            @Override
            public void onChanged(PagedList<PicsumApiResponse> picsumApiResponses) {
                mAdapter.submitList(picsumApiResponses);
                mAdapter.notifyDataSetChanged();
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }
}