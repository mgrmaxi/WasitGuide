package com.maximilian.wasit.wasitguide;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

ScrollView scrollView;
    ImageButton getlocalsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getlocalsbtn = findViewById(R.id.getlocalsbtn);
        scrollView = findViewById(R.id.scrollView3);


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
                        getlocalsbtn.setVisibility(View.VISIBLE);
                        Log.i("this is info ","scroll:"+scrollView.getScrollX());
                       }
                    else {
                        getlocalsbtn.setVisibility(View.INVISIBLE);
                        Log.i("this is info ","scroll:"+scrollView.getScrollX());
                    }
                }

                }

       });







    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.Home_menu_item:
                Toast.makeText(this,"انت في الصفحة الرئيسية",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.About_us_menu_item:
                Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                MainActivity.this.startActivity(intent);
                return true;

            default:
                Toast.makeText(this,"انت في الصفحة الرئيسية",Toast.LENGTH_SHORT).show();
                return super.onOptionsItemSelected(item);

        }
    }





    }



















