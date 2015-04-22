package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import rssfeedleitor.category.test.CategoryFeedTest;
import rssfeedleitor.category.test.CategoryTest;
import rssfeedleitor.channel.test.ChannelLastPubDateTest;
import rssfeedleitor.channel.test.ChannelTest;
import rssfeedleitor.feed.test.FeedMarkAsReadTest;
import rssfeedleitor.feed.test.FeedTest;
import rssfeedleitor.model.test.RSSFeedParserTest;
import rssfeedleitor.user.test.UserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	UserTest.class,
	CategoryTest.class,
	CategoryFeedTest.class,
	ChannelTest.class,
	ChannelLastPubDateTest.class,
	FeedTest.class,
	FeedMarkAsReadTest.class,
	RSSFeedParserTest.class
})
public class AllTests {


}
