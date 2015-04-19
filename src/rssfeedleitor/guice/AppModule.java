package rssfeedleitor.guice;

import org.apache.ibatis.session.SqlSessionFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.bo.FeedBO;
import rssfeedleitor.bo.RSSFeedBO;
import rssfeedleitor.bo.UserBO;
import rssfeedleitor.bo.impl.CategoryBOImpl;
import rssfeedleitor.bo.impl.ChannelBOImpl;
import rssfeedleitor.bo.impl.FeedBOImpl;
import rssfeedleitor.bo.impl.RSSFeedBOImpl;
import rssfeedleitor.bo.impl.UserBOImpl;
import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.dao.UserDAO;
import rssfeedleitor.dao.factory.SqlSessionFactoryProvider;
import rssfeedleitor.dao.impl.CategoryDAOImpl;
import rssfeedleitor.dao.impl.ChannelDAOImpl;
import rssfeedleitor.dao.impl.FeedDAOImpl;
import rssfeedleitor.dao.impl.UserDAOImpl;
import rssfeedleitor.reader.RSSFeed;
import rssfeedleitor.reader.RSSFeedParser;
import rssfeedleitor.reader.RSSFeedParserRome;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
	
	  protected void configure() {
		  
		  bind(CategoryDAO.class).to(CategoryDAOImpl.class);
		  bind(CategoryBO.class).to(CategoryBOImpl.class);
		  
		  bind(ChannelDAO.class).to(ChannelDAOImpl.class);
		  bind(ChannelBO.class).to(ChannelBOImpl.class);
		  
		  bind(FeedDAO.class).to(FeedDAOImpl.class);
		  bind(FeedBO.class).to(FeedBOImpl.class);
		  
		  bind(RSSFeed.class).to(RSSFeedParserRome.class);
		  bind(RSSFeedBO.class).to(RSSFeedBOImpl.class);
		  
		  bind(UserDAO.class).to(UserDAOImpl.class);
		  bind(UserBO.class).to(UserBOImpl.class);
		  
		  bind(SqlSessionFactory.class).toProvider(SqlSessionFactoryProvider.class);
	  }
}
