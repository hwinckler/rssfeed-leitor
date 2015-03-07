package tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RomeExample {

	public static void main(String[] args) throws Exception{
		
	    HttpURLConnection httpConnection = (HttpURLConnection) new URL("http://www.guj.com.br/noticias/rss").openConnection();
	    httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		
		
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpConnection.getInputStream()));
		
		System.out.println("feed: " + feed.getTitle());
		
		List<SyndEntryImpl> entries = feed.getEntries();
		for (SyndEntryImpl object : entries) {
			System.out.println("title: " + object.getTitle());
		}
		
		

	}

}
