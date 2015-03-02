package tests;

import model.Feed;
import model.FeedMessage;
import read.RSSFeedParser;

public class ReadTest {

	  public static void main(String[] args) {
		    RSSFeedParser parser = new RSSFeedParser("http://www.vogella.com/article.rss");
		    Feed feed = parser.readFeed();
		    System.out.println(feed);
		    for (FeedMessage message : feed.getMessages()) {
		      System.out.println(message);

		    }

		  }
	
}
