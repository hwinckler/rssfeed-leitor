package rssfeedleitor.dao.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import rssfeedleitor.model.test.RSSFeedParserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	CategoryDAOTest.class,
	ChannelDAOTest.class,
	FeedDAOTest.class,
	RSSFeedParserTest.class
})
public class AllTests {


}
