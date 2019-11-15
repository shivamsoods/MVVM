package com.example.shivam_aculix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.shivam_aculix.adapters.MainRecyclerAdapter;
import com.example.shivam_aculix.models.MainImageModel;
import com.example.shivam_aculix.viewmodels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainRecyclerAdapter mAdapter;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.rv_main);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mMainViewModel.init();

        mMainViewModel.getMainImages().observe(this, new Observer<List<MainImageModel>>() {
            @Override
            public void onChanged(@Nullable List<MainImageModel> mainImageModels) {
                initRecyclerView(mainImageModels);
                mAdapter.notifyDataSetChanged();
            }
        });




    }

    private void initRecyclerView(List<MainImageModel> mainImageModels){
        Log.d("TAG", "initRecyclerViewMAIN: "+ mMainViewModel.getMainImages().getValue());
            //mAdapter = new MainRecyclerAdapter(mMainViewModel.getMainImages().getValue());
            mAdapter=new MainRecyclerAdapter(mainImageModels);
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();


    }

}






