package com.elkriefy.android.apps.tabby.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.elkriefy.android.apps.tabby.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.web_view)
    WebView mWebView;

    public static final String EXTRA_URL =
            "com.elkriefy.android.apps.tabby.activity.WebViewActivity.EXTRA_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        String url = getIntent().getStringExtra(EXTRA_URL);
        mWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        setupActionBar(url);
    }

    private void setupActionBar(String url) {
        setTitle(url);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }
}