package rssfeedleitor.guice;

import org.apache.ibatis.session.SqlSessionFactory;

import rssfeedleitor.category.bo.CategoryBO;
import rssfeedleitor.category.bo.impl.CategoryBOImpl;
import rssfeedleitor.category.dao.CategoryDAO;
import rssfeedleitor.category.dao.impl.CategoryDAOImpl;
import rssfeedleitor.channel.bo.ChannelBO;
import rssfeedleitor.channel.bo.impl.ChannelBOImpl;
import rssfeedleitor.channel.dao.ChannelDAO;
import rssfeedleitor.channel.dao.impl.ChannelDAOImpl;
import rssfeedleitor.dao.factory.SqlSessionFactoryProvider;
import rssfeedleitor.feed.bo.FeedBO;
import rssfeedleitor.feed.bo.impl.FeedBOImpl;
import rssfeedleitor.feed.dao.FeedDAO;
import rssfeedleitor.feed.dao.impl.FeedDAOImpl;
import rssfeedleitor.reader.RSSFeed;
import rssfeedleitor.reader.RSSFeedParserRome;
import rssfeedleitor.user.bo.UserBO;
import rssfeedleitor.user.bo.impl.UserBOImpl;
import rssfeedleitor.user.dao.UserDAO;
import rssfeedleitor.user.dao.impl.UserDAOImpl;

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
		  
		  bind(UserDAO.class).to(UserDAOImpl.class);
		  bind(UserBO.class).to(UserBOImpl.class);
		  
		  bind(SqlSessionFactory.class).toProvider(SqlSessionFactoryProvider.class);
	  }
}
