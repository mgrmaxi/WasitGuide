package com.maximilian.wasit.wasitguide;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import static android.webkit.URLUtil.isValidUrl;

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
//    TextView itemDscrip;
    ImageView itemimage;
    ImageView OpenMapImageV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        itemtext = findViewById(R.id.titleText);
        infotext = findViewById(R.id.infotext);
//        itemDscrip = findViewById(R.id.dscripTextView);
        itemimage = findViewById(R.id.itemImage);
        OpenMapImageV = findViewById(R.id.OpenMapImageV);


        //get data from intent items list

        String title = getIntent().getStringExtra("name");
        String info = getIntent().getStringExtra("info");
        String image = getIntent().getStringExtra("image");
        final String detail = getIntent().getStringExtra("location");

        ;

        //set data to views
        itemtext.setText(title);
        infotext.setText(info);
        if (isValidUrl(image)){
        Picasso.get().load(image).into(itemimage);
        }
//        itemDscrip.setText(detail);


        //=====================================image with linke ============================
        OpenMapImageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if (isValidUrl(detail)){

                openMap(detail);  // link to item map
            }else {
            openMap("https://goo.gl/maps/Gk7Cqa3dkV22");  // link to wasit map

                }
        }
        });




    }

    public void openMap(String uri) {
        try {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "خطا!! لايوجد تطبيق للخرائط مثبت على هذا الجهاز او غير مفعل", Toast.LENGTH_SHORT).show();
        }
    }
}
