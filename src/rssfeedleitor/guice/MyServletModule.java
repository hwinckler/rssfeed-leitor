package rssfeedleitor.guice;

import rssfeedleitor.controller.HelloController;

import com.google.inject.servlet.ServletModule;

class MyServletModule extends ServletModule {
	
	  protected void configureServlets() {
		  serve("/hello").with(HelloController.class);
	  }
}
