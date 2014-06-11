// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ifeng.worldcup.domain.News;
import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter
{
    class Holder
    {

        public TextView newsTextView;
//        final NewsAdapter this$0;
        public TextView titleTextView;

        Holder()
        {
//            this$0 = NewsAdapter.this;
            super();
        }
    }


    public NewsAdapter(Context context)
    {
        mCtx = context;
    }

    public int getCount()
    {
        return mNews.size();
    }

    public Object getItem(int i)
    {
        return mNews.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Holder holder;
        News news;
        String s;
        if(view == null)
        {
            view = LayoutInflater.from(mCtx).inflate(0x7f030008, null);
            holder = new Holder();
            holder.newsTextView = (TextView)view.findViewById(0x7f050028);
            holder.titleTextView = (TextView)view.findViewById(0x7f050029);
            view.setTag(holder);
        } else
        {
            holder = (Holder)view.getTag();
        }
        news = (News)mNews.get(i);
        s = news.getTitle();
        if(TextUtils.isEmpty(news.getUrl()))
        {
            holder.newsTextView.setVisibility(8);
            holder.titleTextView.setVisibility(0);
            holder.titleTextView.setText(s);
        } else
        {
            holder.newsTextView.setVisibility(0);
            holder.titleTextView.setVisibility(8);
            holder.newsTextView.setText(s);
        }
        return view;
    }

    public void setData(ArrayList arraylist)
    {
        mNews = arraylist;
    }

    private Context mCtx;
    private ArrayList mNews;
}
