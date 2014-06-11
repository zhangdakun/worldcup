// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ifeng.worldcup.domain.Video;
import java.util.ArrayList;

public class VideoAdapter extends BaseAdapter
{
    class Holder
    {

//        final VideoAdapter this$0;
        public TextView titleTextView;
        public TextView videoTextView;

        Holder()
        {
//            this$0 = VideoAdapter.this;
            super();
        }
    }


    public VideoAdapter(Context context)
    {
        mCtx = context;
    }

    public int getCount()
    {
        return mVideos.size();
    }

    public Object getItem(int i)
    {
        return mVideos.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Holder holder;
        Video video;
        String s;
        if(view == null)
        {
            view = LayoutInflater.from(mCtx).inflate(0x7f03000b, null);
            holder = new Holder();
            holder.videoTextView = (TextView)view.findViewById(0x7f050039);
            holder.titleTextView = (TextView)view.findViewById(0x7f050029);
            view.setTag(holder);
        } else
        {
            holder = (Holder)view.getTag();
        }
        video = (Video)mVideos.get(i);
        s = video.getTitle();
        holder.videoTextView.setText(s);
        if(TextUtils.isEmpty(video.getUrl()))
        {
            holder.videoTextView.setVisibility(8);
            holder.titleTextView.setVisibility(0);
            holder.titleTextView.setText(s);
        } else
        {
            holder.videoTextView.setVisibility(0);
            holder.titleTextView.setVisibility(8);
            holder.videoTextView.setText(s);
        }
        return view;
    }

    public void setData(ArrayList arraylist)
    {
        mVideos = arraylist;
    }

    private Context mCtx;
    private ArrayList mVideos;
}
