package rssfeedleitor.dao.test;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.model.Feed;
import dbunit.dataset.load.DBUnitLoad;

public class FeedDAOTest  extends DBUnitLoad{

	@Inject
	static FeedDAO feedDAO;
		
	final static String dataSet = "/dao/test/FeedDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		feedDAO = container.instance().select(FeedDAO.class).get();
	}
	
	@Test
	public void addFeed(){
		
		Feed feed1 = new Feed(1, "feed1", new Date(), "http://feed1.com");
		Feed feed2 = new Feed(2, "feed2", new Date(), "http://feed3.com");
		Feed feed3 = new Feed(3, "feed3", new Date(), "http://feed3.com");
		Feed feed4 = new Feed(4, "feed4", new Date(), "http://feed4.com");

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
		
		Assert.assertEquals("feed4", feed.getTitle());
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
