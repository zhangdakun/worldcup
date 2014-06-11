// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.configure;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.net.*;
import java.util.Enumeration;

public class NetworkUtils
{

    public NetworkUtils()
    {
    }

    public static String getLocalIpAddress()
    {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e("WifiPreference IpAddress", ex.toString());
        }
        return null;
    }

    public static int getNetworkState(Context context)
    {
        int i;
        ConnectivityManager connectivitymanager;
        android.net.NetworkInfo.State state;
        i = 0;
        connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        state = connectivitymanager.getNetworkInfo(1).getState();
//        if(state != android.net.NetworkInfo.State.CONNECTED && state != android.net.NetworkInfo.State.CONNECTING) goto _L2; else goto _L1
//_L1:
//        i = 1;
//_L4:
//        return i;
//_L2:
//        android.net.NetworkInfo.State state1 = connectivitymanager.getNetworkInfo(0).getState();
//        if(state1 == android.net.NetworkInfo.State.CONNECTED || state1 == android.net.NetworkInfo.State.CONNECTING)
//            i = 2;
//        if(true) goto _L4; else goto _L3
//_L3:
        if(state != android.net.NetworkInfo.State.CONNECTED && state != android.net.NetworkInfo.State.CONNECTING) {
        	android.net.NetworkInfo.State state1 = connectivitymanager.getNetworkInfo(0).getState();
          if(state1 == android.net.NetworkInfo.State.CONNECTED || state1 == android.net.NetworkInfo.State.CONNECTING)
          i = 2;
        } else {
        	i = 1;
        }
        return i;
    }

    public static final int NETWORN_MOBILE = 2;
    public static final int NETWORN_NONE = 0;
    public static final int NETWORN_WIFI = 1;
}
