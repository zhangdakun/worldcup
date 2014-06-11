// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.configure;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.loopj.android.http.RequestParams;
import java.io.*;
import java.net.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import junit.framework.Assert;

public class Utils
{

    public Utils()
    {
    }

    private static String TruncateUrlPage(String s)
    {
        String s1 = null;
        String s2 = s.trim().toLowerCase();
        String as[] = s2.split("[?]");
        if(s2.length() > 1 && as.length > 1 && as[1] != null)
            s1 = as[1];
        return s1;
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean flag)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        if(flag)
            bitmap.recycle();
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        try
        {
            bytearrayoutputstream.close();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return abyte0;
    }

    public static Bitmap extractThumbNail(String s, int i, int j, boolean flag)
    {
        Bitmap bitmap;
        double d = 0;
        double d1 = 0;
        double d2 = 0;
        boolean flag1;
        android.graphics.BitmapFactory.Options options;
        Bitmap bitmap1;
        int k = 0;
        int l = 0;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if(s != null && !s.equals("") && i > 0 && j > 0)
            flag1 = true;
        else
            flag1 = false;
        Assert.assertTrue(flag1);
        options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        bitmap1 = BitmapFactory.decodeFile(s, options);
        if(bitmap1 != null)
            bitmap1.recycle();
        d = (1.0D * (double)options.outHeight) / (double)i;
        d1 = (1.0D * (double)options.outWidth) / (double)j;
        
        
//        if(!flag) goto _L2; else goto _L1
//_L1:
//        if(d <= d1) goto _L4; else goto _L3
//_L3:
//        d2 = d1;
//_L12:
//        options.inSampleSize = (int)d2;
//        if(options.inSampleSize <= 1)
//            options.inSampleSize = 1;
//_L9:
//        if((options.outHeight * options.outWidth) / options.inSampleSize > 0x2a3000) goto _L6; else goto _L5
//_L5:
//        k = i;
//        l = j;
//        if(flag)
//        {
//            if(d > d1)
//                k = (int)((1.0D * (double)l * (double)options.outHeight) / (double)options.outWidth);
//            else
//                l = (int)((1.0D * (double)k * (double)options.outWidth) / (double)options.outHeight);
//        } else
//        if(d < d1)
//            k = (int)((1.0D * (double)l * (double)options.outHeight) / (double)options.outWidth);
//        else
//            l = (int)((1.0D * (double)k * (double)options.outWidth) / (double)options.outHeight);
//        options.inJustDecodeBounds = false;
//        bitmap = BitmapFactory.decodeFile(s, options);
//        if(bitmap != null)
//            break; /* Loop/switch isn't completed */
//        bitmap = null;
//          goto _L7
//_L6:
//        options.inSampleSize = 1 + options.inSampleSize;
//        if(true) goto _L9; else goto _L8
//_L8:
//        bitmap2 = Bitmap.createScaledBitmap(bitmap, l, k, true);
//        if(bitmap2 != null)
//        {
//            bitmap.recycle();
//            bitmap = bitmap2;
//        }
//        if(!flag) goto _L7; else goto _L10
//_L10:
//        bitmap3 = Bitmap.createBitmap(bitmap, bitmap.getWidth() - j >> 1, bitmap.getHeight() - i >> 1, j, i);
//        if(bitmap3 == null) goto _L7; else goto _L11
//_L11:
//        bitmap.recycle();
//        bitmap = bitmap3;
//_L7:
//        return bitmap;
//_L4:
//        d2 = d;
//          goto _L12
//_L2:
//        if(d < d1)
//            d2 = d1;
//        else
//            d2 = d;
//          goto _L12
//        OutOfMemoryError outofmemoryerror;
//        outofmemoryerror;
//        bitmap = null;
//          goto _L7
        
        
        if(!flag) {// goto _L2; else goto _L1
          if(d < d1)
        	  d2 = d1;
          else
        	  d2 = d;
//        goto _L12
        } else {
        	 if(d <= d1){// goto _L4; else goto _L3
        		 d2 = d;//goto _L12
        		 

               
               
               //.....
        	 } else {
        		 d2 = d1;
        	 }
        }
        
        options.inSampleSize = (int)d2;
        if(options.inSampleSize <= 1)
            options.inSampleSize = 1;
        
        while((options.outHeight * options.outWidth) / options.inSampleSize > 0x2a3000){// goto _L6; else goto _L5
        	options.inSampleSize = 1 + options.inSampleSize;
        }
        
      k = i;
      l = j;
      if(flag)
      {
          if(d > d1)
              k = (int)((1.0D * (double)l * (double)options.outHeight) / (double)options.outWidth);
          else
              l = (int)((1.0D * (double)k * (double)options.outWidth) / (double)options.outHeight);
      } else
      if(d < d1)
          k = (int)((1.0D * (double)l * (double)options.outHeight) / (double)options.outWidth);
      else
          l = (int)((1.0D * (double)k * (double)options.outWidth) / (double)options.outHeight);
      options.inJustDecodeBounds = false;
      bitmap = BitmapFactory.decodeFile(s, options);
//      if(bitmap != null)
//          break; /* Loop/switch isn't completed */
//      bitmap = null;
        
        return bitmap;
    }

    public static String getDiscount(double d, double d1)
    {
//        if(d1 != 0.0D && d != 0.0D) goto _L2; else goto _L1
//_L1:
//        String s = "";
//_L4:
//        return s;
//_L2:
//        double d2 = 10D * (d1 / d);
//        String s1 = (new DecimalFormat("#0.0")).format(d2);
//        s = s1;
//        continue; /* Loop/switch isn't completed */
//        Exception exception;
//        exception;
//        s = "";
//        if(true) goto _L4; else goto _L3
//_L3:
    	
    	String s = "";
    	if(d1 != 0.0D && d != 0.0D) {
          double d2 = 10D * (d1 / d);
          s = (new DecimalFormat("#0.0")).format(d2);
    	}
    	
    	 return s;
    }

    public static String getDiscount(String s, String s1)
    {
//        if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
//_L1:
//        String s2 = "";
//_L4:
//        return s2;
//_L2:
//        double d;
//        double d1;
//        d = Double.parseDouble(s);
//        d1 = Double.parseDouble(s1);
//        double d2;
//        if(d == 0.0D)
//        {
//            s2 = "";
//            continue; /* Loop/switch isn't completed */
//        }
//        d2 = 10D * (d1 / d);
//        String s3 = (new DecimalFormat("#0.0")).format(d2);
//        s2 = s3;
//        continue; /* Loop/switch isn't completed */
//        Exception exception;
//        exception;
//        s2 = "";
//        if(true) goto _L4; else goto _L3
//_L3:
    	String s2 = "";
    	 if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s)) {
           double d;
           double d1;
           d = Double.parseDouble(s);
           d1 = Double.parseDouble(s1);
           double d2;
           if(d == 0.0D)
           {
               s2 = "";
               
           } else  {
           d2 = 10D * (d1 / d);
           s2 = (new DecimalFormat("#0.0")).format(d2);
           }

    	 }
    	 
    	 
    	 return s2;
    }

    public static int getDrawable(String s)
    {
        int i;
        if("\u963F\u5C14\u53CA\u5229\u4E9A".equals(s))
            i = 0x7f02000f;
        else
        if("\u963F\u6839\u5EF7".equals(s))
            i = 0x7f020010;
        else
        if("\u6FB3\u5927\u5229\u4E9A".equals(s))
            i = 0x7f020011;
        else
        if("\u5DF4\u897F".equals(s))
            i = 0x7f020013;
        else
        if("\u6BD4\u5229\u65F6".equals(s))
            i = 0x7f020015;
        else
        if("\u5FB7\u56FD".equals(s))
            i = 0x7f02001b;
        else
        if("\u4FC4\u7F57\u65AF".equals(s))
            i = 0x7f02001f;
        else
        if("\u5384\u74DC\u591A\u5C14".equals(s))
            i = 0x7f02001e;
        else
        if("\u6CD5\u56FD".equals(s))
            i = 0x7f020021;
        else
        if("\u54E5\u4F26\u6BD4\u4E9A".equals(s))
            i = 0x7f020023;
        else
        if("\u54E5\u65AF\u8FBE\u9ECE\u52A0".equals(s))
            i = 0x7f020024;
        else
        if("\u97E9\u56FD".equals(s))
            i = 0x7f020025;
        else
        if("\u8377\u5170".equals(s))
            i = 0x7f020026;
        else
        if("\u6D2A\u90FD\u62C9\u65AF".equals(s))
            i = 0x7f020028;
        else
        if("\u52A0\u7EB3".equals(s))
            i = 0x7f02002a;
        else
        if("\u5580\u9EA6\u9686".equals(s))
            i = 0x7f02002c;
        else
        if("\u79D1\u7279\u8FEA\u74E6".equals(s))
            i = 0x7f02002d;
        else
        if("\u514B\u7F57\u5730\u4E9A".equals(s))
            i = 0x7f02002b;
        else
        if("\u7F8E\u56FD".equals(s))
            i = 0x7f02002f;
        else
        if("\u58A8\u897F\u54E5".equals(s))
            i = 0x7f020030;
        else
        if("\u5C3C\u65E5\u5229\u4E9A".equals(s))
            i = 0x7f020031;
        else
        if("\u8461\u8404\u7259".equals(s))
            i = 0x7f020035;
        else
        if("\u65E5\u672C".equals(s))
            i = 0x7f020036;
        else
        if("\u745E\u58EB".equals(s))
            i = 0x7f020037;
        else
        if("\u4E4C\u62C9\u572D".equals(s))
            i = 0x7f020055;
        else
        if("\u897F\u73ED\u7259".equals(s))
            i = 0x7f020056;
        else
        if("\u5E0C\u814A".equals(s))
            i = 0x7f020057;
        else
        if("\u4F0A\u6717".equals(s))
            i = 0x7f020059;
        else
        if("\u610F\u5927\u5229".equals(s))
            i = 0x7f020058;
        else
        if("\u82F1\u683C\u5170".equals(s))
            i = 0x7f020020;
        else
        if("\u667A\u5229".equals(s))
            i = 0x7f02005a;
        else
        if("\u6CE2\u9ED1".equals(s))
            i = 0x7f020016;
        else
            i = 0x7f020029;
        return i;
    }

    public static String getHaoping(String s, String s1, String s2)
    {
//        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2)) goto _L2; else goto _L1
//_L1:
//        String s3 = "";
//_L4:
//        return s3;
//_L2:
//        int i;
//        int j;
//        int k;
//        i = Integer.parseInt(s);
//        j = Integer.parseInt(s1);
//        k = Integer.parseInt(s2);
//        double d;
//        int l = k + (i + j);
//        if(l == 0)
//        {
//            s3 = "";
//            continue; /* Loop/switch isn't completed */
//        }
//        d = (double)i / (1.0D * (double)l);
//        String s4;
//        DecimalFormat decimalformat = new DecimalFormat("#0.0");
//        s4 = (new StringBuilder("\u597D\u8BC4\u7387\uFF1A")).append(decimalformat.format(100D * d)).append("%").toString();
//        s3 = s4;
//        continue; /* Loop/switch isn't completed */
//        Exception exception;
//        exception;
//        s3 = "";
//        if(true) goto _L4; else goto _L3
//_L3:
    	String s3 = "";
    	if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2)) {
          int i;
          int j;
          int k;
          i = Integer.parseInt(s);
          j = Integer.parseInt(s1);
          k = Integer.parseInt(s2);
          double d;
          int l = k + (i + j);
          if(l == 0)
          {
              s3 = "";
 
          } else {
          d = (double)i / (1.0D * (double)l);
//          String s4;
          DecimalFormat decimalformat = new DecimalFormat("#0.0");
          s3 = (new StringBuilder("\u597D\u8BC4\u7387\uFF1A")).append(decimalformat.format(100D * d)).append("%").toString();
//          s3 = s4;
          }
    	}
    	
    	return s3;
    }

    public static byte[] getHtmlByteArray(String s)
    {
        InputStream inputstream = null;
        URL url;
		try {
			url = new URL(s);

        InputStream inputstream1;
        HttpURLConnection httpurlconnection;
		
			httpurlconnection = (HttpURLConnection)url.openConnection();
	        if(httpurlconnection.getResponseCode() != 200) {
//	            break MISSING_BLOCK_LABEL_41;
	        	return null;
	        }


		inputstream = httpurlconnection.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//_L1:
        return inputStreamToByte(inputstream);
//        MalformedURLException malformedurlexception;
//        malformedurlexception;
//_L3:
//        malformedurlexception.printStackTrace();
//          goto _L1
//        IOException ioexception;
//        ioexception;
//_L2:
//        ioexception.printStackTrace();
//          goto _L1
//        ioexception;
//          goto _L2
//        malformedurlexception;
//          goto _L3
    }

    public static int getResouces(int i)
    {
        int j = 0x7f020000;
//        i;
//        JVM INSTR tableswitch 0 9: default 60
//    //                   0 60
//    //                   1 62
//    //                   2 69
//    //                   3 76
//    //                   4 83
//    //                   5 90
//    //                   6 97
//    //                   7 104
//    //                   8 111
//    //                   9 118;
//           goto _L1 _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
//_L1:
//        return j;
//_L2:
//        j = 0x7f020001;
//        continue; /* Loop/switch isn't completed */
//_L3:
//        j = 0x7f020002;
//        continue; /* Loop/switch isn't completed */
//_L4:
//        j = 0x7f020003;
//        continue; /* Loop/switch isn't completed */
//_L5:
//        j = 0x7f020004;
//        continue; /* Loop/switch isn't completed */
//_L6:
//        j = 0x7f020005;
//        continue; /* Loop/switch isn't completed */
//_L7:
//        j = 0x7f020006;
//        continue; /* Loop/switch isn't completed */
//_L8:
//        j = 0x7f020007;
//        continue; /* Loop/switch isn't completed */
//_L9:
//        j = 0x7f020008;
//        continue; /* Loop/switch isn't completed */
//_L10:
//        j = 0x7f020009;
//        if(true) goto _L1; else goto _L11
//_L11:
        switch (i) {
		case 0:
			
			break;
		case 1:
			j = 0x7f020001;
			break;
		case 2:
			 j = 0x7f020002;
			break;
		case 3:
			 j = 0x7f020003;
			break;
		case 4:
			 j = 0x7f020004;
			break;
		case 5:
			 j = 0x7f020005;
			break;
		case 6:
			 j = 0x7f020006;
			break;
		case 7:
			 j = 0x7f020007;
			break;
		case 8:
			 j = 0x7f020008;
			break;
		case 9:
			 j = 0x7f020009;
			break;
			

		default:
			break;
		}
        
        return j;
    }

    public static String getShowTime(String s)
    {
        String s1;
        if(TextUtils.isEmpty(s))
            s1 = "";
        else
        if(s.length() < 10)
            s1 = "";
        else
        if(!s.substring(0, 10).equals(getTime().substring(0, 10)))
            s1 = s.substring(0, 10);
        else
            s1 = s.substring(11, 16);
        return s1;
    }

    public static String getTime()
    {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date());
    }

    public static Map getUrlParams(String s)
    {
        HashMap hashmap = new HashMap();
        String s1 = TruncateUrlPage(s);
        if(s1 != null)
        {
            String as[] = s1.split("[&]");
            int i = as.length;
            int j = 0;
            while(j < i) 
            {
                String as1[] = as[j].split("[=]");
                if(as1.length > 1)
                    hashmap.put(as1[0], as1[1]);
                else
                if(as1[0] != "")
                    hashmap.put(as1[0], "");
                j++;
            }
        }
        return hashmap;
    }

    public static String getUrlWithParams(String s, RequestParams requestparams)
    {
        if(requestparams != null)
        {
            String s1 = requestparams.toString();
            if(s.indexOf("?") == -1)
                s = (new StringBuilder(String.valueOf(s))).append("?").append(s1).toString();
            else
                s = (new StringBuilder(String.valueOf(s))).append("&").append(s1).toString();
        }
        
        Log.d("utils", "getUrlWithParams, "+s);
        return s;
    }

    public static byte[] inputStreamToByte(InputStream inputstream)
    {
        byte abyte0[];
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            do
            {
                int i = inputstream.read();
                if(i == -1)
                {
                    abyte0 = bytearrayoutputstream.toByteArray();
                    bytearrayoutputstream.close();
                    break;
                }
                bytearrayoutputstream.write(i);
            } while(true);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            abyte0 = null;
        }
        return abyte0;
    }

    public static byte[] readFromFile(String s, int i, int j)
    {
        byte abyte0[] = null;
        if(s == null) {//goto _L2; else goto _L1
//_L1:
        return abyte0;
//_L2:
        }
        File file = new File(s);
        if(file.exists())
        {
            if(j == -1)
                j = (int)file.length();
            if(i >= 0 && j > 0 && i + j <= (int)file.length())
            {
                abyte0 = null;
                try
                {
                    RandomAccessFile randomaccessfile = new RandomAccessFile(s, "r");
                    abyte0 = new byte[j];
                    randomaccessfile.seek(i);
                    randomaccessfile.readFully(abyte0);
                    randomaccessfile.close();
                }
                catch(Exception exception)
                {
                    exception.printStackTrace();
                }
            }
        }
//        if(true) goto _L1; else goto _L3
//_L3:
        
        return abyte0;
    }

    public static void showMessage(Context context, String s)
    {
        Toast.makeText(context, s, 0).show();
    }

    public static int KEYWORDS_COLOR[];
    private static final int MAX_DECODE_PICTURE_SIZE = 0x2a3000;

    static 
    {
        int ai[] = new int[6];
        ai[0] = 0xff21a4f6;
        ai[1] = 0xff00b37b;
        ai[2] = 0xffb27302;
        ai[3] = 0xffb3008f;
        ai[4] = 0xfffaa588;
        ai[5] = 0xffa670fc;
        KEYWORDS_COLOR = ai;
    }
}
