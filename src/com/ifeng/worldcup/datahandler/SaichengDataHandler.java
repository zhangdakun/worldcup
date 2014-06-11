// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.datahandler;

import android.text.TextUtils;
import android.util.Log;
import com.ifeng.worldcup.configure.ConfigCache;
import com.ifeng.worldcup.configure.Utils;
import com.loopj.android.http.*;

// Referenced classes of package com.ifeng.worldcup.datahandler:
//            IDataHandler

public class SaichengDataHandler
{

    public SaichengDataHandler()
    {
        client = new AsyncHttpClient();
    }

    public static SaichengDataHandler getInstance()
    {
        synchronized(lock)
        {
            if(mSingleton == null)
            {
                mSingleton = new SaichengDataHandler();
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
        String s = Utils.getUrlWithParams(URL, requestparams);
        Log.d("saicheng", (new StringBuilder(" URL = ")).append(URL).toString());
        String s1 = ConfigCache.getUrlCache(s);
        if(s1 != null)
        {
            if(TextUtils.isEmpty(s1))
                dataHandler.loadSuccess(null);
            else
                dataHandler.loadSuccess(s1);
        } else
        {
            client.get(URL, requestparams, new AsyncHttpResponseHandler() {

                public void onFailure(Throwable throwable, String s2)
                {
                    dataHandler.loadFail(s2);
                }

                public void onSuccess(String s2)
                {
                    if(TextUtils.isEmpty(s2))
                    {
                        dataHandler.loadSuccess(null);
                    } else
                    {
                        Log.d("saicheng", (new StringBuilder(" content = ")).append(s2).toString());
                        ConfigCache.setUrlCache(s2, SaichengDataHandler.URL);
                        dataHandler.loadSuccess(s2);
                    }
                }

//                final SaichengDataHandler this$0;
//                private final IDataHandler val$dataHandler;
//
//            
//            {
//                this$0 = SaichengDataHandler.this;
//                dataHandler = idatahandler;
//                super();
//            }
            }
);
        }
    }

    private static String URL = "http://223.4.149.22:88/api/shijiebei/saicheng";
    private static Object lock = new Object();
    private static SaichengDataHandler mSingleton = null;
    private AsyncHttpClient client;


}
