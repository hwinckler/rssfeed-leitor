package rssfeedleitor.reader;

import java.io.InputStream;

import rssfeedleitor.model.Channel;

public interface RSSFeed {

	public Channel parse(InputStream stream) throws RSSFeedParserException;
}
