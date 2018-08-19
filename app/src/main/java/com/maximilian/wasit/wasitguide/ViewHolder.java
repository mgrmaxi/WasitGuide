package com.maximilian.wasit.wasitguide;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;


    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

    }

    //set Details to recycle view row

    public void setDetails (Context ctx, String title, String image){

        TextView mTitleTv = mView.findViewById(R.id.titletextView);
        ImageView mImageView = mView.findViewById(R.id.itemImageView);

        mTitleTv.setText(title);
        Picasso.get().load(image).into(mImageView);

    }
}
