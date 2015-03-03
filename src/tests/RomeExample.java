package tests;

import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RomeExample {

	public static void main(String[] args) throws Exception{
		
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(new URL("http://www.ondetrabalhar.com/vagas.rss")));
		
		System.out.println("title: " + feed.getTitle());
		
		List<SyndEntryImpl> entries = feed.getEntries();
		for (SyndEntryImpl object : entries) {
			System.out.println("title: " + object.getTitle());
		}
		
		

	}

}
