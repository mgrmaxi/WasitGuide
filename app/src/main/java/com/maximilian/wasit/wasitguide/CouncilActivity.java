package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
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

public class CouncilActivity extends BaseActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    TextView mtitle;
    ImageView mimage;
    TextView mdiscripText;
    protected GridView categoryList;


    String[] catigoryNames = {"المؤسسات الحكومية",
            "المستشفيات والمراكز الصحية",
            "محطات الوقود والكراجات",
            "الفنادق والمطاعم",
            "الاماكن الترفيهية",
            "الجامعات والمدارس",
            "المراكز الدينية والسياحية",

    };

//    String[] catigorydiscrip = {"ومنظمات المجتمع المدني",
//            "",
//            "",
//            " ",
//            " ",
//            " ",
//            " ",
//
//
//    };

    int[] catigoryImages = {R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s5,
            R.drawable.s5,


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_council);


        categoryList = findViewById(R.id.categoryList);
        CouncilActivity.CustomAdapter customAdapter = new CustomAdapter();
        categoryList.setAdapter(customAdapter);

        mtitle = findViewById(R.id.council_title);
        mimage = findViewById(R.id.council_image);
        mdiscripText = findViewById(R.id.council_discripText);


        String title = getIntent().getStringExtra("name");
        mtitle.setText(title);

//        String image = getIntent().getStringExtra("image");
//        String conimage = image.substring(13, 16);
//
//        int id = getResources().getIdentifier(conimage, "drawable", this.getPackageName());
//        if (id != 0) {
//            mimage.setImageResource(id);
//
//        } else {
//            mimage.setImageResource(R.drawable.a07);
//        }
//TODO add all locals
        switch (title) {
            case "قضاء الكوت":
                mdiscripText.setText(R.string.kut_info);
                mimage.setImageResource(R.drawable.a01);
                break;
        }


        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //get data from list
                String mCategory = catigoryNames[position];
                String mImage = getString(catigoryImages[position]);
//                String mDiscrip = catigorydiscrip[position];




                //pass this data to new activity
                Intent intent = new Intent(view.getContext(), ItemsListActivity.class);
                String title = getIntent().getStringExtra("name");

                intent.putExtra("localRef", title); // put name
                intent.putExtra("category", mCategory); // put name


                startActivity(intent); //start activity


            }
        });


    }


    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return catigoryImages.length;
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
            TextView summry = view.findViewById(R.id.summeryText);

            image.setImageResource(catigoryImages[position]);
            Name.setText(catigoryNames[position]);
           // summry.setText(catigorydiscrip[position]);

            return view;
        }

    }


}
