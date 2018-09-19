package com.maximilian.wasit.wasitguide;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AboutUsActivity extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    protected ListView staffList;
    String[] staffNames = {"نائل فاضل",
            "",
            "",
            " ",
            " ",
            " ",

    };
    String[] job = {"التصميم والبرمجة",
            "قواعد البيانات",
            "قواعد البيانات",
            "قواعد البيانات",
            "قواعد البيانات",
            "قواعد البيانات",

    };
    int[] localsImages = {R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        staffList = findViewById(R.id.staffList);
        AboutUsActivity.CustomAdapter customAdapter = new CustomAdapter();
        staffList.setAdapter(customAdapter);


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

            View view = getLayoutInflater().inflate(R.layout.grid_item, null);

            ImageView image = view.findViewById(R.id.localimage);
            TextView Name = view.findViewById(R.id.localNametext);
            TextView summry = view.findViewById(R.id.summeryText);

            image.setImageResource(localsImages[position]);
            Name.setText(staffNames[position]);
            summry.setText(job[position]);

            return view;
        }

    }


}
