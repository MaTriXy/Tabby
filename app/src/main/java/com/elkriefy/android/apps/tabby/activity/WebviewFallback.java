package com.elkriefy.android.apps.tabby.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.elkriefy.android.apps.tabby.util.CustomTabActivityHelper;

/**
 * A Fallback that opens a Webview when Custom Tabs is not available
 */
public class WebviewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, uri.toString());
        activity.startActivity(intent);
    }
}