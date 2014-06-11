// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.configure;

import com.ifeng.worldcup.WorldcupApplication;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.ifeng.worldcup.configure:
//            FileUtils, Md5FileNameGenerator

public class ConfigCache
{

    public ConfigCache()
    {
    }

    public static String getCache(String s)
    {
//        if(s != null) goto _L2; else goto _L1
//_L1:
//        String s1 = null;
//_L4:
//        return s1;
//_L2:
//        File file;
//        s1 = null;
//        file = new File((new StringBuilder(String.valueOf(WorldcupApplication.mSdcardDataDir))).append("/").append(getCacheDecodeString(s)).toString());
//        String s2 = FileUtils.readTextFile(file);
//        s1 = s2;
//        continue; /* Loop/switch isn't completed */
//        IOException ioexception;
//        ioexception;
//        ioexception.printStackTrace();
//        if(true) goto _L4; else goto _L3
//_L3:
    	String s1;
    	if( null == s) {
    		return null;
    	}
    	
      File file;
      s1 = null;
      file = new File((new StringBuilder(String.valueOf(WorldcupApplication.mSdcardDataDir))).append("/").append(getCacheDecodeString(s)).toString());
      try {
		s1 = FileUtils.readTextFile(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      
      return s1;
    	
    }

    public static String getCacheDecodeString(String s)
    {
        String s1;
        if(s != null)
        {
            String s2 = s.replaceAll("[.:/,%?&={}]", "+").replaceAll("[+]+", "+");
            s1 = (new Md5FileNameGenerator()).generate(s2);
        } else
        {
            s1 = null;
        }
        return s1;
    }
//
    public static String getUrlCache(String s)
    {
//        if(s != null) goto _L2; else goto _L1
//_L1:
//        String s1 = null;
//_L4:
//        return s1;
//_L2:
//        File file;
//        s1 = null;
//        file = new File((new StringBuilder(String.valueOf(WorldcupApplication.mSdcardDataDir))).append("/").append(getCacheDecodeString(s)).toString());
//        if(!file.exists() || !file.isFile())
//            continue; /* Loop/switch isn't completed */
//        long l = System.currentTimeMillis() - file.lastModified();
//        if(WorldcupApplication.mNetWorkState != 0 && l < 0L)
//        {
//            s1 = null;
//            continue; /* Loop/switch isn't completed */
//        }
//        if(WorldcupApplication.mNetWorkState == 1 && l > 0x927c0L)
//        {
//            s1 = null;
//            continue; /* Loop/switch isn't completed */
//        }
//        if(WorldcupApplication.mNetWorkState == 2 && l > 0x36ee80L)
//        {
//            s1 = null;
//            continue; /* Loop/switch isn't completed */
//        }
//        String s2 = FileUtils.readTextFile(file);
//        s1 = s2;
//        continue; /* Loop/switch isn't completed */
//        IOException ioexception;
//        ioexception;
//        ioexception.printStackTrace();
//        if(true) goto _L4; else goto _L3
//_L3:
    	if( null == s) {
    		return null;
    	}
    	
    	String s1 = null;
    	
      File file;
      s1 = null;
      file = new File((new StringBuilder(String.valueOf(WorldcupApplication.mSdcardDataDir))).append("/").append(getCacheDecodeString(s)).toString());
      if(!file.exists() || !file.isFile()) {
    	  
      }else 
      {
        long l = System.currentTimeMillis() - file.lastModified();
        if(WorldcupApplication.mNetWorkState != 0 && l < 0L)
        {
            s1 = null;
//            continue; /* Loop/switch isn't completed */
        }
        else if(WorldcupApplication.mNetWorkState == 1 && l > 0x927c0L)
        {
            s1 = null;
//            continue; /* Loop/switch isn't completed */
        }
        else if(WorldcupApplication.mNetWorkState == 2 && l > 0x36ee80L)
        {
            s1 = null;
//            continue; /* Loop/switch isn't completed */
        } else {
        try {
			s1 = FileUtils.readTextFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
//        s1 = s2;
      }
      
      
      return s1;
    	
    }

    public static void setUrlCache(String s, String s1)
    {
        File file = new File((new StringBuilder(String.valueOf(WorldcupApplication.mSdcardDataDir))).append("/").append(getCacheDecodeString(s1)).toString());
        try {
			FileUtils.writeTextFile(file, s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//_L1:
        return;
//        IOException ioexception;
//        ioexception;
//        ioexception.printStackTrace();
//          goto _L1
    }

    public static final int CONFIG_CACHE_MOBILE_TIMEOUT = 0x36ee80;
    public static final int CONFIG_CACHE_WIFI_TIMEOUT = 0x927c0;
}
