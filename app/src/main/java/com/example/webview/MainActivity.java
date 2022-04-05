package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
WebView webView;
ProgressBar pgbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView =findViewById(R.id.web_view);
        pgbar= findViewById(R.id.pgbar);

        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgbar.setVisibility(view.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pgbar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
            //            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack();
        }else {
            super.onBackPressed();
        }
    }
}