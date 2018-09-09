package com.maximilian.wasit.wasitguide;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ItemDetailActivity extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    TextView itemtext;
    TextView infotext;
    TextView itemDscrip;
    ImageView itemimage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        itemtext = findViewById(R.id.titleText);
        infotext = findViewById(R.id.infotext);
        itemDscrip = findViewById(R.id.dscripTextView);
        itemimage = findViewById(R.id.itemImage);


        //get data from intent

        String title = getIntent().getStringExtra("title");
        String info = getIntent().getStringExtra("info");
        String image = getIntent().getStringExtra("image");
        String detail = getIntent().getStringExtra("dscrip");

        ;

        //set data to views
        itemtext.setText(title);
        infotext.setText(info);
        Picasso.get().load(image).into(itemimage);
        itemDscrip.setText(detail);


    }
}
