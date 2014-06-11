// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.*;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.ifeng.worldcup.configure.NetworkUtils;
import java.io.File;
import java.util.*;

public class WorldcupApplication extends Application
{

    public WorldcupApplication()
    {
        mList = new LinkedList();
    }

    public static String getChannel()
    {
        String s = "8888";
        String s1 = null;
		try {
			s1 = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        s = s1;
//_L2:
        if(TextUtils.isEmpty(s))
            s = "8888";
        return s;
//        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
//        namenotfoundexception;
//        namenotfoundexception.printStackTrace();
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    /**
     * @deprecated Method getInstance is deprecated
     */

    public static WorldcupApplication getInstance()
    {
//        com/ifeng/worldcup/WorldcupApplication;
//        JVM INSTR monitorenter ;
        WorldcupApplication worldcupapplication;
        if(instance == null)
            instance = new WorldcupApplication();
        worldcupapplication = instance;
//        com/ifeng/worldcup/WorldcupApplication;
//        JVM INSTR monitorexit ;
        return worldcupapplication;
//        Exception exception;
//        exception;
//        throw exception;
    }

    public static String getVersionCode()
    {
        String s1 = "";
        PackageInfo packageinfo;
		try {
			packageinfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 16384);
	
			s1 = (new StringBuilder()).append(packageinfo.versionCode).toString();
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String s = s1;
//_L2:
        return s;
//        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
//        namenotfoundexception;
//        namenotfoundexception.printStackTrace();
//        s = "";
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    public static String getVersionName()
    {
        String s;
        try
        {
            s = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 16384).versionName;
        }
        catch(android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            s = "";
        }
        return s;
    }

    public void addActivity(Activity activity)
    {
        mList.add(activity);
    }

    public void exit()
    {
        Iterator iterator = mList.iterator();
        
        try{
        	
       
        while(iterator.hasNext()) {
        	Activity activity = (Activity)iterator.next();
            if(activity != null)
                activity.finish();
        }
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        System.exit(0);
//_L3:
//        boolean flag = iterator.hasNext();
//        if(flag) goto _L2; else goto _L1
//_L1:
//        System.exit(0);
//_L4:
//        return;
//_L2:
//        Activity activity = (Activity)iterator.next();
//        if(activity != null)
//            activity.finish();
//          goto _L3
//        Exception exception1;
//        exception1;
//        exception1.printStackTrace();
//        System.exit(0);
//          goto _L4
//        Exception exception;
//        exception;
//        System.exit(0);
//        throw exception;
//          goto _L3
    }

    public Context getContext()
    {
        return mContext;
    }

    public void initEnv()
    {
        if(Environment.getExternalStorageState().equals("mounted"))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/Android/data/").append(getPackageName()).append("/cache").toString());
            if(!file.exists())
            {
                if(file.mkdirs())
                    mSdcardDataDir = file.getAbsolutePath();
            } else
            {
                mSdcardDataDir = file.getAbsolutePath();
            }
        }
        mNetWorkState = NetworkUtils.getNetworkState(this);
    }

    public void onCreate()
    {
        super.onCreate();
        mContext = this;
        initEnv();
    }

    private static WorldcupApplication instance;
    private static Context mContext;
    public static int mNetWorkState = 0;
    public static String mSdcardDataDir;
    public static boolean showEditCate;
    private List mList;

}
