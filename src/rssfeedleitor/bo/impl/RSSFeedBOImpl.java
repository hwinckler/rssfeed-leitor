package rssfeedleitor.bo.impl;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.RSSFeedBO;
import rssfeedleitor.model.Channel;
import rssfeedleitor.reader.RSSFeed;

public class RSSFeedBOImpl implements RSSFeedBO {

	private static final Logger logger = LoggerFactory.getLogger(RSSFeedBOImpl.class);
	
	@Inject
	private RSSFeed rssFeed;

	@Override
	public Channel parse(String link) throws Exception {
		logger.debug("parse()...");
		
		if(link == null ||link.isEmpty()){
			throw new Exception("Link cannot be empty");
		}
		
		HttpURLConnection httpConnection = (HttpURLConnection) new URL(link).openConnection();
		httpConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		
		if (httpConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
			throw new Exception("Failed to obtain feed of url: " + link);
		}
					
		try(InputStream stream = httpConnection.getInputStream()){
			Channel channel = rssFeed.parse(stream);
			channel.setLink(link);
			return channel;
		}
	}
}
