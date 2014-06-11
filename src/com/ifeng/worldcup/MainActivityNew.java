// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.ifeng.worldcup.adapter.BasePageAdapter;
import com.ifeng.worldcup.widget.indicator.PageIndicator;
//import com.umeng.analytics.MobclickAgent;
//import com.umeng.update.UmengUpdateAgent;
import java.util.*;

// Referenced classes of package com.ifeng.worldcup:
//            IndexFragment, FixturesFragment, NewsFragment, VideoFragment

public class MainActivityNew extends FragmentActivity
    implements android.view.View.OnClickListener
{

    public MainActivityNew()
    {
    }

    private void share()
    {
//        String s = MobclickAgent.getConfigParams(this, "share");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "\u5206\u4EAB");
//        intent.putExtra("android.intent.extra.TEXT", s);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    public void onClick(View view)
    {
//        view.getId();
//        JVM INSTR tableswitch 2131034123 2131034123: default 24
//    //                   2131034123 25;
//           goto _L1 _L2
//_L1:
//        return;
//_L2:
//        share();
//        if(true) goto _L1; else goto _L3
//_L3:
    	switch (view.getId()) {
		case 2131034123:
			share();
			break;

		default:
			break;
		}
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        mViewPager = (ViewPager)findViewById(0x7f05000d);
        mIndicator = (PageIndicator)findViewById(0x7f05000c);
        mShareImageView = (ImageView)findViewById(0x7f05000b);
        mShareImageView.setOnClickListener(this);
//        UmengUpdateAgent.update(this);
//        MobclickAgent.updateOnlineConfig(this);
        mBasePageAdapter = new BasePageAdapter(this);
        mViewPager.setOffscreenPageLimit(0);
        mViewPager.setAdapter(mBasePageAdapter);
        mIndicator.setViewPager(mViewPager);
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        ArrayList arraylist1 = new ArrayList();
        arraylist.add("\u4E3B\u9875");
        arraylist.add("\u5168\u90E8\u8D5B\u7A0B");
        arraylist.add("\u65B0\u95FB");
        arraylist.add("\u89C6\u9891");
        arraylist1.add(new IndexFragment());
        arraylist1.add(new FixturesFragment());
        arraylist1.add(new NewsFragment());
        arraylist1.add(new VideoFragment());
        hashmap.put("tabs", arraylist);
        hashmap.put("list", arraylist1);
        mBasePageAdapter.addFragment((List)hashmap.get("tabs"), (List)hashmap.get("list"));
        mBasePageAdapter.notifyDataSetChanged();
        mIndicator.notifyDataSetChanged();
    }

    public void onPause()
    {
        super.onPause();
//        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    private BasePageAdapter mBasePageAdapter;
    private PageIndicator mIndicator;
    private ImageView mShareImageView;
    public ViewPager mViewPager;
}
