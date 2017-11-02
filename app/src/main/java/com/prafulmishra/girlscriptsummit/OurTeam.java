package com.prafulmishra.girlscriptsummit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class OurTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.prafulmishra.girlscriptsummit.R.layout.activity_our_team);
        String url = "https://gsindiasummit.com/#mu-speakers";
        WebView view = (WebView)this.findViewById(com.prafulmishra.girlscriptsummit.R.id.webview);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);
    }
}
