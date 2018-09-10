package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class LocalsActivity extends BaseActivity {

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
    String[] localsNames = {"قضاء الكوت",
            "قضاء الصويرة",
            "قضاء الحي",
            "قضاء العزيزية",
            "قضاء النعمانية",
            "قضاء بدرة",
            "ناحية تاج الدين",
            "ناحية الشحيمية",
            "ناحية الزبيدية",
            "ناحية الدبوني",
            "ناحية الاحرار",
            "ناحية شيخ سعد",
            "ناحية واسط",
            "ناحية الموفقية",
            "ناحية جصان",
            "ناحية زرباطية",
            "ناحية البشائر",
    };

//    String[] summery = {"الكوت",
//            "قضاء الصويرة",
//            "قضاء الحي",
//            "قضاء العزيزية",
//            "قضاء النعمانية",
//            "قضاء بدرة",
//            "ناحية تاج الدين",
//            "ناحية الشحيمية",
//            "ناحية الزبيدية",
//            "ناحية الدبوني",
//            "ناحية الاحرار",
//            "ناحية شيخ سعد",
//            "ناحية واسط",
//            "ناحية الموفقية",
//            "ناحية جصان",
//            "ناحية زرباطية",
//            "ناحية البشائر",
//    };
    int[] localsImages = {
            R.drawable.a01,
            R.drawable.a02,
            R.drawable.a03,
            R.drawable.a04,
            R.drawable.a05,
            R.drawable.a06,
            R.drawable.a07,
            R.drawable.a08,
            R.drawable.a09,
            R.drawable.a10,
            R.drawable.a11,
            R.drawable.a12,
            R.drawable.a13,
            R.drawable.a14,
            R.drawable.a15,
            R.drawable.a16,
            R.drawable.a17,

    };

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
//                String mDiscrip = summery[position];

                // String mDesc = mDescTv.getText().toString();


                //pass this data to new activity
                Intent intent = new Intent(view.getContext(), CouncilActivity.class);
                intent.putExtra("name", mTitle); // put name
                intent.putExtra("image", mImage); // put image
//                intent.putExtra("description", mDiscrip); // put discrip
                Log.i("nummmmmmm", getString(localsImages[position]));

                //intent.putExtra("description", mDesc); //put description
                startActivity(intent); //start activity


            }
        });


    }

    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return localsImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.localslayout, null);

            ImageView image = view.findViewById(R.id.localimage);
            TextView Name = view.findViewById(R.id.localNametext);
//            TextView summry = view.findViewById(R.id.summeryText);

            image.setImageResource(localsImages[position]);
            Name.setText(localsNames[position]);
//            summry.setText(summery[position]);

            return view;
        }
    }


}
