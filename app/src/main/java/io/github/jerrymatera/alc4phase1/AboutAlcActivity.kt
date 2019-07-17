package io.github.jerrymatera.alc4phase1

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_alc.*


class AboutAlcActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_alc)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.about_alc)

        aboutWebView.settings.javaScriptEnabled = true
        aboutWebView.settings.useWideViewPort = true
        aboutWebView.settings.loadWithOverviewMode = true
        aboutWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (Uri.parse(url).host == "https://andela.com/alc/") {
                    return false
                }

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
                return true

            }

            @RequiresApi(Build.VERSION_CODES.N)
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                val url = request?.url.toString()

                if (Uri.parse(url).host == "https://andela.com/alc/") {
                    return false
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent)
                return true

            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler!!.proceed()
            }

        }
        aboutWebView.loadUrl("https://andela.com/alc/")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        if (aboutWebView.canGoBack()) {
            aboutWebView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
