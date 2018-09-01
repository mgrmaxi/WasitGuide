package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SearchActivity extends AppCompatActivity {

    private SearchView mSearchField;
    private ImageButton mSearchBtn;
    private RecyclerView mResultList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mDatabase = FirebaseDatabase.getInstance().getReference("قضاء الكوت").child("المؤسسات الحكومية");

//TODO
        mSearchField =  findViewById(R.id.searchEditText);
       mSearchBtn =  findViewById(R.id.searchBtn);
//
        mResultList =  findViewById(R.id.searchRecycle);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String searchText = mSearchField.getQuery().toString();

                firebaseSearch(searchText);
                Toast.makeText(SearchActivity.this, "ok you do it", Toast.LENGTH_SHORT).show();
            }
        });

        mSearchField.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                Toast.makeText(SearchActivity.this, "ok you do it", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Filter as you type
                firebaseSearch(newText);
                Toast.makeText(SearchActivity.this, "ok you do it", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }

    private void firebaseSearch(String searchText) {

        //convert string entered in SearchView to lowercase
        String query = searchText.toLowerCase();

        Query firebaseSearchQuery = mDatabase.orderByChild(query).startAt(query).endAt(query + "\uf8ff");

        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.localslayout,
                        ViewHolder.class,
                        firebaseSearchQuery

                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(getApplicationContext(), model.getTitle(),  model.getImage());

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
                                //String mDesc = getItem(position).getDscrip();


                                //pass this data to new activity
                                Intent intent = new Intent(view.getContext(), SearchActivity.class);
                                intent.putExtra("title", mTitle); // put title
                                intent.putExtra("image", mImage); //put bitmap url
                                //intent.putExtra("dscrip", mDesc); //put description
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



}
