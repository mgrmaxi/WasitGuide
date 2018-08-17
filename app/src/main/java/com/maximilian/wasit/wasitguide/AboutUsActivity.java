package com.maximilian.wasit.wasitguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {
    TextView textc4i ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        textc4i=findViewById(R.id.textView3);

        textc4i.setText("وهي مبادرة إنسانية غير ربحية تهدف الى خدمة المجتمع عن طريق البرمجة Programming. تعتبر “Code For IRAQ” مبادرة تعليمية حقيقية ترعى المهتمين بتعلم تصميم وبرمجة تطبيقات الهاتف الجوال ومواقع الانترنت وبرامج الحاسوب والشبكات والاتصالات ونظم تشغيل الحاسوب باستخدام التقنيات مفتوحة المصدر Open Source ، كما توفر لهم جميع الدروس التعليمية اللازمة وبشكل مجاني تماماً");
    }
}
