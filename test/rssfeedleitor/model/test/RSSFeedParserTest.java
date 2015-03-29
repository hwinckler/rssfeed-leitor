package rssfeedleitor.model.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;
import rssfeedleitor.reader.RSSFeed;
import rssfeedleitor.reader.RSSFeedParserException;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

public class RSSFeedParserTest extends DBUnitLoad {

	@Inject
	static RSSFeed rssFeed;
	
	@Inject
	static CategoryDAO categoryDAO;
	
	@Inject
	static ChannelDAO channelDAO;
	
	@Inject
	static FeedDAO feedDAO;
	
	final static String dataSet = "/RSSFeedParserDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		
		rssFeed = injector.getInstance(RSSFeed.class);
		
		categoryDAO = injector.getInstance(CategoryDAO.class);
		channelDAO = injector.getInstance(ChannelDAO.class);
		feedDAO = injector.getInstance(FeedDAO.class);
		
		
	}

	@Test
	public void insert(){
		categoryDAO.insert(Category.newDefault());
	}
	
	@Test
	public void parse() throws IOException, RSSFeedParserException{
		
		try(FileInputStream stream = new FileInputStream(getClass().getResource("/rssfeed-local.xml").getFile())){
			
			Category category = categoryDAO.findById(1);
			
			Channel channel = rssFeed.parse(stream);
			channel.setCategory(category);
			
			channelDAO.insert(channel);
			
			for(Feed feed : channel.getFeeds()){
				feedDAO.insert(feed);
			}
			
		}
		
	}
	
	@Test
	public void results(){
		
		Category category = categoryDAO.findById(1);
		
		Assert.assertEquals(Category.DEFAULT, category.getTitle());
		
		Channel channel = channelDAO.findById(1);
		
		Assert.assertEquals("Teste do RSSFeedParser", channel.getTitle());
		Assert.assertEquals("http://github.com/hwinckler", channel.getLink());
		
		List<Feed> feeds = channel.getFeeds();

		Assert.assertEquals("Item 2", feeds.get(0).getTitle());
		Assert.assertEquals("http://item2.ccom", feeds.get(0).getLink());
		
		Assert.assertEquals("Item 1", feeds.get(1).getTitle());
		Assert.assertEquals("http://item1.ccom", feeds.get(1).getLink());
		
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
}
