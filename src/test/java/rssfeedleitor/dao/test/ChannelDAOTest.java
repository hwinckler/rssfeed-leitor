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

import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.model.Channel;
import dbunit.dataset.load.DBUnitLoad;

public class ChannelDAOTest  extends DBUnitLoad{

	@Inject
	static ChannelDAO channelDAO;
		
	final static String dataSet = "/dao/test/ChannelDataset.xml";
	
	@BeforeClass
	public static void init() throws Exception {
		setUp(dataSet);
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		channelDAO = container.instance().select(ChannelDAO.class).get();
	}
	
	@Test
	public void addChannel(){
		
		Channel channel1 = new Channel("channel1", "http://channel1.com", new Date());
		Channel channel2 = new Channel("channel2", "http://channel1.com", new Date());
	
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
	}
	
	@AfterClass
	public static void end() throws Exception {
		tearDown();
	}
	
}
