package rssfeedleitor.reader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.model.Channel;
import rssfeedleitor.model.Feed;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSFeedParserRome implements RSSFeed{

	private static final Logger logger = LoggerFactory.getLogger(RSSFeedParserRome.class);

	@Override
	public Channel parse(InputStream stream)throws RSSFeedParserException {

		Channel channel = null;
		
		try {
			
			SyndFeed feed = new SyndFeedInput().build(new XmlReader(stream));
			
			if(feed != null){
				channel = new Channel(feed.getTitle(), feed.getDescription(), feed.getUri(), new Date());
				
				List<SyndEntry> entries = feed.getEntries();
				for (SyndEntry entry : entries) {
					channel.getFeeds().add(new Feed(channel, entry.getTitle(), (entry.getDescription() != null) ? StringUtils.abbreviate(entry.getDescription().getValue().replaceAll("\\<.*?\\>", ""), Feed.MAX_DESCRIPTION) : "", entry.getPublishedDate(), entry.getLink(), false));
					
					//channel.getFeeds().add(new Feed(channel, entry.getTitle(), (entry.getDescription() != null) ? StringUtils.abbreviate(entry.getDescription().getValue().replaceAll("\\<.*?\\>", ""), Feed.MAX_DESCRIPTION) : "", entry.getPublishedDate(), entry.getLink(), false));
					//channel.getFeeds().add(new Feed(channel, entry.getTitle(), (entry.getDescription() != null) ? StringUtils.abbreviate(Jsoup.parse(entry.getDescription().getValue()).text(), Feed.MAX_DESCRIPTION) : "", entry.getPublishedDate(), entry.getLink(), false));
					
					
				}
			}
			
		} catch (IllegalArgumentException | FeedException | IOException e) {
			logger.error("error", e);

			throw new RSSFeedParserException(e);
		}
		
		return channel;
	}

}
