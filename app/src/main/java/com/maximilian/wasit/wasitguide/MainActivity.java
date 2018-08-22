package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;


public class MainActivity extends AppCompatActivity {

    private FloatingActionMenu fam;
    private FloatingActionButton fabAbout, fabSearch, fabHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabHome = (FloatingActionButton) findViewById(R.id.fab1);
        fabSearch = (FloatingActionButton) findViewById(R.id.fab2);
        fabAbout = (FloatingActionButton) findViewById(R.id.fab3);
        fam = (FloatingActionMenu) findViewById(R.id.fab_menu);


        ImageButton getlocalsbtn = findViewById(R.id.getlocalsbtn);
        getlocalsbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ItemsListActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

//handling menu status (open or close)
        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if (opened) {
                    showToast("Menu is opened");
                } else {
                    showToast("Menu is closed");
                }
            }
        });

        //handling each floating action button clicked
        fabHome.setOnClickListener(onButtonClick());
        fabSearch.setOnClickListener(onButtonClick());
        fabAbout.setOnClickListener(onButtonClick());

        fam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fam.isOpened()) {
                    fam.close(true);
                }
            }
        });


    }

    private View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == fabSearch) {
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    MainActivity.this.startActivity(intent);
                } else if (view == fabHome) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    MainActivity.this.startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, AboutUsActivity.class);
                    MainActivity.this.startActivity(intent);
                }
                fam.close(true);
            }
        };
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
