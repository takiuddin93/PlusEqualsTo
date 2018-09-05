package plusequalsto.com.plusequalstoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PrivacyPolicyActivity extends AppCompatActivity {
    WebView privacyPolicy;
    String Policy_URL = "https://www.plusequalsto.com/privacy-policy/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        privacyPolicy = (WebView) findViewById(R.id.privacyPolicy);
        privacyPolicy.setWebViewClient(new PrivacyPolicyWebView());
        privacyPolicy.loadUrl(Policy_URL);
        WebSettings webSettings = privacyPolicy.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
    }
    private class PrivacyPolicyWebView extends WebViewClient {
        @Override
        public  boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
