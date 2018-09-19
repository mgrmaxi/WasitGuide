package com.maximilian.wasit.wasitguide;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class WasitActivity extends BaseActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    ImageView mapImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wasit);

        mapImage = findViewById(R.id.mapimage);

        //=====================================image with linke ============================

        mapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap("https://goo.gl/maps/Gk7Cqa3dkV22");  // link to wasit map
            }
        });


    }


    //=======================================open app ( map app) and go to an custom location==============
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
