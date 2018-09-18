package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


public class SearchActivity extends BaseActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private SearchView mSearchField;
    private RecyclerView mResultList;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String distract = getIntent().getStringExtra("localRef");
        String category = getIntent().getStringExtra("category");

//Log.i("LLLLLLLLLLog Distract",distract.toString());
//Log.i("LLLLLLLLLLog Distract",category.toString());
//
          databaseReference = FirebaseDatabase.getInstance().getReference(distract).child(category);
//TODO
        mSearchField = findViewById(R.id.searchEditText);
        mResultList = findViewById(R.id.searchRecycle);

        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

//


            mSearchField.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    firebaseSearch(query);
                    Toast.makeText(SearchActivity.this, "ok you do it", Toast.LENGTH_SHORT).show();
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

                    firebaseSearch(newText);
                    return false;
                }
            });


    }

    private void firebaseSearch(String searchText) {

            //convert string entered in SearchView to lowercase
            String query = searchText.toLowerCase();

            Query firebaseSearchQuery = databaseReference.orderByChild("name").startAt(query).endAt(query + "\uf8ff");
            Log.i("looooooog222", databaseReference.toString());
            FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                    new FirebaseRecyclerAdapter<Model, ViewHolder>(
                            Model.class,
                            R.layout.row,
                            ViewHolder.class,
                            firebaseSearchQuery

                    ) {
                        @Override
                        protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                            viewHolder.setDetails(getApplicationContext(), model.getName(), model.getImage());

                        }

                        @Override
                        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                            ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);


                            viewHolder.setOnClickListner(new ViewHolder.ClickListener() {
                                @Override
                                public void onItemClick(View view, int position) {
                                    //Views

                                    //get data from views
                                    String mTitle = getItem(position).getName();
                                    String mInfo = getItem(position).getInfo();
                                    String mImage = getItem(position).getImage();
                                    String mDesc = getItem(position).getLocation();


                                    //pass this data to new activity
                                    Intent intent = new Intent(view.getContext(), ItemDetailActivity.class);
                                    intent.putExtra("name", mTitle); // put name
                                    intent.putExtra("info", mInfo); //put bitmap url
                                    intent.putExtra("image", mImage); //put bitmap url
                                    intent.putExtra("location", mDesc); //put bitmap url
                                    startActivity(intent); //start activity


                                }

                                @Override
                                public void onItemLongClick(View view, int position) {
                                    //TODO do your own implementaion on long item click
                                }
                            });

                            return viewHolder;
                        }

                    };


            mResultList.setAdapter(firebaseRecyclerAdapter);

    }

//    @Override
//    protected void onStart(){
//        super.onStart();
//
//
//        FirebaseRecyclerAdapter<Model ,  ViewHolder> firebaseRecyclerAdapter =
//                new FirebaseRecyclerAdapter<Model, ViewHolder>(
//                        Model.class,
//                        R.layout.row,
//                        ViewHolder.class,
//                        mDatabase
//                ) {
//                    @Override
//                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
//                        viewHolder.setDetails(getApplicationContext(),model.getName(),model.getImage());
//                    }
//
//                    @Override
//                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
//                        viewHolder.setOnClickListner(new ViewHolder.ClickListener() {
//                            @Override
//                            public void onItemClick(View view, int position) {
//                                //Views
//
//                                //get data from views
//                                String mTitle = getItem(position).getName();
//                                String mImage = getItem(position).getImage();
//                                // String mDesc = mDescTv.getText().toString();
//
//
//                                //pass this data to new activity
//                                Intent intent = new Intent(view.getContext(), ItemDetailActivity.class);
//                                intent.putExtra("name", mTitle); // put name
//                                intent.putExtra("image", mImage); //put bitmap url
//
//                                //intent.putExtra("location", mDesc); //put location
//                                startActivity(intent); //start activity
//
//
//                            }
//
//                            @Override
//                            public void onItemLongClick(View view, int position) {
//                                //TODO on long item click
//                            }
//                        });
//
//                        return viewHolder;
//                    }
//
//                };
//
//
//
//        mResultList.setAdapter(firebaseRecyclerAdapter);
//    }

}
