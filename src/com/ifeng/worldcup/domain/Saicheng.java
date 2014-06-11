// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.domain;


public class Saicheng
{

    public Saicheng()
    {
    }

    public String getBisaiType()
    {
        return bisaiType;
    }

    public String getBisaidi()
    {
        return bisaidi;
    }

    public int getCount()
    {
        return count;
    }

    public String getDate()
    {
        return date;
    }

    public String getId()
    {
        return id;
    }

    public String getTime()
    {
        return time;
    }

    public String getVs()
    {
        return vs;
    }

    public String getZubie()
    {
        return zubie;
    }

    public void setBisaiType(String s)
    {
        bisaiType = s;
    }

    public void setBisaidi(String s)
    {
        bisaidi = s;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setId(String s)
    {
        id = s;
    }

    public void setTime(String s)
    {
        time = s;
    }

    public void setVs(String s)
    {
        vs = s;
    }

    public void setZubie(String s)
    {
        zubie = s;
    }

    public String toString()
    {
        return (new StringBuilder("Saicheng [id=")).append(id).append(", date=").append(date).append(", bisaiType=").append(bisaiType).append(", time=").append(time).append(", vs=").append(vs).append(", zubie=").append(zubie).append(", bisaidi=").append(bisaidi).append("]").toString();
    }

    private String bisaiType;
    private String bisaidi;
    private int count;
    private String date;
    private String id;
    private String time;
    private String vs;
    private String zubie;
}
