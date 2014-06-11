// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.configure;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.InputStream;
import org.apache.http.util.EncodingUtils;

public class SaichengUtil
{

    public SaichengUtil()
    {
    }

    public static String getFromAssets(Context context, String s)
    {
        String s1 = "";
        String s2;
        try{
        	
        
        InputStream inputstream = context.getResources().getAssets().open(s);
        byte abyte0[] = new byte[inputstream.available()];
        inputstream.read(abyte0);
        s2 = EncodingUtils.getString(abyte0, "utf-8");
        s1 = s2;
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        Log.d("saicheng", "getFromAssets, "+s1);
//_L2:
        return s1;
//        Exception exception;
//        exception;
//        exception.printStackTrace();
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    public static String getSaicheng(Context context)
    {
        return getFromAssets(context, "saicheng");
    }
}
