package rssfeedleitor.guice;

import rssfeedleitor.controller.CategoryController;
import rssfeedleitor.controller.FeedController;
import rssfeedleitor.controller.HelloController;
import rssfeedleitor.controller.IndexController;

import com.google.inject.servlet.ServletModule;

class MyServletModule extends ServletModule {
	
	  protected void configureServlets() {
		  serve("/hello").with(HelloController.class);
		  serve("/category").with(CategoryController.class);
		  serve("/feed").with(FeedController.class);
		  serve("/").with(IndexController.class);
		  serve("/index").with(IndexController.class);
	  }
}
