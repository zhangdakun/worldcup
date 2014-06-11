// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.content.Intent;
import android.net.Uri;
import android.os.*;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ifeng.worldcup.adapter.VideoAdapter;
import com.ifeng.worldcup.datahandler.IDataHandler;
import com.ifeng.worldcup.datahandler.VideoDataHandler;
import com.ifeng.worldcup.domain.Video;
import com.ifeng.worldcup.widget.LoadStateView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class VideoFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

	public static final String TAG = "VideoFragment";
    public VideoFragment()
    {
        mHandler = new Handler() {

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
//                message.what;
//                JVM INSTR tableswitch 1 2: default 32
//            //                           1 33
//            //                           2 97;
//                   goto _L1 _L2 _L3
//_L1:
//                return;
//_L2:
//                mLoadStateView.stopLoad();
//                mVideoList = (ArrayList)message.obj;
//                VideoAdapter videoadapter = new VideoAdapter(getActivity());
//                videoadapter.setData(mVideoList);
//                mListView.setAdapter(videoadapter);
//                continue; /* Loop/switch isn't completed */
//_L3:
//                mLoadStateView.stopLoad();
//                if(true) goto _L1; else goto _L4
//_L4:
                switch (message.what) {
				case 1:
	                mLoadStateView.stopLoad();
	                mVideoList = (ArrayList)message.obj;
	                VideoAdapter videoadapter = new VideoAdapter(getActivity());
	                videoadapter.setData(mVideoList);
	                mListView.setAdapter(videoadapter);
					break;
				case 2:
					mLoadStateView.stopLoad();
					break;

				default:
					break;
				}
            }

//            final VideoFragment this$0;
//
//            
//            {
//                this$0 = VideoFragment.this;
//                super();
//            }
        }
;
    }

    private void parseResult(Object obj)
    {
//        if(obj != null) goto _L2; else goto _L1
//_L1:
//        return;
//_L2:
//        ArrayList arraylist = new ArrayList();
//        JSONArray jsonarray;
//        int i;
//        jsonarray = new JSONArray((String)obj);
//        i = 0;
//_L9:
//        int j = jsonarray.length();
//        if(i < j) goto _L4; else goto _L3
//_L3:
//        Message message = Message.obtain();
//        message.what = 1;
//        message.obj = arraylist;
//        mHandler.sendMessage(message);
//          goto _L1
//_L4:
//        String s;
//        Document document;
//        String s1;
//        String s2;
//        Iterator iterator;
//        JSONObject jsonobject = (JSONObject)jsonarray.get(i);
//        s = jsonobject.getString("id");
//        document = Jsoup.parseBodyFragment(jsonobject.getString("data"));
//        Elements elements = document.body().getElementsByTag("a");
//        s1 = "";
//        s2 = "";
//        iterator = elements.iterator();
//_L7:
//        if(iterator.hasNext()) goto _L6; else goto _L5
//_L5:
//        String s3;
//        Iterator iterator1;
//        Elements elements1 = document.select("div");
//        s3 = "";
//        iterator1 = elements1.iterator();
//_L8:
//        if(!iterator1.hasNext())
//        {
//            Element element;
//            if(!TextUtils.isEmpty(s3))
//            {
//                Video video = new Video();
//                video.setId(s);
//                video.setTitle(s3);
//                arraylist.add(video);
//                Video video1 = new Video();
//                video1.setUrl(s1);
//                video1.setTitle(s2);
//                arraylist.add(video1);
//            } else
//            {
//                Video video2 = new Video();
//                video2.setId(s);
//                video2.setUrl(s1);
//                video2.setTitle(s2);
//                arraylist.add(video2);
//            }
//            break MISSING_BLOCK_LABEL_351;
//        }
//        break MISSING_BLOCK_LABEL_275;
//_L6:
//        element = (Element)iterator.next();
//        s1 = element.attr("href");
//        s2 = element.text().trim();
//          goto _L7
//        s3 = ((Element)iterator1.next()).text().trim();
//          goto _L8
//        JSONException jsonexception;
//        jsonexception;
//        jsonexception.printStackTrace();
//          goto _L3
//        Exception exception;
//        exception;
//          goto _L3
//        i++;
//          goto _L9
    	
    	if(null == obj) {
    		return;
    	}
    	Log.d(TAG, "parseResult" + obj);
      ArrayList arraylist = new ArrayList();
      JSONArray jsonarray;
//      int i;
      try {
		jsonarray = new JSONArray((String)obj);
    	for(int i=0;i<jsonarray.length();i++) {
          String s;
          Document document;
          String s1;
          String s2;
          Iterator iterator;
          JSONObject jsonobject = (JSONObject)jsonarray.get(i);
          s = jsonobject.getString("id");
          document = Jsoup.parseBodyFragment(jsonobject.getString("data"));
          Elements elements = document.body().getElementsByTag("a");
          s1 = "";
          s2 = "";
          iterator = elements.iterator();
          
          while(iterator.hasNext()) {
            Element element = (Element)iterator.next();
            s1 = element.attr("href");
            s2 = element.text().trim();
            Log.d("", "s1 = "+s1+", s2 = "+s2);
          }
          
        String s3;
        Iterator iterator1;
        Elements elements1 = document.select("div");
        s3 = "";
        iterator1 = elements1.iterator();
          
        while(iterator1.hasNext()) {
        	s3 = ((Element)iterator1.next()).text().trim();
        	 Log.d("", "s3 = "+s3 );
        	break;
        }
        
      if(!TextUtils.isEmpty(s3))
      {
          Video video = new Video();
          video.setId(s);
          video.setTitle(s3);
          arraylist.add(video);
          Video video1 = new Video();
          video1.setUrl(s1);
          video1.setTitle(s2);
          arraylist.add(video1);
      } else
      {
          Video video2 = new Video();
          video2.setId(s);
          video2.setUrl(s1);
          video2.setTitle(s2);
          arraylist.add(video2);
      }
        
    	}
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

      
    Message message = Message.obtain();
    message.what = 1;
    message.obj = arraylist;
    mHandler.sendMessage(message);
    }

    private void requestData()
    {
        VideoDataHandler.getInstance().publishTask(new IDataHandler() {

            public void loadFail(Object obj)
            {
                Message message = Message.obtain();
                message.what = 2;
                mHandler.sendMessage(message);
            }

            public void loadSuccess(Object obj)
            {
                parseResult(obj);
            }

//            final VideoFragment this$0;
//
//            
//            {
//                this$0 = VideoFragment.this;
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
        View view = layoutinflater.inflate(0x7f030005, viewgroup, false);
        mListView = (ListView)view.findViewById(0x7f050021);
        mListView.setOnItemClickListener(this);
        mLoadStateView = (LoadStateView)view.findViewById(0x7f050026);
        requestData();
        return view;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
//_L2:
//        return;
//        if(mVideoList == null || mVideoList.size() == 0) goto _L2; else goto _L1
//_L1:
//        Video video = (Video)mVideoList.get(i);
//        String s = video.getUrl();
//        if(!TextUtils.isEmpty(video.getTitle()) && !TextUtils.isEmpty(s))
//            try
//            {
//                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
//            }
//            catch(Exception exception) { }
//        if(true) goto _L2; else goto _L3
//_L3:
    	
    	if(mVideoList == null || mVideoList.size() == 0) {
    		return ;
    	}
    	
      Video video = (Video)mVideoList.get(i);
      String s = video.getUrl();
      if(!TextUtils.isEmpty(video.getTitle()) && !TextUtils.isEmpty(s))
          try
          {
              startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
          }
          catch(Exception exception) {
        	  exception.printStackTrace();
          }
    }

    private Handler mHandler;
    private ListView mListView;
    protected LoadStateView mLoadStateView;
    private ArrayList mVideoList;





}
