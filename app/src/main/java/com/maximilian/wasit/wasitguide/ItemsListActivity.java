package com.maximilian.wasit.wasitguide;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ItemsListActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("category");

        mRecyclerView =findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase= FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("قضاء الكوت").child("المؤسسات الحكومية");


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
                    };


            mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
