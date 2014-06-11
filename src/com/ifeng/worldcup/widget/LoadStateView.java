// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class LoadStateView extends RelativeLayout
{

    public LoadStateView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        progBar = (ProgressBar)findViewById(0x7f050027);
    }

    public void setOnReloadClickListener(android.view.View.OnClickListener onclicklistener)
    {
    }

    public void showEmpty()
    {
        progBar.setVisibility(8);
    }

    public void showError()
    {
        progBar.setVisibility(8);
    }

    public void startLoad()
    {
        progBar.setVisibility(0);
        setVisibility(0);
    }

    public void stopLoad()
    {
        progBar.setVisibility(8);
        setVisibility(8);
    }

    ProgressBar progBar;
}
