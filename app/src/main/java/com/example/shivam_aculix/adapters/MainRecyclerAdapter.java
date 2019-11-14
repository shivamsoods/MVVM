package com.example.shivam_aculix.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.shivam_aculix.R;
import com.example.shivam_aculix.models.MainImageModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

private List<MainImageModel> mImageList;
private Context mContext;

public MainRecyclerAdapter(Context context, List<MainImageModel> MainImages) {
        mImageList = MainImages;
        mContext = context;
        }

@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.image_model_layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
        }

@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((ViewHolder)viewHolder).mName.setText(mImageList.get(i).getAuthor());

        RequestOptions defaultOptions = new RequestOptions()
        .error(R.drawable.ic_launcher_background);

        Glide.with(mContext)
        .setDefaultRequestOptions(defaultOptions)
        .load(mImageList.get(i).getDownload_url())
        .into(((ViewHolder)viewHolder).mImage);
        }

@Override
public int getItemCount() {
        return mImageList.size();
        }

private class ViewHolder extends RecyclerView.ViewHolder{

    private CircleImageView mImage;
    private TextView mName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.image);
        mName = itemView.findViewById(R.id.image_name);
    }
}
}
