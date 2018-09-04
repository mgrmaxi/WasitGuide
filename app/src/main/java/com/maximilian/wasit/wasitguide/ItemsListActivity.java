package com.maximilian.wasit.wasitguide;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;


public class ItemsListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    String localRef ;
    String category;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();


        localRef = getIntent().getStringExtra("localRef");
        category = getIntent().getStringExtra("category");


        mRef = mFirebaseDatabase.getReference(localRef).child(category);

        Log.i("catttttttttttt", category);
        Log.i("Reeeeeeeeet", localRef);


    }

    @Override
        protected void onStart(){
            super.onStart();

            FirebaseRecyclerAdapter<Model ,  ViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Model, ViewHolder>(
                            Model.class,
                            R.layout.row,
                            ViewHolder.class,
                            mRef
                    ) {
                        @Override
                        protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                            viewHolder.setDetails(getApplicationContext(),model.getTitle(),model.getImage());
                        }

                        @Override
                        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                            ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                            viewHolder.setOnClickListner(new ViewHolder.ClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    //Views

                                    //get data from views
                                    String mTitle = getItem(position).getTitle();
                                    String mImage = getItem(position).getImage();
                                   // String mDesc = mDescTv.getText().toString();


                                    //pass this data to new activity
                                    Intent intent = new Intent(view.getContext(), ItemDetailActivity.class);
                                    intent.putExtra("title", mTitle); // put title
                                    intent.putExtra("image", mImage); //put bitmap url

                                    //intent.putExtra("description", mDesc); //put description
                                    startActivity(intent); //start activity


                                }

                                @Override
                                public void onItemLongClick(View view, int position) {
                                    //TODO on long item click
                                }
                            });

                            return viewHolder;
                        }

                    };



            mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
