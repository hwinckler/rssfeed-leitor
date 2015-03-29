package rssfeedleitor.dao.test;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.guice.AppModule;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;

import com.google.inject.Guice;
import com.google.inject.Injector;

import dbunit.dataset.load.DBUnitLoad;

public class ChannelDAOTest  extends DBUnitLoad{

	@Inject
	static ChannelDAO channelDAO;
	
	@Inject
	static CategoryDAO categoryDAO;
		
	final static String dataSet = "/ChannelDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Injector injector = Guice.createInjector(new AppModule());
		
		channelDAO = injector.getInstance(ChannelDAO.class);
		categoryDAO = injector.getInstance(CategoryDAO.class);
	}
	
	@Test
	public void addChannel(){
		
		Integer id = 1;
		Category category = categoryDAO.findById(id);
		
		Assert.assertEquals("Java", category.getTitle());
		
		Channel channel1 = new Channel(category, "channel1", "", "http://channel1.com", new Date());
		Channel channel2 = new Channel(category, "channel2", "", "http://channel2.com", new Date());
	
		channelDAO.insert(channel1);
		channelDAO.insert(channel2);
	}
	
	@Test
	public void findAll(){
		
		List<Channel> channels = channelDAO.findAll();
		
		Assert.assertEquals(2, channels.size());
	}
	
	@Test
	public void findById(){
		Integer id = 2;
		Channel channel = channelDAO.findById(id);
		
		Assert.assertEquals("channel2", channel.getTitle());
		
		Assert.assertEquals("Java", channel.getCategory().getTitle());
	}
	
	@Test
	public void findCategoryByIdWithChannels(){
		Integer id = 1;
		Category category = categoryDAO.findById(id);
		
		Assert.assertEquals("Java", category.getTitle());
		
		Assert.assertEquals(2, category.getChannels().size());
		
		Assert.assertEquals("channel1", category.getChannels().get(0).getTitle());
		Assert.assertEquals("channel2", category.getChannels().get(1).getTitle());
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
