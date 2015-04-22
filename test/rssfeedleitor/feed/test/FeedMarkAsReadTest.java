package rssfeedleitor.feed.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import rssfeedleitor.channel.bo.ChannelBO;
import rssfeedleitor.feed.bo.FeedBO;
import rssfeedleitor.feed.model.Feed;
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.user.bo.UserBO;
import rssfeedleitor.user.model.User;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FeedMarkAsReadTest  extends DBUnitLoad{

	@Inject
	static FeedBO feedBO;

	@Inject
	static ChannelBO channelBO;
	
	@Inject
	static UserBO userBO;
	
	static User user;
	
	final static String dataSet = "/FeedMarkAsReadDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		
		feedBO = injector.getInstance(FeedBO.class);
		channelBO = injector.getInstance(ChannelBO.class);
		userBO = injector.getInstance(UserBO.class);
	}
	
	@Test
	public void findUnread(){
		
		user = userBO.findByEmail("user1@user.com");
		
		List<Feed> unread = feedBO.findUnread(user);
		Assert.assertEquals(3, unread.size());
	}
	
	
	@Test
	public void markAllAsRead(){
		
		user = userBO.findByEmail("user1@user.com");
		
		feedBO.markAllAsRead(1, user);
		
		List<Feed> unread = feedBO.findUnread(user);
		Assert.assertEquals(1, unread.size());
		
		
	}
	
	@Test
	public void markAsRead(){
		
		user = userBO.findByEmail("user1@user.com");
		
		feedBO.markAsRead(4, user);
		
		List<Feed> unread = feedBO.findUnread(user);
		Assert.assertEquals(0, unread.size());
		
		
	}
	
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
