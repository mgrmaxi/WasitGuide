package com.maximilian.wasit.wasitguide;


import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;




public class MainActivity extends BaseActivity {
//############################################## menu ######################################
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

//##############################################  End menu ######################################

    ScrollView scrollView;
    ImageButton getlocalsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getlocalsbtn = findViewById(R.id.getlocalsbtn);
        scrollView = findViewById(R.id.scrollView3);
        ImageView mapImage = findViewById(R.id.mapimage);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.applilogo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);



        mapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap("https://goo.gl/maps/Gk7Cqa3dkV22");
            }
        });


        getlocalsbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, LocalsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });



        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView != null) {
                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                        getlocalsbtn.animate().translationY(-50).getStartDelay();

                       }
                    else {
                        getlocalsbtn.animate().translationY(500).getStartDelay();

                    }

                }

            }
       });

    }
                public void openMap(String uri){
                try {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                    startActivity(intent);
                }
                catch (ActivityNotFoundException e)
                {
                    Toast.makeText(this, "خطا!! لايوجد تطبيق للخرائط مثبت على هذا الجهاز او غير مفعل", Toast.LENGTH_SHORT).show();
                }
    }


}





















