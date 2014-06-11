// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.configure;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.ifeng.worldcup.configure:
//            FileNameGenerator

public class Md5FileNameGenerator
    implements FileNameGenerator
{

    public Md5FileNameGenerator()
    {
    }

    private byte[] getMD5(byte abyte0[])
    {
        byte abyte1[] = null;
        byte abyte2[];
        MessageDigest messagedigest;
		try {
			messagedigest = MessageDigest.getInstance("MD5");

        messagedigest.update(abyte0);
        abyte1 = messagedigest.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        abyte1 = abyte2;
//_L2:
        return abyte1;
//        NoSuchAlgorithmException nosuchalgorithmexception;
//        nosuchalgorithmexception;
//        if(true) goto _L2; else goto _L1
//_L1:
    }

    public String generate(String s)
    {
        return (new BigInteger(getMD5(s.getBytes()))).abs().toString(36);
    }

    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;
}
