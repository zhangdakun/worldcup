// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.datahandler;

import android.text.TextUtils;
import com.ifeng.worldcup.configure.ConfigCache;
import com.ifeng.worldcup.configure.Utils;
import com.loopj.android.http.*;

// Referenced classes of package com.ifeng.worldcup.datahandler:
//            IDataHandler

public class VideoDataHandler
{

    public VideoDataHandler()
    {
        client = new AsyncHttpClient();
    }

    public static VideoDataHandler getInstance()
    {
        synchronized(lock)
        {
            if(mSingleton == null)
            {
                mSingleton = new VideoDataHandler();
                mSingleton.init();
            }
        }
        return mSingleton;
//        exception;
//        obj;
//        JVM INSTR monitorexit ;
//        throw exception;
    }

    private boolean init()
    {
        return true;
    }

    public void publishTask(final IDataHandler dataHandler)
    {
        RequestParams requestparams = new RequestParams();
        String s = ConfigCache.getUrlCache(Utils.getUrlWithParams(URL, requestparams));
        if(s != null)
        {
            if(TextUtils.isEmpty(s))
                dataHandler.loadSuccess(null);
            else
                dataHandler.loadSuccess(s);
        } else
        {
            client.get(URL, requestparams, new AsyncHttpResponseHandler() {

                public void onFailure(Throwable throwable, String s1)
                {
                    dataHandler.loadFail(s1);
                }

                public void onSuccess(String s1)
                {
                    if(TextUtils.isEmpty(s1))
                    {
                        dataHandler.loadSuccess(null);
                    } else
                    {
                        ConfigCache.setUrlCache(s1, VideoDataHandler.URL);
                        dataHandler.loadSuccess(s1);
                    }
                }

//                final VideoDataHandler this$0;
//                private final IDataHandler val$dataHandler;
//
//            
//            {
//                this$0 = VideoDataHandler.this;
//                dataHandler = idatahandler;
//                super();
//            }
            }
);
        }
    }

    private static String URL = "http://223.4.149.22:88/api/shijiebei/shipin/0";
    private static Object lock = new Object();
    private static VideoDataHandler mSingleton = null;
    private AsyncHttpClient client;


}
