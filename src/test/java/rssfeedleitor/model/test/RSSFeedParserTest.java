package rssfeedleitor.model.test;

import java.io.FileInputStream;
import java.io.IOException;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Test;

import rssfeedleitor.model.Channel;
import rssfeedleitor.reader.RSSFeed;
import rssfeedleitor.reader.RSSFeedParserException;

public class RSSFeedParserTest {

	@Inject
	RSSFeed rssFeed;
	
	public RSSFeedParserTest() {
	
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		rssFeed = container.instance().select(RSSFeed.class).get();
	}
	
	@Test
	public void parserXMLLocal() throws IOException, RSSFeedParserException{
		
		try(FileInputStream stream = new FileInputStream(getClass().getResource("/rssfeed-local.xml").getFile())){
			
			Channel channel = rssFeed.parse(stream);
			
			Assert.assertEquals("Teste do RSSFeedParser", channel.getTitle());
		}
		

		
	}
}
