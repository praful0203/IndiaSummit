package com.prafulmishra.girlscriptsummit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.prafulmishra.girlscriptsummit.R.layout.activity_about_us);

        TextView textView = (TextView) findViewById(com.prafulmishra.girlscriptsummit.R.id.about_gs);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
