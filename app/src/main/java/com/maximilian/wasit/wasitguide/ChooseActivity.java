package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class ChooseActivity extends BaseActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }




    private Spinner dSpinner;
    private Spinner cSpinner;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ImageButton mSearchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);




        String[] str = new String[10];
        localsNames[0]="واسط";
        localsImages[0]=R.drawable.a01;

        dSpinner = findViewById(R.id.dSpinner);
        cSpinner = findViewById(R.id.cSpinner);

        adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,localsNames);
        adapter2 = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,catigoryNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BaseActivity.thinCustomAdapter adapter = new BaseActivity.thinCustomAdapter();
        BaseActivity.thinCustomAdapter2 adapter2 = new BaseActivity.thinCustomAdapter2();

        dSpinner.setAdapter(adapter);
        cSpinner.setAdapter(adapter2);
        dSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                   position = dSpinner.getSelectedItemPosition();
                                                   String distract = localsNames[position].toString();
//
                                                   if(distract=="واسط"){
                                                       cSpinner.setVisibility(View.VISIBLE);
                                                   }else {
                                                       cSpinner.setVisibility(View.GONE);
                                                   }

                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {

                                               }
                                           }
        );
        cSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                                                 @Override
                                                 public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



//
                                                     (localsNames[position]).toString();

                                                 }

                                                 @Override
                                                 public void onNothingSelected(AdapterView<?> parent) {

                                                 }
                                             }
        );

        mSearchBtn = findViewById(R.id.chooseAndGoBtn);


        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = dSpinner.getSelectedItemPosition();
                String distract = localsNames[position];
                int position2 = cSpinner.getSelectedItemPosition();
                String category = catigoryNames[position2];



                //pass this data to new activity
        Intent intent = new Intent(view.getContext(), SearchActivity.class);


        intent.putExtra("localRef", distract); // put name
                if(distract=="واسط"){
                    intent.putExtra("category", category); // put name

                }else {
                    intent.putExtra("category", "اهم الاماكن"); // put name

                }



        startActivity(intent); //start activity

            }
        });



    }
    public void setWindowParams() {
        WindowManager.LayoutParams wlp = getWindow().getAttributes();
        wlp.dimAmount = 0;
        wlp.flags = WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS |
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL;
        getWindow().setAttributes(wlp);
    }
}
