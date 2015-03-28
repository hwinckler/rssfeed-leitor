package rssfeedleitor.bo;

import rssfeedleitor.model.Channel;

public interface RSSFeedBO {

	Channel parse(String link) throws Exception;
}
