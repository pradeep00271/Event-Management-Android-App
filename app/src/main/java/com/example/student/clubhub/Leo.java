package com.example.student.clubhub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Leo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leo);
        WebView myWebView = (WebView) findViewById(R.id.webview3);
        myWebView.loadUrl("file:///android_asset/customise3.html");
    }
}
