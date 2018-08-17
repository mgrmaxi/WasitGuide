package com.maximilian.wasit.wasitguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CouncilActivity extends AppCompatActivity {


    protected ListView categoryList;
    String[] catigoryNames ={"الدوائر والمؤسسات الحكومية",
            "المستشفيات والمراكز الصحية",
            "محطات الوقود والكراجات",
            "الفنادق والمطاعم",
            "المتنزهات العامة",
            "الجامعات والمدارس",
            "المناطق الاثرية والسياحية",
            "المزارات والمراكز الدينية",

    };

    String[] catigorydiscrip ={"نائل فاضل",
            "",
            "",
            " ",
            " ",
            " ",
            " ",
            " ",

    };

    int[] catigoryImages ={R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
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

            View view = getLayoutInflater().inflate(R.layout.localslayout,null);

            ImageView image = view.findViewById(R.id.localimage);
            TextView Name =  view.findViewById(R.id.localNametext);
            TextView summry =  view.findViewById(R.id.summeryText);

            image.setImageResource(catigoryImages[position]);
            Name.setText(catigoryNames[position]);
            summry.setText(catigorydiscrip[position]);

            return view;
        }

    }

    }
