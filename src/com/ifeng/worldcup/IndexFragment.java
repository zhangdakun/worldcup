// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.os.*;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifeng.worldcup.configure.Utils;
import com.ifeng.worldcup.datahandler.IDataHandler;
import com.ifeng.worldcup.datahandler.NextDataHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.JSONException;
import org.json.JSONObject;

public class IndexFragment extends Fragment
{

    public IndexFragment()
    {
        handler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
//                message.what;
//                JVM INSTR tableswitch 0 1: default 32
//            //                           0 33
//            //                           1 43;
//                   goto _L1 _L2 _L3
//_L1:
//                return;
//_L2:
//                show();
//                continue; /* Loop/switch isn't completed */
//_L3:
//                String s = (String)message.obj;
//                try
//                {
//                    JSONObject jsonobject = new JSONObject(s);
//                    String s1 = jsonobject.getString("team1");
//                    String s2 = jsonobject.getString("team2");
//                    String s3 = jsonobject.getString("time");
//                    mTimeTextView.setText(s3);
//                    mFirstCountryText.setText(s1);
//                    mSecondCountryText.setText(s2);
//                    mFirstCountryImage.setImageResource(Utils.getDrawable(s1));
//                    mSecondCountryImage.setImageResource(Utils.getDrawable(s2));
//                }
//                catch(JSONException jsonexception)
//                {
//                    jsonexception.printStackTrace();
//                }
//                catch(Exception exception) { }
//                if(true) goto _L1; else goto _L4
//_L4:
                switch (message.what) {
				case 0:
					show();
					break;
				case 1:
	                String s = (String)message.obj;
	                try
	                {
	                    JSONObject jsonobject = new JSONObject(s);
	                    String s1 = jsonobject.getString("team1");
	                    String s2 = jsonobject.getString("team2");
	                    String s3 = jsonobject.getString("time");
	                    mTimeTextView.setText(s3);
	                    mFirstCountryText.setText(s1);
	                    mSecondCountryText.setText(s2);
	                    mFirstCountryImage.setImageResource(Utils.getDrawable(s1));
	                    mSecondCountryImage.setImageResource(Utils.getDrawable(s2));
	                }
	                catch(JSONException jsonexception)
	                {
	                    jsonexception.printStackTrace();
	                }
	                catch(Exception exception) {
	                	
	                }					
					break;
				default:
					break;
				}
            }

//            final IndexFragment this$0;
//
//            
//            {
//                this$0 = IndexFragment.this;
//                super();
//            }
        }
;
    }

    private void countdown()
    {
        timer = new Timer();
        TimerTask timertask = new TimerTask() {

            public void run()
            {
                Message message = new Message();
                message.what = 0;
                handler.sendMessage(message);
            }

//            final IndexFragment this$0;
//
//            
//            {
//                this$0 = IndexFragment.this;
//                super();
//            }
        }
;
        timer.schedule(timertask, 10L, 1000L);
    }

    private void requestData()
    {
        NextDataHandler.getInstance().publishTask(new IDataHandler() {

            public void loadFail(Object obj)
            {
                Message message = Message.obtain();
                message.what = 2;
                handler.sendMessage(message);
            }

            public void loadSuccess(Object obj)
            {
                Message message = new Message();
                message.what = 1;
                message.obj = obj;
                handler.sendMessage(message);
            }

//            final IndexFragment this$0;
//
//            
//            {
//                this$0 = IndexFragment.this;
//                super();
//            }
        }
);
    }

    private void show()
    {
        long l4;
        String s1;
        String s3;
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
		try {
			date = simpledateformat.parse(simpledateformat.format(new Date()));

        long l = simpledateformat.parse("2014-06-13 04:00:00").getTime() - date.getTime();
        long l1 = l / 0x5265c00L;
        long l2 = l / 0x36ee80L - 24L * l1;
        long l3 = l / 60000L - 60L * (24L * l1) - 60L * l2;
        l4 = l / 1000L - 60L * (60L * (24L * l1)) - 60L * (60L * l2) - 60L * l3;
        String s;
        int i;
        int j;
        int k;
        if(l2 < 10L)
            s = (new StringBuilder(String.valueOf(""))).append("0").append(l2).toString();
        else
            s = (new StringBuilder(String.valueOf(""))).append(l2).toString();
        if(l3 < 10L)
            s1 = (new StringBuilder(String.valueOf(s))).append(":0").append(l3).toString();
        else
            s1 = (new StringBuilder(String.valueOf(s))).append(":").append(l3).toString();
//        if(l4 >= 10L) goto _L2; else goto _L1
//_L1:
//        s3 = (new StringBuilder(String.valueOf(s1))).append(":0").append(l4).toString();
//_L3:
//        mTextView3.setText(s3);
//        i = (int)l1;
//        j = i / 10;
//        k = i % 10;
//        mImageOne.setImageResource(Utils.getResouces(j));
//        mImageTwo.setImageResource(Utils.getResouces(k));
//        break MISSING_BLOCK_LABEL_385;
//_L2:
//        String s2 = (new StringBuilder(String.valueOf(s1))).append(":").append(l4).toString();
//        s3 = s2;
//          goto _L3
//        Exception exception;
//        exception;
        
        if(l4 >= 10L) {
        	s3 = (new StringBuilder(String.valueOf(s1))).append(":").append(l4).toString();

        } else {
        	s3 = (new StringBuilder(String.valueOf(s1))).append(":0").append(l4).toString();
        }
        
      mTextView3.setText(s3);
      i = (int)l1;
      j = i / 10;
      k = i % 10;
      mImageOne.setImageResource(Utils.getResouces(j));
      mImageTwo.setImageResource(Utils.getResouces(k));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030003, viewgroup, false);
        mImageOne = (ImageView)view.findViewById(0x7f050018);
        mImageTwo = (ImageView)view.findViewById(0x7f050019);
        mTextView3 = (TextView)view.findViewById(0x7f05001a);
        mTimeTextView = (TextView)view.findViewById(0x7f050013);
        mFirstCountryImage = (ImageView)view.findViewById(0x7f05001d);
        mFirstCountryText = (TextView)view.findViewById(0x7f05001c);
        mSecondCountryImage = (ImageView)view.findViewById(0x7f05001f);
        mSecondCountryText = (TextView)view.findViewById(0x7f05001e);
        countdown();
        requestData();
        return view;
    }

    Handler handler;
    private ImageView mFirstCountryImage;
    private TextView mFirstCountryText;
    private ImageView mImageOne;
    private ImageView mImageTwo;
    private ImageView mSecondCountryImage;
    private TextView mSecondCountryText;
    private TextView mTextView3;
    private TextView mTimeTextView;
    private Timer timer;






}
