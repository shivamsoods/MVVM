package com.example.shivam_aculix.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shivam_aculix.R;
import com.example.shivam_aculix.network.PicsumApiResponse;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainRecyclerPagedAdapter extends PagedListAdapter<PicsumApiResponse, MainRecyclerPagedAdapter.ItemViewHolder> {

    private Context mContext;

    public MainRecyclerPagedAdapter(Context mContext) {
        super(DIFF_CALLBACK);
        this.mContext = mContext;
    }

    protected MainRecyclerPagedAdapter(@NonNull AsyncDifferConfig<PicsumApiResponse> config) {
        super(config);
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.image_model_layout,parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        PicsumApiResponse picsumApiResponse=getItem(position);

        if(picsumApiResponse!=null){

            holder.mName.setText(picsumApiResponse.getAuthor());

            Picasso.get()
                    .load(picsumApiResponse.getDownload_url())
                    .resize(120, 120)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .into(holder.mImage);
        }
        else {
            Toast.makeText(mContext, "ERROR 101", Toast.LENGTH_SHORT).show();
        }




    }

    private static DiffUtil.ItemCallback<PicsumApiResponse> DIFF_CALLBACK = new DiffUtil.ItemCallback<PicsumApiResponse>() {
        @Override
        public boolean areItemsTheSame(@NonNull PicsumApiResponse oldItem, @NonNull PicsumApiResponse newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull PicsumApiResponse oldItem, @NonNull PicsumApiResponse newItem) {
            return false;
        }
    };

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView mImage;
        private TextView mName;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
        }

    }

}
