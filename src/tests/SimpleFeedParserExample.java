package tests;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;

public class SimpleFeedParserExample {

	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.guj.com.br/noticias/rss");
	    HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
	    
	    System.out.println("httpConnection.getResponseCode() = " + httpConnection.getResponseCode());
	    
	    if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	        InputStream feedStream = httpConnection.getInputStream();
	     
	        FeedParser parser = FeedParserFactory.newParser();
	        Feed feed = parser.parse(feedStream);
	        
	        System.out.println("title: " + feed.getTitle());
	        
	    }

	}

}
