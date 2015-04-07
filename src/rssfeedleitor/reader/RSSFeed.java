package rssfeedleitor.reader;

import java.io.InputStream;
import java.util.Date;

import rssfeedleitor.model.Channel;

public interface RSSFeed {

	public Channel parse(InputStream stream) throws RSSFeedParserException;

	Channel parse(InputStream stream, Date pubDate)throws RSSFeedParserException;
}
