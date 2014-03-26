package com.example.odycircus;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by vbrice on 24/03/14.
 */
public class Map extends Activity implements View.OnClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.map);

        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://ns303921.ovh.net/~odycircu/map.html");
    }

    public void onClick(View view){

    }
}
