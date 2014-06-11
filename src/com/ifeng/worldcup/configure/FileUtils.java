// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.configure;

import android.content.Context;
import android.os.Environment;
import java.io.*;

public class FileUtils
{

    public FileUtils()
    {
    }

    public static void RecursionDeleteFile(File file)
    {
//        if(!file.isFile()) goto _L2; else goto _L1
//_L1:
//        file.delete();
//_L4:
//        return;
//_L2:
//        File afile[];
//        int i;
//        int j;
//        if(!file.isDirectory())
//            continue; /* Loop/switch isn't completed */
//        afile = file.listFiles();
//        if(afile == null || afile.length == 0)
//        {
//            file.delete();
//            continue; /* Loop/switch isn't completed */
//        }
//        i = afile.length;
//        j = 0;
//_L5:
//label0:
//        {
//            if(j < i)
//                break label0;
//            file.delete();
//        }
//        if(true) goto _L4; else goto _L3
//_L3:
//        RecursionDeleteFile(afile[j]);
//        j++;
//          goto _L5
//        if(true) goto _L4; else goto _L6
//_L6:
    	if(file.isFile()) {
    		file.delete();
    	} else if(file.isDirectory()){
    		File afile[] = file.listFiles();
    		if(null == afile || afile.length == 0) {
    			file.delete();
    		} else {
    			for(int j =0; j<afile.length;j++) {
    				RecursionDeleteFile(afile[j]);
    			}
    			file.delete();
    		}

    	}
    }

    public static void copyFile(File file, File file1)
        throws IOException
    {
        BufferedInputStream bufferedinputstream;
        BufferedOutputStream bufferedoutputstream;
        bufferedinputstream = null;
        bufferedoutputstream = null;
        BufferedInputStream bufferedinputstream1 = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bufferedoutputstream1 = new BufferedOutputStream(new FileOutputStream(file1));
        byte abyte0[] = new byte[8192];
//_L1:
//        int i;
//        i = bufferedinputstream1.read(abyte0);
//        if(i != -1)
//            break MISSING_BLOCK_LABEL_87;
//        bufferedoutputstream1.flush();
//        if(bufferedinputstream1 != null)
//            bufferedinputstream1.close();
//        if(bufferedoutputstream1 != null)
//            bufferedoutputstream1.close();
//        return;
//        bufferedoutputstream1.write(abyte0, 0, i);
//          goto _L1
//        Exception exception;
//        exception;
//        bufferedoutputstream = bufferedoutputstream1;
//        bufferedinputstream = bufferedinputstream1;
//_L3:
//        if(bufferedinputstream != null)
//            bufferedinputstream.close();
//        if(bufferedoutputstream != null)
//            bufferedoutputstream.close();
//        throw exception;
//        exception;
//        continue; /* Loop/switch isn't completed */
//        exception;
//        bufferedinputstream = bufferedinputstream1;
//        if(true) goto _L3; else goto _L2
//_L2:
        int i = 0;
        while((i = bufferedinputstream1.read(abyte0)) > 0) {
        	bufferedoutputstream1.write(abyte0, 0, i);
        }
        bufferedoutputstream1.flush();
      if(bufferedinputstream1 != null)
      bufferedinputstream1.close();
  if(bufferedoutputstream1 != null)
      bufferedoutputstream1.close();
        
    }

    public static String getCacheDecodeString(String s)
    {
        String s1;
        if(s != null)
            s1 = s.replaceAll("[.:/,%?&=]", "+").replaceAll("[+]+", "+");
        else
            s1 = null;
        return s1;
    }

    public static File getExternalCacheDir(Context context, String s)
    {
        File file = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File file1 = new File(new File(file, context.getPackageName()), "cache");
        if(!file1.exists())
        {
            try
            {
                (new File(file, getCacheDecodeString(s))).createNewFile();
            }
            catch(IOException ioexception) { }
            if(!file1.mkdirs())
                file1 = null;
        }
        return file1;
    }

    public static String readTextFile(File file)
        throws IOException
    {
        FileInputStream fileinputstream = null;
        FileInputStream fileinputstream1 = new FileInputStream(file);
        String s = readTextInputStream(fileinputstream1);
        if(fileinputstream1 != null)
            fileinputstream1.close();
        return s;
//        Exception exception;
//        exception;
//_L2:
//        if(fileinputstream != null)
//            fileinputstream.close();
//        throw exception;
//        exception;
//        fileinputstream = fileinputstream1;
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    public static String readTextInputStream(InputStream inputstream)
        throws IOException
    {
        StringBuffer stringbuffer;
        BufferedReader bufferedreader;
        stringbuffer = new StringBuffer();
        bufferedreader = null;
        BufferedReader bufferedreader1 = new BufferedReader(new InputStreamReader(inputstream));
//_L1:
//        String ;
//        if(s == null)
//        {
//            if(bufferedreader1 != null)
//                bufferedreader1.close();
//            return stringbuffer.toString();
//        }
//        stringbuffer.append(s).append("\r\n");
//          goto _L1
//        Exception exception;
//        exception;
//        bufferedreader = bufferedreader1;
//_L3:
//        if(bufferedreader != null)
//            bufferedreader.close();
//        throw exception;
//        exception;
//        if(true) goto _L3; else goto _L2
//_L2:
        String s;
        
        while((s = bufferedreader1.readLine()) != null) {
        	stringbuffer.append(s).append("\r\n");
        }
        

          if(bufferedreader1 != null)
              bufferedreader1.close();
          return stringbuffer.toString();

    }

    public static void writeTextFile(File file, String s)
        throws IOException
    {
        DataOutputStream dataoutputstream = null;
        DataOutputStream dataoutputstream1 = new DataOutputStream(new FileOutputStream(file));
        dataoutputstream1.write(s.getBytes());
        if(dataoutputstream1 != null)
            dataoutputstream1.close();
        return;
//        Exception exception;
//        exception;
//_L2:
//        if(dataoutputstream != null)
//            dataoutputstream.close();
//        throw exception;
//        exception;
//        dataoutputstream = dataoutputstream1;
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    private static final int BUFFER = 8192;
}
