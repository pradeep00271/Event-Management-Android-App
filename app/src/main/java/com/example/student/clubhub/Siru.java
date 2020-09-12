package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Siru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siru);
        WebView myWebView = (WebView) findViewById(R.id.webview8);
        myWebView.loadUrl("file:///android_asset/customise8.html");
    }
}
