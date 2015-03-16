package rssfeedleitor.model.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public class FeedModelTest {

	@Test
	public void newFeed(){
		
		Category category = new Category("Java", new Date());
		
		Channel channel = new Channel(category, "GUJ Notícias", "http://guj.com.br/noticias/rss", new Date());
		channel.getFeeds().add(new Feed(channel, 1, "Novo release do Junit",new Date(), "http//junit.org/release"));
		
	
		Assert.assertEquals("Java", category.getChannels().get(0).getCategory().getTitle());
		Assert.assertEquals("GUJ Notícias", category.getChannels().get(0).getTitle());
		Assert.assertEquals("http://guj.com.br/noticias/rss", category.getChannels().get(0).getLink());
		
		Assert.assertEquals(1, category.getChannels().size());
		Assert.assertEquals(1, category.getChannels().get(0).getFeeds().size());
		
		Assert.assertEquals("Novo release do Junit", category.getChannels().get(0).getFeeds().get(0).getTitle());
		Assert.assertEquals("http//junit.org/release", category.getChannels().get(0).getFeeds().get(0).getLink());
	
	}
	
}
