package rssfeedleitor.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.bo.RSSFeedBO;

@Singleton
public class ChannelController extends ServletController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChannelController.class);
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private ChannelBO channelBO;
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("index()...");
	
		forward("/index.jsp", request, response);
		
	}
	
	public void synchronize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("synchronize()...");
		
		try{
		
			Integer countUnRead = channelBO.synchronize();
			
			response.getOutputStream().print(countUnRead);
			
		}
		catch(Exception e){
			logger.error("synchronize", e);

			printStackTraceToString(e, request);
		}
		
	}

}
