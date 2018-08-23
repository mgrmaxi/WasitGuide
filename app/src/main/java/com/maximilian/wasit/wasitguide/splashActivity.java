package com.maximilian.wasit.wasitguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class splashActivity extends AppCompatActivity {
     ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         imageView = findViewById(R.id.imageView9);

//------------------ CLICKABLE IMAGE TO GET NEXT ACTIVITY --------------------//
         imageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                 startActivity(intent);
             }
         });

        //------------------ GO TO NEXT ACTIVITY IN 3 SECONDS  --------------------//

        Thread thread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(3000); // SECONDS TO DEFINE TIME
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    // TODO finish(); // DESTROY THIS ACTIVITY

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }
}
