// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.*;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.*;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifeng.worldcup.widget.LoadStateView;
//import com.umeng.analytics.MobclickAgent;

public class WebviewActivity extends Activity
    implements android.view.View.OnClickListener
{
    private class MyWebViewClient extends WebViewClient
    {

        public void onPageFinished(WebView webview, String s)
        {
            isPageLoading = false;
            if(isProgressShowing && !isPageLoading)
            {
                Message message = Message.obtain();
                message.what = 0;
                mHandler.sendMessage(message);
                isProgressShowing = false;
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            isPageLoading = true;
            if(!isProgressShowing)
            {
                Message message = Message.obtain();
                message.what = 1;
                mHandler.sendMessage(message);
                isProgressShowing = true;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            String s1 = Uri.parse(s).getScheme();
            if(s1.equalsIgnoreCase("https") || s1.equalsIgnoreCase("http"))
                webview.loadUrl(s);
            return false;
        }

//        final WebviewActivity this$0;
//
//        private MyWebViewClient()
//        {
//            this$0 = WebviewActivity.this;
//            super();
//        }

//        MyWebViewClient(MyWebViewClient mywebviewclient)
//        {
//            this();
//        }
    }


    public WebviewActivity()
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                
                switch (message.what) {
				case 0:
	                mLoadStateView.stopLoad();
	                mWebView.getSettings().setBlockNetworkImage(false);
					break;
				case 1:
					mLoadStateView.startLoad();
					break;
				default:
					break;
				}
                
//                message.what;
//                JVM INSTR tableswitch 0 1: default 32
//            //                           0 33
//            //                           1 60;
//                   goto _L1 _L2 _L3
//_L1:
//                return;
//_L2:
//                mLoadStateView.stopLoad();
//                mWebView.getSettings().setBlockNetworkImage(false);
//                continue; /* Loop/switch isn't completed */
//_L3:
//                mLoadStateView.startLoad();
//                if(true) goto _L1; else goto _L4
//_L4:
            }

//            final WebviewActivity this$0;
//
//            
//            {
//                this$0 = WebviewActivity.this;
//                super();
//            }
        }
;
    }

    private void share()
    {
//        String s = MobclickAgent.getConfigParams(this, "share");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "\u5206\u4EAB");
//        intent.putExtra("android.intent.extra.TEXT", s);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    public void onClick(View view)
    {
//        view.getId();
//        JVM INSTR lookupswitch 2: default 32
//    //                   2131034123: 40
//    //                   2131034153: 33;
//           goto _L1 _L2 _L3
//_L1:
//        return;
//_L3:
//        finish();
//        continue; /* Loop/switch isn't completed */
//_L2:
//        share();
//        if(true) goto _L1; else goto _L4
//_L4:
    	
    	switch (view.getId()) {
		case 2131034123:
			share();
			break;
		case 2131034153:
			finish();
			break;
		default:
			break;
		}
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03000c);
        mWebView = (WebView)findViewById(0x7f05003a);
        mLoadStateView = (LoadStateView)findViewById(0x7f050026);
        url = getIntent().getStringExtra("url");
        title = getIntent().getStringExtra("title");
        titleTextView = (TextView)findViewById(0x7f050029);
        shareImageView = (ImageView)findViewById(0x7f05000b);
//        MobclickAgent.updateOnlineConfig(this);
        titleTextView.setText(title);
        shareImageView.setOnClickListener(this);
        titleTextView.setOnClickListener(this);
        mWebView.setScrollBarStyle(0);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.setFocusable(true);
        mWebView.setFocusableInTouchMode(true);
        mWebView.getSettings().setDefaultTextEncodingName("UTF-8");
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.loadUrl(url);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        boolean flag;
        if(i == 4 && mWebView.canGoBack() && mWebView.copyBackForwardList().getCurrentIndex() > 0)
        {
            mWebView.goBack();
            flag = true;
        } else
        {
            flag = super.onKeyDown(i, keyevent);
        }
        return flag;
    }

    public void onPause()
    {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    protected static final int DISMISS_LOADING = 0;
    protected static final int SHOW_LOADING = 1;
    private boolean isPageLoading;
    private boolean isProgressShowing;
    private Handler mHandler;
    private LoadStateView mLoadStateView;
    private WebView mWebView;
    private ImageView shareImageView;
    private String title;
    private TextView titleTextView;
    private String url;







}
