package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Spar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spar);
        WebView myWebView = (WebView) findViewById(R.id.webview9);
        myWebView.loadUrl("file:///android_asset/customise9.html");
    }
}
