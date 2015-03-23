package rssfeedleitor.dao.test;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

public class FeedDAOTest  extends DBUnitLoad{

	@Inject
	static FeedDAO feedDAO;

	@Inject
	static ChannelDAO channelDAO;
	
	final static String dataSet = "/FeedDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		
		feedDAO = injector.getInstance(FeedDAO.class);
		channelDAO = injector.getInstance(ChannelDAO.class);
	}
	
	@Test
	public void addFeed(){
		
		Channel channel1 = channelDAO.findById(1);
		
		Feed feed1 = new Feed(channel1, 1, "Nova versão do JUnit", new Date(), "http://feed1.com");
		Feed feed2 = new Feed(channel1, 2, "CDI compatível com MyBatis", new Date(), "http://feed3.com");
		
		Channel channel2 = channelDAO.findById(2);
		
		Feed feed3 = new Feed(channel2, 3, "Tutorial de BootStrap com MyBatis", new Date(), "http://feed3.com");
		
		Channel channel3 = channelDAO.findById(3);
		
		Feed feed4 = new Feed(channel3, 4, "Entrevista com Kent Beck sobre Junit e TDD", new Date(), "http://feed4.com");

		feedDAO.insert(feed1);
		feedDAO.insert(feed2);
		feedDAO.insert(feed3);
		feedDAO.insert(feed4);
	}
	
	@Test
	public void findAll(){
		
		List<Feed> feeds = feedDAO.findAll();
		
		Assert.assertEquals(4, feeds.size());
	}
	
	@Test
	public void findById(){
		Integer id = 4;
		Feed feed = feedDAO.findById(id);
		
		Assert.assertEquals("Entrevista com Kent Beck sobre Junit e TDD", feed.getTitle());
	}
	
	@Test
	public void findByIdWithChannel(){
		Integer id = 4;
		Feed feed = feedDAO.findById(id);
		
		Assert.assertEquals("Entrevista com Kent Beck sobre Junit e TDD", feed.getTitle());
		
		Assert.assertEquals("Agile News", feed.getChannel().getTitle());
		
		Assert.assertEquals("Agile e TDD", feed.getChannel().getCategory().getTitle());
		
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
