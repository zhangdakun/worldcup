// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.os.*;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.*;
import android.widget.ExpandableListView;
import com.ifeng.worldcup.adapter.MyExpandableListViewAdapter;
import com.ifeng.worldcup.configure.SaichengUtil;
import com.ifeng.worldcup.datahandler.IDataHandler;
import com.ifeng.worldcup.datahandler.SaichengDataHandler;
import com.ifeng.worldcup.domain.Month_day;
import com.ifeng.worldcup.domain.Saicheng;
import com.ifeng.worldcup.widget.LoadStateView;
import java.util.ArrayList;
import org.json.*;

public class FixturesFragment extends Fragment
{
	public static final String TAG = "FixturesFragment";

    public FixturesFragment()
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
//                message.what;
//                JVM INSTR tableswitch 1 2: default 32
//            //                           1 33
//            //                           2 47;
//                   goto _L1 _L2 _L3
//_L1:
//                return;
//_L2:
//                parseResult(message.obj);
//                continue; /* Loop/switch isn't completed */
//_L3:
//                mLoadStateView.stopLoad();
//                if(true) goto _L1; else goto _L4
//_L4:
                
                switch (message.what) {
				case 1:
					parseResult(message.obj);
					break;
				case 2:
					mLoadStateView.stopLoad();
					break;

				default:
					break;
				}
            }

//            final FixturesFragment this$0;
//
//            
//            {
//                this$0 = FixturesFragment.this;
//                super();
//            }
        }
;
    }
// leb not finish
    private void parseResult(Object obj)
    {
        mLoadStateView.stopLoad();
        
        Log.d(TAG, "parseResult, "+obj);
//        if(obj != null) goto _L2; else goto _L1
//_L1:
//        return;
//_L2:
//        ArrayList arraylist;
//        ArrayList arraylist1;
//        arraylist = new ArrayList();
//        arraylist1 = new ArrayList();
//        JSONArray jsonarray;
//        int i;
//        int j;
//        jsonarray = new JSONArray((String)obj);
//        i = 0;
//        j = 0;
//_L7:
//        int k = jsonarray.length();
//        if(j < k) goto _L4; else goto _L3
//_L3:
//        MyExpandableListViewAdapter myexpandablelistviewadapter = new MyExpandableListViewAdapter(getActivity());
//        myexpandablelistviewadapter.setData(arraylist, arraylist1);
//        expandableListView.setAdapter(myexpandablelistviewadapter);
//          goto _L1
//_L4:
//        String s;
//        String s1;
//        String s2;
//        ArrayList arraylist2;
//        JSONObject jsonobject = (JSONObject)jsonarray.get(j);
//        s = jsonobject.getString("id");
//        s1 = jsonobject.getString("data");
//        s2 = jsonobject.getString("date");
//        arraylist2 = new ArrayList();
//        if(!"06\u670813\u65E5".equals(s2)) goto _L6; else goto _L5
//_L5:
//        Month_day month_day = new Month_day();
//        month_day.setTypeName("\u5C0F\u7EC4\u8D5B");
//        arraylist.add(month_day);
//        arraylist1.add(arraylist2);
//_L10:
//        String as[];
//        ArrayList arraylist3;
//        int l;
//        String s3 = s2.substring(3, 5);
//        String s4 = s2.substring(0, 2);
//        Month_day month_day1 = new Month_day();
//        month_day1.setDay(s3);
//        month_day1.setMonth(s4);
//        arraylist.add(month_day1);
//        as = s1.split("]");
//        arraylist3 = new ArrayList();
//        l = 0;
//_L11:
//        if(l < -1 + as.length)
//            break MISSING_BLOCK_LABEL_547;
//        arraylist1.add(arraylist3);
//        j++;
//          goto _L7
//_L6:
//        if(!"06\u670829\u65E5".equals(s2)) goto _L9; else goto _L8
//_L8:
//        Month_day month_day2 = new Month_day();
//        month_day2.setTypeName("1/8\u51B3\u8D5B");
//        arraylist.add(month_day2);
//        arraylist1.add(arraylist2);
//          goto _L10
//        JSONException jsonexception;
//        jsonexception;
//        Log.e("Fix", (new StringBuilder()).append(jsonexception.toString()).toString());
//          goto _L3
//_L9:
//        if(!"07\u670805\u65E5".equals(s2))
//            break MISSING_BLOCK_LABEL_418;
//        Month_day month_day3 = new Month_day();
//        month_day3.setTypeName("1/4\u51B3\u8D5B");
//        arraylist.add(month_day3);
//        arraylist1.add(arraylist2);
//          goto _L10
//        Exception exception;
//        exception;
//        Log.e("Fix", (new StringBuilder()).append(exception.toString()).toString());
//          goto _L3
//        if("07\u670809\u65E5".equals(s2))
//        {
//            Month_day month_day4 = new Month_day();
//            month_day4.setTypeName("\u534A\u51B3\u8D5B");
//            arraylist.add(month_day4);
//            arraylist1.add(arraylist2);
//        } else
//        if("07\u670813\u65E5".equals(s2))
//        {
//            Month_day month_day5 = new Month_day();
//            month_day5.setTypeName("\u5B63\u519B\u8D5B");
//            arraylist.add(month_day5);
//            arraylist1.add(arraylist2);
//        } else
//        if("07\u670814\u65E5".equals(s2))
//        {
//            Month_day month_day6 = new Month_day();
//            month_day6.setTypeName("\u51B3\u8D5B");
//            arraylist.add(month_day6);
//            arraylist1.add(arraylist2);
//        }
//          goto _L10
//        String as1[] = as[l].split("\\s+");
//        Saicheng saicheng = new Saicheng();
//        if(l == 0)
//        {
//            saicheng.setDate(s2);
//            saicheng.setId(s);
//            String s10 = as1[0];
//            String s11 = as1[1];
//            String s12 = as1[2];
//            String s13 = as1[3];
//            String s14 = as1[4];
//            saicheng.setBisaiType(s10);
//            saicheng.setTime(s11);
//            saicheng.setVs(s12);
//            saicheng.setZubie(s13);
//            saicheng.setBisaidi(s14);
//        } else
//        {
//            saicheng.setDate(s2);
//            saicheng.setId(s);
//            String s5 = as1[1];
//            String s6 = as1[2];
//            String s7 = as1[3];
//            String s8 = as1[4];
//            String s9 = as1[5];
//            saicheng.setBisaiType(s5);
//            saicheng.setTime(s6);
//            saicheng.setVs(s7);
//            saicheng.setZubie(s8);
//            saicheng.setBisaidi(s9);
//        }
//        i++;
//        saicheng.setCount(i);
//        arraylist3.add(saicheng);
//        l++;
//          goto _L11
        
        
        if(null == obj) {
        	return;
        }
        
        
      ArrayList arraylist;
      ArrayList arraylist1;
      arraylist = new ArrayList();
      arraylist1 = new ArrayList();
      JSONArray jsonarray;
		int i = 0;
		// int j;
		try {
			jsonarray = new JSONArray((String) obj);

			for (int j = 0; j < jsonarray.length(); j++) {
		        String s;
		        String s1;
		        String s2;
		        ArrayList arraylist2;
		        JSONObject jsonobject = (JSONObject)jsonarray.get(j);
		        s = jsonobject.getString("id");
		        s1 = jsonobject.getString("data");
		        s2 = jsonobject.getString("date");
		        arraylist2 = new ArrayList();
		        if("06\u670813\u65E5".equals(s2)) {// goto _L6; else goto _L5
		          Month_day month_day = new Month_day();
		          month_day.setTypeName("\u5C0F\u7EC4\u8D5B");
		          arraylist.add(month_day);
		          arraylist1.add(arraylist2);
		        } else if("06\u670829\u65E5".equals(s2)) {// goto _L9; else goto _L8
		          Month_day month_day2 = new Month_day();
		          month_day2.setTypeName("1/8\u51B3\u8D5B");
		          arraylist.add(month_day2);
		          arraylist1.add(arraylist2);
//		            goto _L10
		        }
		        else if("07\u670805\u65E5".equals(s2)) {

			        Month_day month_day3 = new Month_day();
			        month_day3.setTypeName("1/4\u51B3\u8D5B");
			        arraylist.add(month_day3);
			        arraylist1.add(arraylist2);
//	          goto _L10
		        }
		        else if("07\u670809\u65E5".equals(s2))
		        {
		            Month_day month_day4 = new Month_day();
		            month_day4.setTypeName("\u534A\u51B3\u8D5B");
		            arraylist.add(month_day4);
		            arraylist1.add(arraylist2);
		        } else
		        if("07\u670813\u65E5".equals(s2))
		        {
		            Month_day month_day5 = new Month_day();
		            month_day5.setTypeName("\u5B63\u519B\u8D5B");
		            arraylist.add(month_day5);
		            arraylist1.add(arraylist2);
		        } else
		        if("07\u670814\u65E5".equals(s2))
		        {
		            Month_day month_day6 = new Month_day();
		            month_day6.setTypeName("\u51B3\u8D5B");
		            arraylist.add(month_day6);
		            arraylist1.add(arraylist2);
		        }
		        
		        
		        
//		        String as[];
//		        ArrayList arraylist3;
//		        int l;
//		        String s3 = s2.substring(3, 5);
//		        String s4 = s2.substring(0, 2);
//		        Month_day month_day1 = new Month_day();
//		        month_day1.setDay(s3);
//		        month_day1.setMonth(s4);
//		        arraylist.add(month_day1);
//		        as = s1.split("]");
//		        arraylist3 = new ArrayList();
//		        l = 0;
//		        for(l=0;l<as.length;l++) {
//		        
//		        String as1[] = as[l].split("\\s+");
//		        Saicheng saicheng = new Saicheng();
//		        if(l == 0)
//		        {
//		            saicheng.setDate(s2);
//		            saicheng.setId(s);
//		            String s10 = as1[0];
//		            String s11 = as1[1];
//		            String s12 = as1[2];
//		            String s13 = as1[3];
//		            String s14 = as1[4];
//		            saicheng.setBisaiType(s10);
//		            saicheng.setTime(s11);
//		            saicheng.setVs(s12);
//		            saicheng.setZubie(s13);
//		            saicheng.setBisaidi(s14);
//		        } else
//		        {
//		            saicheng.setDate(s2);
//		            saicheng.setId(s);
//		            String s5 = as1[1];
//		            String s6 = as1[2];
//		            String s7 = as1[3];
//		            String s8 = as1[4];
//		            String s9 = as1[5];
//		            saicheng.setBisaiType(s5);
//		            saicheng.setTime(s6);
//		            saicheng.setVs(s7);
//		            saicheng.setZubie(s8);
//		            saicheng.setBisaidi(s9);
//		        }
//		        i++;
//		        saicheng.setCount(i);
//		        arraylist3.add(saicheng);
//		        }
//		        
//		        arraylist1.add(arraylist3);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
		
		
      MyExpandableListViewAdapter myexpandablelistviewadapter = new MyExpandableListViewAdapter(getActivity());
      myexpandablelistviewadapter.setData(arraylist, arraylist1);
      expandableListView.setAdapter(myexpandablelistviewadapter);
    }

    private void requestData()
    {
        SaichengDataHandler.getInstance().publishTask(new IDataHandler() {

            public void loadFail(Object obj)
            {
                Message message = Message.obtain();
                message.what = 2;
                mHandler.sendMessage(message);
            }

            public void loadSuccess(Object obj)
            {
                Message message = Message.obtain();
                message.what = 1;
                message.obj = obj;
                mHandler.sendMessage(message);
            }

//            final FixturesFragment this$0;
//
//            
//            {
//                this$0 = FixturesFragment.this;
//                super();
//            }
        }
);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030002, viewgroup, false);
        expandableListView = (ExpandableListView)view.findViewById(0x7f050016);
        mLoadStateView = (LoadStateView)view.findViewById(0x7f050026);
        parseResult(SaichengUtil.getSaicheng(getActivity()));
        requestData();
        return view;
    }

    private ExpandableListView expandableListView;
    private Handler mHandler;
    protected LoadStateView mLoadStateView;


}
