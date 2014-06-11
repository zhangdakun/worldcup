// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.*;
import android.widget.*;
import com.ifeng.worldcup.configure.Utils;
import com.ifeng.worldcup.domain.Month_day;
import com.ifeng.worldcup.domain.Saicheng;
import java.util.ArrayList;
import java.util.List;

public class MyExpandableListViewAdapter extends BaseExpandableListAdapter
{
    class ChildViewHolder
    {

        ImageView ig_one;
        ImageView ig_two;
//        final MyExpandableListViewAdapter this$0;
        TextView tv_address;
        TextView tv_chang;
        TextView tv_one;
        TextView tv_time;
        TextView tv_two;
        TextView tv_zu;

        ChildViewHolder()
        {
//            this$0 = MyExpandableListViewAdapter.this;
            super();
        }
    }

    class GroupViewHolder
    {

        LinearLayout groupLayout;
//        final MyExpandableListViewAdapter this$0;
        TextView tv_day;
        TextView tv_month;
        TextView typeTextView;

        GroupViewHolder()
        {
//            this$0 = MyExpandableListViewAdapter.this;
            super();
        }
    }


    public MyExpandableListViewAdapter(Context context)
    {
        mInflater = LayoutInflater.from(context);
    }

    public Object getChild(int i, int j)
    {
        return ((List)mChildArray.get(i)).get(j);
    }

    public long getChildId(int i, int j)
    {
        return (long)j;
    }

    public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
    {
        ChildViewHolder childviewholder;
        Saicheng saicheng;
        String s;
        int k;
        String s1;
        String s2;
        if(view == null)
        {
            childviewholder = new ChildViewHolder();
            view = mInflater.inflate(0x7f030001, null);
            childviewholder.tv_chang = (TextView)view.findViewById(0x7f05000e);
            childviewholder.tv_zu = (TextView)view.findViewById(0x7f05000f);
            childviewholder.tv_one = (TextView)view.findViewById(0x7f050010);
            childviewholder.ig_one = (ImageView)view.findViewById(0x7f050011);
            childviewholder.tv_address = (TextView)view.findViewById(0x7f050012);
            childviewholder.tv_time = (TextView)view.findViewById(0x7f050013);
            childviewholder.tv_two = (TextView)view.findViewById(0x7f050014);
            childviewholder.ig_two = (ImageView)view.findViewById(0x7f050015);
            view.setTag(childviewholder);
        } else
        {
            childviewholder = (ChildViewHolder)view.getTag();
        }
        saicheng = (Saicheng)((List)mChildArray.get(i)).get(j);
        Log.d("saicheng", (new StringBuilder("groupPosition=")).append(i).append("childPosition=").append(j).toString());
        Log.d("saicheng", (new StringBuilder("saicheng vs =")).append(saicheng.getVs()).toString());
        childviewholder.tv_chang.setText((new StringBuilder()).append(saicheng.getCount()).toString());
        s = saicheng.getVs();
        k = s.indexOf("VS");
        s1 = s.substring(0, k - 1);
        s2 = s.substring(k + 3, s.length());
        childviewholder.tv_one.setText(s1);
        childviewholder.ig_one.setImageResource(Utils.getDrawable(s1));
        childviewholder.tv_two.setText(s2);
        childviewholder.ig_two.setImageResource(Utils.getDrawable(s2));
        childviewholder.tv_time.setText((new StringBuilder("AM ")).append(saicheng.getTime()).toString());
        childviewholder.tv_address.setText(saicheng.getBisaidi());
        childviewholder.tv_zu.setText((new StringBuilder(String.valueOf(saicheng.getZubie().substring(0, 1)))).append("\u7EC4").toString());
        return view;
    }

    public int getChildrenCount(int i)
    {
        return ((List)mChildArray.get(i)).size();
    }

    public Object getGroup(int i)
    {
        return mGroupArray.get(i);
    }

    public int getGroupCount()
    {
        return mGroupArray.size();
    }

    public long getGroupId(int i)
    {
        return (long)i;
    }

    public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        GroupViewHolder groupviewholder;
        Month_day month_day;
        String s;
        if(view == null)
        {
            groupviewholder = new GroupViewHolder();
            view = mInflater.inflate(0x7f030006, null);
            groupviewholder.tv_day = (TextView)view.findViewById(0x7f050024);
            groupviewholder.tv_month = (TextView)view.findViewById(0x7f050023);
            groupviewholder.groupLayout = (LinearLayout)view.findViewById(0x7f050022);
            groupviewholder.typeTextView = (TextView)view.findViewById(0x7f050025);
            view.setTag(groupviewholder);
        } else
        {
            groupviewholder = (GroupViewHolder)view.getTag();
        }
        month_day = (Month_day)mGroupArray.get(i);
        s = month_day.getTypeName();
        if(TextUtils.isEmpty(s))
        {
            groupviewholder.tv_day.setText(month_day.getDay());
            groupviewholder.tv_month.setText(month_day.getMonth());
            groupviewholder.groupLayout.setVisibility(0);
            groupviewholder.typeTextView.setVisibility(8);
            if(flag)
                groupviewholder.groupLayout.setBackgroundResource(0x7f02001d);
            else
                groupviewholder.groupLayout.setBackgroundResource(0x7f020053);
        } else
        {
            groupviewholder.groupLayout.setVisibility(8);
            groupviewholder.typeTextView.setVisibility(0);
            groupviewholder.typeTextView.setText(s);
        }
        return view;
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i, int j)
    {
        return true;
    }

    public void setData(ArrayList arraylist, ArrayList arraylist1)
    {
        mGroupArray = arraylist;
        mChildArray = arraylist1;
    }

    private ArrayList mChildArray;
    private ArrayList mGroupArray;
    private LayoutInflater mInflater;
}
