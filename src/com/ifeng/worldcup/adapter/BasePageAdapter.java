// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.adapter;

import android.support.v4.app.*;
import android.view.ViewGroup;
import com.ifeng.worldcup.*;
import java.util.ArrayList;
import java.util.List;

public class BasePageAdapter extends FragmentPagerAdapter
{

    public BasePageAdapter(FragmentActivity fragmentactivity)
    {
        super(fragmentactivity.getSupportFragmentManager());
        mFragments = new ArrayList();
        tabs = new ArrayList();
    }

    public void addFragment(List list, List list1)
    {
        int i;
        tabs.addAll(list);
        i = 0;
//_L2:
//        Object obj;
//        if(i >= list1.size())
//            return;
//        obj = list1.get(i);
//        if(!(obj instanceof IndexFragment))
//            break; /* Loop/switch isn't completed */
//        addTab((IndexFragment)obj);
//_L3:
//        i++;
//        if(true) goto _L2; else goto _L1
//_L1:
//        if(obj instanceof FixturesFragment)
//            addTab((FixturesFragment)obj);
//        else
//        if(obj instanceof VideoFragment)
//            addTab((VideoFragment)obj);
//        else
//        if(obj instanceof NewsFragment)
//            addTab((NewsFragment)obj);
//          goto _L3
//        if(true) goto _L2; else goto _L4
//_L4:
		Object obj;
		for (i = 0; i < list.size(); i++) {
			obj = list1.get(i);

			if (obj instanceof FixturesFragment)
				addTab((FixturesFragment) obj);
			else if (obj instanceof VideoFragment)
				addTab((VideoFragment) obj);
			else if (obj instanceof NewsFragment)
				addTab((NewsFragment) obj);
			else if (obj instanceof IndexFragment)
				addTab((IndexFragment) obj);
		}
        
    }

    public void addTab(Fragment fragment)
    {
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

    public void clear()
    {
        mFragments.clear();
        tabs.clear();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        super.destroyItem(viewgroup, i, obj);
    }

    public int getCount()
    {
        return mFragments.size();
    }

    public Fragment getItem(int i)
    {
        return (Fragment)mFragments.get(i);
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public CharSequence getPageTitle(int i)
    {
        return (CharSequence)tabs.get(i);
    }

    public ArrayList mFragments;
    public List tabs;
}
