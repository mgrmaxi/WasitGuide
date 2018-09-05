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

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
                return true;
            }
        });
    }

    //set Details to recycle view row

    public void setDetails (Context ctx, String title, String image){

        TextView mTitleTv = mView.findViewById(R.id.titletextView);
        ImageView mImageView = mView.findViewById(R.id.itemImageView);



        mTitleTv.setText(title);
        Picasso.get().load(image).into(mImageView);



    }
    private ViewHolder.ClickListener mClickListener;

    // call items

    public interface ClickListener{

        void onItemClick (View view , int position);
        void onItemLongClick (View view , int position);
    }
    public void setOnClickListner (ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
