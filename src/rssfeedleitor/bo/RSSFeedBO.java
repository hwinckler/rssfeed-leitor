package rssfeedleitor.bo;

import java.util.Date;

import rssfeedleitor.model.Channel;

public interface RSSFeedBO {

	Channel parse(String link) throws Exception;

	Channel parse(String link, Date pubDate) throws Exception;
}
