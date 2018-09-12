package com.maximilian.wasit.wasitguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DistrictActivity extends BaseActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    TextView mtitle;
    ImageView mimage;
    TextView mdiscripText;

////////
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;
    String localRef;
    String category;
///////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_council);







        mtitle = findViewById(R.id.council_title);
        mimage = findViewById(R.id.council_image);
        mdiscripText = findViewById(R.id.council_discripText);
        Display display = getWindowManager().getDefaultDisplay();  // get display to set height and width programmatically

        mimage.getLayoutParams().height = display.getHeight()/2-100; //image responsive



        String title = getIntent().getStringExtra("name");
        mtitle.setText(title);

////////////
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        mFirebaseDatabase = FirebaseDatabase.getInstance();


        localRef = getIntent().getStringExtra("name");
        category = getIntent().getStringExtra("category");


        mRef = mFirebaseDatabase.getReference(localRef).child("المؤسسات الحكومية");

//////////



//        String image = getIntent().getStringExtra("image");
//        String conimage = image.substring(13, 16);
//
//        int id = getResources().getIdentifier(conimage, "drawable", this.getPackageName());
//        if (id != 0) {
//            mimage.setImageResource(id);
//
//        } else {
//            mimage.setImageResource(R.drawable.a07);
//        }
//TODO add all locals
        switch (title) {
            case "قضاء الكوت":
                mdiscripText.setText(R.string.kut_info);
                mimage.setImageResource(R.drawable.a01);
                break;
        }





    }


    /////////////////

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
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
                                String mDesc = getItem(position).getDescription();


                                //pass this data to new activity
                                Intent intent = new Intent(view.getContext(), ItemDetailActivity.class);
                                intent.putExtra("name", mTitle); // put name
                                intent.putExtra("info", mInfo); //put bitmap url
                                intent.putExtra("image", mImage); //put bitmap url
                                intent.putExtra("description", mDesc); //put bitmap url


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
///////////
public class imageaspect extends android.support.v7.widget.AppCompatImageView{

    public imageaspect(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * getDrawable().getIntrinsicHeight() / getDrawable().getIntrinsicWidth();
        setMeasuredDimension(width, height);
    }
}
}
