package tests;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;
import com.ernieyu.feedparser.Item;

public class SimpleFeedParserExample {

	public static void main(String[] args) throws Exception{
		
		//URLConnection connection = new URL("http://www.guj.com.br/noticias/rss").openConnection();
		//connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		//connection.connect();
		
		
		
		
		URL url = new URL("http://www.guj.com.br/noticias/rss");
		
		
	    HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
	    httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
	    
	    System.out.println("httpConnection.getResponseCode() = " + httpConnection.getResponseCode());
	    
	    if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        	     
	        FeedParser parser = FeedParserFactory.newParser();
	        Feed feed = parser.parse(httpConnection.getInputStream());
	        
	        System.out.println("title: " + feed.getTitle());
	        
	        List<Item> itemList = feed.getItemList();
	        for (Item item : itemList) {
				System.out.println("item: " + item.getTitle());
			}
	        
	    }

	}

}
