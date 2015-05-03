package rssfeedleitor.guice;

import rssfeedleitor.category.controller.CategoryController;
import rssfeedleitor.channel.controller.ChannelController;
import rssfeedleitor.controller.AboutController;
import rssfeedleitor.controller.IndexController;
import rssfeedleitor.feed.controller.FeedController;
import rssfeedleitor.filter.UserFilter;
import rssfeedleitor.login.controller.LoginController;
import rssfeedleitor.login.controller.Oauth2Callback;
import rssfeedleitor.logout.controller.LogoutController;

import com.google.inject.servlet.ServletModule;

class MyServletModule extends ServletModule {
	
	  protected void configureServlets() {
		  filter("/*").through(UserFilter.class);
		  serve("/about").with(AboutController.class);
		  serve("/category").with(CategoryController.class);
		  serve("/feed").with(FeedController.class);
		  serve("/channel").with(ChannelController.class);
		  serve("/").with(IndexController.class);
		  serve("/index").with(IndexController.class);
		  serve("/login").with(LoginController.class);
		  serve("/logout").with(LogoutController.class);
		  serve("/oauth2callback").with(Oauth2Callback.class);
	  }
}
