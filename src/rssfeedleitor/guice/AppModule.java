package rssfeedleitor.guice;

import org.apache.ibatis.session.SqlSessionFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.CategoryBOImp;
import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.dao.ChannelDAO;
import rssfeedleitor.dao.FeedDAO;
import rssfeedleitor.dao.factory.SqlSessionFactoryProvider;
import rssfeedleitor.dao.impl.CategoryDAOImpl;
import rssfeedleitor.dao.impl.ChannelDAOImpl;
import rssfeedleitor.dao.impl.FeedDAOImpl;
import rssfeedleitor.reader.RSSFeed;
import rssfeedleitor.reader.RSSFeedParser;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
	
	  protected void configure() {
		  bind(CategoryDAO.class).to(CategoryDAOImpl.class);
		  bind(CategoryBO.class).to(CategoryBOImp.class);
		  
		  bind(ChannelDAO.class).to(ChannelDAOImpl.class);
		  bind(FeedDAO.class).to(FeedDAOImpl.class);
		  bind(RSSFeed.class).to(RSSFeedParser.class);
		  bind(SqlSessionFactory.class).toProvider(SqlSessionFactoryProvider.class);
	  }
}
