package cc.czc.cn.boringtime.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import cc.czc.cn.boringtime.R;

/**
 * Created by czc on 2017/2/20.
 */

public class GanHuoDetailActivity extends AppCompatActivity {
    WebView webView;
    long exitTime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganhuo_url);
        Intent intent = getIntent();
        final String url = intent.getStringExtra("url");
        webView = (WebView) findViewById(R.id.wv_ganhuo_url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        }else {
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(this, "再点击一次退出", Toast.LENGTH_SHORT).show();
                exitTime =  System.currentTimeMillis();
            }else {
                super.onBackPressed();
            }
        }
    }
}
