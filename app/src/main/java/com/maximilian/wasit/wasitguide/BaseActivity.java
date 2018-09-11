package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {
    String[] localsNames = {"قضاء الكوت",
            "واسط",
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
        setContentView(R.layout.activity_main);

//TODO make spinner for choose locals and category

    }


    //++++++++++++++++++++++++++++menu+++++++++++++++++++++++++++++//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.search_menu_item:
                Intent intent = new Intent(BaseActivity.this, SearchActivity.class);
                BaseActivity.this.startActivity(intent);
                return true;

            case R.id.About_us_menu_item:
                if (getClass() == AboutUsActivity.class) {
                    Toast.makeText(this, "انت في نفس الصفحة", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(BaseActivity.this, AboutUsActivity.class);
                    BaseActivity.this.startActivity(intent);
                }
                return true;
            case R.id.list:
                if (getClass() == DistrictsListActivity.class) {
                    Toast.makeText(this, "انت في نفس الصفحة", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(BaseActivity.this, DistrictsListActivity.class);
                    BaseActivity.this.startActivity(intent);
                }
                return true;
            case R.id.Home_menu_item:
                if (getClass() == MainActivity.class) {
                    Toast.makeText(this, "انت بالفعل في الصفحة الرئيسية", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(BaseActivity.this, MainActivity.class);
                    BaseActivity.this.startActivity(intent);
                }
            default:

                return super.onOptionsItemSelected(item);

        }
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


            image.setImageResource(localsImages[position]);
            Name.setText(localsNames[position]);


            return view;
        }
    }

    class CustomAdapter2 extends BaseAdapter {


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