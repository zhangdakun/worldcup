// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.support.v4.app.*;
import java.util.List;

public class TabPagerAdapter extends FragmentStatePagerAdapter
{

    public TabPagerAdapter(FragmentManager fragmentmanager, List list1)
    {
        super(fragmentmanager);
        list = list1;
    }

    public int getCount()
    {
        return list.size();
    }

    public Fragment getItem(int i)
    {
        return (Fragment)list.get(i);
    }

    private List list;
}
