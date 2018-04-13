package com.example.surajbokankar.serverless;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        webView=findViewById(R.id.web_view);
        setUrl();
    }

    private void setUrl() {
        webView.loadUrl("https://drugdiscovery-4f2c4.firebaseapp.com/demo.html");  //file:///Users/suraj.bokankar/Downloads/demo.html
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.addJavascriptInterface(new WebAppInterface(MainActivity.this), "Android");

    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        //show the web page in webview but not in web browser
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.i(TAG, "shouldOverrideUrlLoading: ="+url);
            //view.loadUrl (url);
            return true;
        }
    }


    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Log.i(TAG, "showToast: ="+toast);
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }
}
