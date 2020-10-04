package com.example.ktpractice_webview

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this


        wv_main.settings.javaScriptEnabled = true //자바스크립트 사용

        wv_main.settings.pluginState = WebSettings.PluginState.ON
//        set.setPluginState(WebSettings.PluginState.ON);

        //크로스 도메인 관련
        wv_main.settings.allowFileAccess = true
        wv_main.settings.allowContentAccess = true
        wv_main.settings.allowFileAccessFromFileURLs = true
        wv_main.settings.allowUniversalAccessFromFileURLs = true


        wv_main.settings.javaScriptCanOpenWindowsAutomatically = true //javascript가 window.open()을 사용할 수 있도록 설정

        //줌기능 제거
        wv_main.settings.builtInZoomControls = false
        wv_main.settings.setSupportZoom(false)

//        wv_main.settings.blockNetworkImage = false // 네트워크의 이미지의 리소스를 로드하지않음
        wv_main.settings.setSupportMultipleWindows(false) // 새창 띄우기 허용여

        wv_main.settings.loadsImagesAutomatically = true // 웹뷰가 앱에 등록되어 있는 이미지 리소스를 자동으로 로드하도록 설정

        wv_main.settings.useWideViewPort = true // wide viewport를 사용하도록 설정
        wv_main.settings.cacheMode = WebSettings.LOAD_NO_CACHE // 웹뷰가 캐시를 사용하지 않도록 설정

        wv_main.settings.domStorageEnabled = true //로컬스토리지 사용허용


        wv_main.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                //true를 반환하면 외부 웹브라우져 사용한다.
                return false //내부브라우져로 열기부
            }
        }

        wv_main.addJavascriptInterface(WebBridge(),"webview")


        wv_main.loadUrl("http://ubiqos001.iptime.org:10070/")

        mWvMain = wv_main
    }

    companion object {
//        var mHandler : Handler? = Handler()
        var mContext : Context? = null
        var mWvMain : WebView? = null
    }

    class WebBridge {
        @JavascriptInterface
        fun getNum(num: Int) {

            GlobalScope.launch(Dispatchers.Main) {
                Toast.makeText(mContext,"계산 결과는 $num 입니다.",Toast.LENGTH_SHORT).show()
                mWvMain?.loadUrl("javascript:webview.onCallback(\"hello\")")
            }
//            mHandler?.post {
//                Toast.makeText(mContext,"계산 결과는 $num 입니다.",Toast.LENGTH_SHORT).show()
//                mWvMain?.loadUrl("javascript:webview.onCallback(\"hello\")")
//            }

        }
    }
}