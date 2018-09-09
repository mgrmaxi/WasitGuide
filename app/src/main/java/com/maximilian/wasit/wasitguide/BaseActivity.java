package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

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
                if (getClass() == LocalsActivity.class) {
                    Toast.makeText(this, "انت في نفس الصفحة", Toast.LENGTH_SHORT).show();
                } else {
                    intent = new Intent(BaseActivity.this, LocalsActivity.class);
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
}