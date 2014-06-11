// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup.widget.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;

class IcsLinearLayout extends LinearLayout
{

    public IcsLinearLayout(Context context, int i)
    {
        super(context);
        TypedArray typedarray = context.obtainStyledAttributes(null, LL, i, 0);
        setDividerDrawable(typedarray.getDrawable(0));
        mDividerPadding = typedarray.getDimensionPixelSize(2, 0);
        mShowDividers = typedarray.getInteger(1, 0);
        typedarray.recycle();
    }

    private void drawDividersHorizontal(Canvas canvas)
    {
        int i = getChildCount();
        int j = 0;
        
        View view;
        android.widget.LinearLayout.LayoutParams layoutparams;
        
        do
        {
            if(j >= i)
            {
                if(hasDividerBeforeChildAt(i))
                {
                    View view1 = getChildAt(i - 1);
                    
                    
                    int k;
                    if(view1 == null)
                        k = getWidth() - getPaddingRight() - mDividerWidth;
                    else
                        k = view1.getRight();
                    drawVerticalDivider(canvas, k);
                }
                return;
            }
            view = getChildAt(j);
            if(view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(j))
            {
                layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                drawVerticalDivider(canvas, view.getLeft() - layoutparams.leftMargin);
            }
            j++;
        } while(true);
    }

    private void drawDividersVertical(Canvas canvas)
    {
        int i = getChildCount();
        int j = 0;
        
        View view;
        android.widget.LinearLayout.LayoutParams layoutparams;
        do
        {
            if(j >= i)
            {
                if(hasDividerBeforeChildAt(i))
                {
                    View view1 = getChildAt(i - 1);
                    
                    
                    int k;
                    if(view1 == null)
                        k = getHeight() - getPaddingBottom() - mDividerHeight;
                    else
                        k = view1.getBottom();
                    drawHorizontalDivider(canvas, k);
                }
                return;
            }
            view = getChildAt(j);
            if(view != null && view.getVisibility() != 8 && hasDividerBeforeChildAt(j))
            {
                layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
                drawHorizontalDivider(canvas, view.getTop() - layoutparams.topMargin);
            }
            j++;
        } while(true);
    }

    private void drawHorizontalDivider(Canvas canvas, int i)
    {
        mDivider.setBounds(getPaddingLeft() + mDividerPadding, i, getWidth() - getPaddingRight() - mDividerPadding, i + mDividerHeight);
        mDivider.draw(canvas);
    }

    private void drawVerticalDivider(Canvas canvas, int i)
    {
        mDivider.setBounds(i, getPaddingTop() + mDividerPadding, i + mDividerWidth, getHeight() - getPaddingBottom() - mDividerPadding);
        mDivider.draw(canvas);
    }

    private boolean hasDividerBeforeChildAt(int i)
    {
        boolean flag;
        flag = false;
//        break MISSING_BLOCK_LABEL_2;
//_L2:
//        do
//            return flag;
//        while(i == 0 || i == getChildCount() || (2 & mShowDividers) == 0);
//        flag = false;
//        int j = i - 1;
//        do
//        {
//            if(j >= 0)
//            {
//label0:
//                {
//                    if(getChildAt(j).getVisibility() == 8)
//                        break label0;
//                    flag = true;
//                }
//            }
//            if(true)
//                continue;
//            j--;
//        } while(true);
//        if(true) goto _L2; else goto _L1
//_L1:
        
        
        return flag;
        
    }

    protected void measureChildWithMargins(View view, int i, int j, int k, int l)
    {
        int i1 = indexOfChild(view);
        int j1 = getOrientation();
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)view.getLayoutParams();
        int k1;
        if(hasDividerBeforeChildAt(i1))
            if(j1 == 1)
                layoutparams.topMargin = mDividerHeight;
            else
                layoutparams.leftMargin = mDividerWidth;
        k1 = getChildCount();
        if(i1 == k1 - 1 && hasDividerBeforeChildAt(k1))
            if(j1 == 1)
                layoutparams.bottomMargin = mDividerHeight;
            else
                layoutparams.rightMargin = mDividerWidth;
        super.measureChildWithMargins(view, i, j, k, l);
    }

    protected void onDraw(Canvas canvas)
    {
        if(mDivider != null)
            if(getOrientation() == 1)
                drawDividersVertical(canvas);
            else
                drawDividersHorizontal(canvas);
        super.onDraw(canvas);
    }

    public void setDividerDrawable(Drawable drawable)
    {
        boolean flag = false;
        if(drawable != mDivider)
        {
            mDivider = drawable;
            if(drawable != null)
            {
                mDividerWidth = drawable.getIntrinsicWidth();
                mDividerHeight = drawable.getIntrinsicHeight();
            } else
            {
                mDividerWidth = 0;
                mDividerHeight = 0;
            }
            if(drawable == null)
                flag = true;
            setWillNotDraw(flag);
            requestLayout();
        }
    }

    private static final int LL[];
    private static final int LL_DIVIDER = 0;
    private static final int LL_DIVIDER_PADDING = 2;
    private static final int LL_SHOW_DIVIDER = 1;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mShowDividers;

    static 
    {
        int ai[] = new int[3];
        ai[0] = 0x1010129;
        ai[1] = 0x1010329;
        ai[2] = 0x101032a;
        LL = ai;
    }
}
