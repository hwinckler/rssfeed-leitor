package rssfeedleitor.reader;

import java.io.InputStream;
import java.util.Date;

import rssfeedleitor.channel.model.Channel;
import rssfeedleitor.user.model.User;

public interface RSSFeed {

	public Channel parse(InputStream stream, User user) throws RSSFeedParserException;

	Channel parse(InputStream stream, User user, Date pubDate)throws RSSFeedParserException;
}
