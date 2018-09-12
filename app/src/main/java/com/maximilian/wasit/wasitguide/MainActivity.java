package com.maximilian.wasit.wasitguide;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;


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

//##############################################  views  ######################################

    ImageView forgroundImage;
    ScrollView scrollView;
    ImageButton getlocalsbtn;
    ImageView mapImage;
    List<Integer> lstImages = new ArrayList<>(); // for slider
    protected GridView categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        forgroundImage = findViewById(R.id.forgroundimage);

        getlocalsbtn = findViewById(R.id.getlocalsbtn);
        scrollView = findViewById(R.id.scrollView3);
        mapImage = findViewById(R.id.mapimage);

//////////////////////////list of category
        categoryList = findViewById(R.id.categoryList);
        CustomAdapter2 customAdapter = new CustomAdapter2();
        categoryList.setAdapter(customAdapter);


//===================================logo at top of activity ===============================
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.applilogo_round);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
//===================================foreground animated image ==============================

        Display display = getWindowManager().getDefaultDisplay();
        forgroundImage.animate().translationYBy(-display.getHeight()).setDuration(1000).setStartDelay(3000);

//=====================================image with linke ============================

        mapImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap("https://goo.gl/maps/Gk7Cqa3dkV22");  // link to wasit map
            }
        });


//===================================== slider images =============================

        sliderImages();

        HorizontalInfiniteCycleViewPager pager = findViewById(R.id.horizontal_cycle);
        HorizontalInfiniteCycleViewPager pager2 = findViewById(R.id.horizontal_cycle2);
        SliderAdapter adapter = new SliderAdapter(lstImages,getBaseContext());
        pager.setAdapter(adapter);
        pager2.setAdapter(adapter);




//=====================================button ============================
        getlocalsbtn.setOnClickListener(new View.OnClickListener() {  // go to locals activity
            public void onClick(View view) {


                Intent intent = new Intent(MainActivity.this, DistrictsListActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

//================================= button scrolle code ======================================

        scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                if (scrollView != null) {
                    if (scrollView.getChildAt(0).getBottom() <= (scrollView.getHeight() + scrollView.getScrollY())) {
                        getlocalsbtn.animate().translationY(-50).getStartDelay();

                    } else {
                        getlocalsbtn.animate().translationY(500).getStartDelay();

                    }

                }

            }
        });

/////////////////////////////////////click items in list ///////////////////////////////////////
        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get data from list
                String mCategory = catigoryNames[position];
                String mImage = getString(catigoryImages[position]);
//                String mDiscrip = catigorydiscrip[position];




                //pass this data to new activity
                Intent intent = new Intent(view.getContext(), ItemsListActivity.class);
                String title = "واسط";

                intent.putExtra("localRef", title); // put name
                intent.putExtra("category", mCategory); // put name


                startActivity(intent); //start activity


            }
        });

////////////////////////////oncreate() end ////////////////////////////
    }

    private void sliderImages() {
        lstImages.add(R.drawable.maz);
        lstImages.add(R.drawable.kut);
        lstImages.add(R.drawable.city);
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


///////////////////////////////end main//////////////////////////////////////////
}





















