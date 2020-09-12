package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Gtimes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gtimes);
        WebView myWebView = (WebView) findViewById(R.id.webview1);
        myWebView.loadUrl("file:///android_asset/customise1.html");

    }
}
