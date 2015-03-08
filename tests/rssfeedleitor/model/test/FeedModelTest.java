package rssfeedleitor.model.test;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

public class FeedModelTest {

	@Test
	public void newFeed(){
		
		Category category = new Category("Java", Calendar.getInstance());
		
		Channel channel = new Channel(category, "GUJ Notícias", "http://guj.com.br/noticias/rss", Calendar.getInstance());
		channel.getFeeds().add(new Feed(1, "Novo release do Junit", Calendar.getInstance(), "http//junit.org/release"));
		
		category.getChannels().add(channel);
		
		Assert.assertEquals("Java", category.getChannels().get(0).getCategory().getTitle());
		Assert.assertEquals("GUJ Notícias", category.getChannels().get(0).getTitle());
		Assert.assertEquals("http://guj.com.br/noticias/rss", category.getChannels().get(0).getLink());
		
		Assert.assertEquals(1, category.getChannels().size());
		Assert.assertEquals(1, category.getChannels().get(0).getFeeds().size());
		
		Assert.assertEquals("Novo release do Junit", category.getChannels().get(0).getFeeds().get(0).getTitle());
		Assert.assertEquals("http//junit.org/release", category.getChannels().get(0).getFeeds().get(0).getLink());
	
	}
	
}
