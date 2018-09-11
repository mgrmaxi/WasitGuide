package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


public class DistrictsListActivity extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    protected GridView localsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locals);

        localsList = findViewById(R.id.localsList);
        CustomAdapter customAdapter = new CustomAdapter();
        localsList.setAdapter(customAdapter);


        localsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get data from list
                String mTitle = localsNames[position];
                String mImage = getString(localsImages[position]);


                //pass this data to new activity
                Intent intent = new Intent(view.getContext(), DistrictActivity.class);
                intent.putExtra("name", mTitle); // put name
                intent.putExtra("image", mImage); // put image

                startActivity(intent); //start activity


            }
        });


    }




}
