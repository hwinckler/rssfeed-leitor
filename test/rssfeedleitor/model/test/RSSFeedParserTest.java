package rssfeedleitor.model.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.category.bo.CategoryBO;
import rssfeedleitor.category.model.Category;
import rssfeedleitor.channel.bo.ChannelBO;
import rssfeedleitor.channel.model.Channel;
import rssfeedleitor.exception.CategoryException;
import rssfeedleitor.exception.ChannelException;
import rssfeedleitor.exception.UserException;
import rssfeedleitor.feed.bo.FeedBO;
import rssfeedleitor.feed.model.Feed;
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.reader.RSSFeed;
import rssfeedleitor.reader.RSSFeedParserException;
import rssfeedleitor.user.bo.UserBO;
import rssfeedleitor.user.model.User;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

public class RSSFeedParserTest extends DBUnitLoad {

	@Inject
	static RSSFeed rssFeed;
	
	@Inject
	static CategoryBO categoryBO;
	
	@Inject
	static ChannelBO channelBO;
	
	@Inject
	static FeedBO feedBO;
	
	@Inject
	static UserBO userBO;
	
	static User user;
	
	final static String dataSet = "/RSSFeedParserDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		
		rssFeed = injector.getInstance(RSSFeed.class);
		
		categoryBO = injector.getInstance(CategoryBO.class);
		channelBO = injector.getInstance(ChannelBO.class);
		feedBO = injector.getInstance(FeedBO.class);
		userBO = injector.getInstance(UserBO.class);
		
	}

	@Test
	public void parse() throws IOException, RSSFeedParserException, CategoryException, UserException, ChannelException{
		
		user = userBO.createsNotExist(new User("user1@user.com"));
		
		try(FileInputStream stream = new FileInputStream(getClass().getResource("/rssfeed-local.xml").getFile())){
			
			Channel channel = rssFeed.parse(stream, user);
			
			channelBO.insert(channel, user);
		
		}
		
	}
	
	@Test
	public void results() throws CategoryException{
		
		Category category = categoryBO.findById(1, user);
		
		Assert.assertEquals(Category.DEFAULT, category.getTitle());
		
		Channel channel = channelBO.findById(1, user);
		
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
