package com.lucerotech.aleksandrp.amconsofttask1.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lucerotech.aleksandrp.amconsofttask1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerAdapterImages extends RecyclerView.Adapter<RecyclerAdapterImages.TimeViewHolder> {

    // declare elements
    private ArrayList<String> listItems;
    private Context mContext;

    /**
     * constructor
     *
     * @param listItems
     * @param context
     */
    public RecyclerAdapterImages(ArrayList<String> listItems, Context context) {
        this.listItems = listItems;
        this.mContext = context;
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {
        // declare elements
        CardView mCardView;
        ImageView ivIconImage;


        TimeViewHolder(View itemView) {
            super(itemView);
            // find and init views
            mCardView = (CardView) itemView.findViewById(R.id.cv_item_image);
            ivIconImage = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }

    @Override
    public TimeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
        return (new TimeViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final TimeViewHolder holder, final int position) {
        // set ui
        Uri uri = Uri.parse(listItems.get(position));
        Picasso.with(mContext)
                .load(uri)
                .noFade()
                .into(holder.ivIconImage);
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
