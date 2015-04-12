package rssfeedleitor.guice;

import rssfeedleitor.controller.AboutController;
import rssfeedleitor.controller.CategoryController;
import rssfeedleitor.controller.ChannelController;
import rssfeedleitor.controller.FeedController;
import rssfeedleitor.controller.HelloController;
import rssfeedleitor.controller.IndexController;
import rssfeedleitor.filter.UserFilter;

import com.google.inject.servlet.ServletModule;

class MyServletModule extends ServletModule {
	
	  protected void configureServlets() {
		  filter("/*").through(UserFilter.class);
		  serve("/hello").with(HelloController.class);
		  serve("/about").with(AboutController.class);
		  serve("/category").with(CategoryController.class);
		  serve("/feed").with(FeedController.class);
		  serve("/channel").with(ChannelController.class);
		  serve("/").with(IndexController.class);
		  serve("/index").with(IndexController.class);
	  }
}
