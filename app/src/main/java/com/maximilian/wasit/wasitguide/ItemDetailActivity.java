package com.maximilian.wasit.wasitguide;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ItemDetailActivity extends AppCompatActivity {

    TextView itemtext;
    TextView itemDscrip;
    ImageView itemimage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        itemtext = findViewById(R.id.titleText);
        itemDscrip=findViewById(R.id.dscripTextView);
        itemimage = findViewById(R.id.itemImage);



        //get data from intent

        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String detail = getIntent().getStringExtra("dscrip");
        ;

        //set data to views
        itemtext.setText(title);
        itemDscrip.setText(detail);
        Picasso.get().load(image).into(itemimage);




    }
}
