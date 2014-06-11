// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.domain;


public class Month_day
{

    public Month_day()
    {
    }

    public String getDay()
    {
        return day;
    }

    public String getMonth()
    {
        return month;
    }

    public String getTypeName()
    {
        return typeName;
    }

    public void setDay(String s)
    {
        day = s;
    }

    public void setMonth(String s)
    {
        month = s;
    }

    public void setTypeName(String s)
    {
        typeName = s;
    }

    private String day;
    private String month;
    private String typeName;
}
