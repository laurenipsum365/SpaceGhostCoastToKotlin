package android.spaceghost.activities

import android.app.Activity
import android.os.Bundle
import android.spaceghost.R
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : Activity() {

    private var videoUrl = ""

    companion object {
        val VIDEO_OBJECT_URL = "VIDEO_OBJECT_URL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        if (intent != null) {
            videoUrl = intent.getStringExtra(VIDEO_OBJECT_URL)
        }

        webView!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }

        //webView.settings.javaScriptEnabled = false
        //webView.settings.loadWithOverviewMode = true
        //webView.settings.useWideViewPort = true
        //webView.settings.builtInZoomControls = true
        //webView.settings.pluginState = WebSettings.PluginState.ON
        webView!!.loadUrl(videoUrl)
    }
}