// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 

package com.ifeng.worldcup;

import android.content.Intent;
import android.os.*;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import com.ifeng.worldcup.adapter.NewsAdapter;
import com.ifeng.worldcup.datahandler.IDataHandler;
import com.ifeng.worldcup.datahandler.NewsDataHandler;
import com.ifeng.worldcup.domain.News;
import com.ifeng.worldcup.widget.LoadStateView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// Referenced classes of package com.ifeng.worldcup:
//            WebviewActivity

public class NewsFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener
{

    public NewsFragment()
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
//                mNewsList = (ArrayList)message.obj;
//                NewsAdapter newsadapter = new NewsAdapter(getActivity());
//                newsadapter.setData(mNewsList);
//                mListView.setAdapter(newsadapter);
//                continue; /* Loop/switch isn't completed */
//_L3:
//                mLoadStateView.stopLoad();
//                if(true) goto _L1; else goto _L4
//_L4:
                switch (message.what) {
				case 1:
	                mLoadStateView.stopLoad();
	                mNewsList = (ArrayList)message.obj;
	                NewsAdapter newsadapter = new NewsAdapter(getActivity());
	                newsadapter.setData(mNewsList);
	                mListView.setAdapter(newsadapter);
					break;
					
				case 2:
					mLoadStateView.stopLoad();
					break;

				default:
					break;
				}
            }

//            final NewsFragment this$0;
//
//            
//            {
//                this$0 = NewsFragment.this;
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
//_L5:
//        int j = jsonarray.length();
//        if(i < j) goto _L4; else goto _L3
//_L3:
//        Message message = Message.obtain();
//        message.what = 1;
//        message.obj = arraylist;
//        mHandler.sendMessage(message);
//          goto _L1
//_L4:
//        String s1;
//        String s2;
//        Iterator iterator;
//        JSONObject jsonobject = (JSONObject)jsonarray.get(i);
//        String s = jsonobject.getString("data");
//        s1 = jsonobject.getString("date");
//        s2 = jsonobject.getString("id");
//        News news = new News();
//        news.setDate(s1);
//        news.setTitle(s1);
//        news.setId(s2);
//        arraylist.add(news);
//        iterator = Jsoup.parseBodyFragment(s).body().getElementsByTag("dd").iterator();
//_L6:
//        if(iterator.hasNext())
//            break MISSING_BLOCK_LABEL_180;
//        i++;
//          goto _L5
//        Iterator iterator1 = ((Element)iterator.next()).getElementsByTag("a").iterator();
//        while(iterator1.hasNext()) 
//        {
//            Element element = (Element)iterator1.next();
//            String s3 = element.attr("href");
//            String s4 = element.text();
//            News news1 = new News();
//            news1.setDate(s1);
//            news1.setId(s2);
//            news1.setTitle(s4);
//            news1.setUrl(s3);
//            arraylist.add(news1);
//        }
//          goto _L6
//        JSONException jsonexception;
//        jsonexception;
//        jsonexception.printStackTrace();
//          goto _L3
    	
    	if(null == obj) {
    		return;
    	}
    	
      ArrayList arraylist = new ArrayList();
      JSONArray jsonarray;
      int i=0;
      try {
		jsonarray = new JSONArray((String)obj);
		for(i=0;i<jsonarray.length();i++) {
	        String s1;
	        String s2;
	        Iterator iterator;
	        JSONObject jsonobject = (JSONObject)jsonarray.get(i);
	        String s = jsonobject.getString("data");
	        s1 = jsonobject.getString("date");
	        s2 = jsonobject.getString("id");
	        News news = new News();
	        news.setDate(s1);
	        news.setTitle(s1);
	        news.setId(s2);
	        arraylist.add(news);
	        iterator = Jsoup.parseBodyFragment(s).body().getElementsByTag("dd").iterator();
	        
	        while(iterator.hasNext()) {
	        	Iterator iterator1 = ((Element)iterator.next()).getElementsByTag("a").iterator();
	          while(iterator1.hasNext()) 
	          {
	              Element element = (Element)iterator1.next();
	              String s3 = element.attr("href");
	              String s4 = element.text();
	              News news1 = new News();
	              news1.setDate(s1);
	              news1.setId(s2);
	              news1.setTitle(s4);
	              news1.setUrl(s3);
	              arraylist.add(news1);
	          }
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
        NewsDataHandler.getInstance().publishTask(new IDataHandler() {

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

//            final NewsFragment this$0;
//
//            
//            {
//                this$0 = NewsFragment.this;
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
        View view = layoutinflater.inflate(0x7f030004, viewgroup, false);
        mListView = (ListView)view.findViewById(0x7f050020);
        mListView.setOnItemClickListener(this);
        mLoadStateView = (LoadStateView)view.findViewById(0x7f050026);
        requestData();
        return view;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
//_L2:
//        return;
//        if(mNewsList == null || mNewsList.size() == 0) goto _L2; else goto _L1
//_L1:
//        News news = (News)mNewsList.get(i);
//        String s = news.getUrl();
//        String s1 = news.getTitle();
//        if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s))
//        {
//            Intent intent = new Intent(getActivity(), WebviewActivity.class);
//            intent.putExtra("url", s);
//            intent.putExtra("title", s1);
//            startActivity(intent);
//        }
//        if(true) goto _L2; else goto _L3
//_L3:
    	
    	if(mNewsList == null || mNewsList.size() == 0) {
    		return;
    	}
    	
    	
      News news = (News)mNewsList.get(i);
      String s = news.getUrl();
      String s1 = news.getTitle();
      if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s))
      {
          Intent intent = new Intent(getActivity(), WebviewActivity.class);
          intent.putExtra("url", s);
          intent.putExtra("title", s1);
          startActivity(intent);
      }
    }

    private Handler mHandler;
    private ListView mListView;
    protected LoadStateView mLoadStateView;
    private ArrayList mNewsList;





}
