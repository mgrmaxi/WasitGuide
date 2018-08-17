package com.maximilian.wasit.wasitguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;



public class LocalsActivity extends AppCompatActivity {

    protected ListView localsList;
    String[] localsNames ={"قضاء الكوت",
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
    String[] summery ={"مركز المحافظة 180 كم جنوبي بغداد",
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
    int[] localsImages ={R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8,
            R.drawable.a9,
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


            }
        });


    }

    class CustomAdapter extends BaseAdapter{


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

            View view = getLayoutInflater().inflate(R.layout.localslayout,null);

            ImageView image = view.findViewById(R.id.localimage);
            TextView Name =  view.findViewById(R.id.localNametext);
            TextView summry =  view.findViewById(R.id.summeryText);

           image.setImageResource(localsImages[position]);
            Name.setText(localsNames[position]);
            summry.setText(summery[position]);

            return view;
        }
    }
}
