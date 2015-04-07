package rssfeedleitor.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.FeedBO;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Feed;

@Singleton
public class IndexController extends ServletController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CategoryBO categoryBO;
	
	@Inject
	private FeedBO feedBO;
	
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("index()...");
		
		List<Category> categories = null;
		
		try{
			
//			Thread newThread = com.google.appengine.api.ThreadManager.createThreadForCurrentRequest(new Runnable() {
//				
//				@Override
//				public void run() {
//					try {
//					      while (true) {
//					        System.out.println("aaaaaaaaaaaaaa");
//					        Thread.sleep(30000);
//					      }
//					    } catch (InterruptedException ex) {
//					      throw new RuntimeException("Interrupted in loop:", ex);
//					    }
//					
//				}
//			});
//			
//			newThread.start();
			
			categories = categoryBO.findAllWithUnRead();
			
		}
		catch(Exception e){
			logger.error("index", e);
			
			printStackTraceToString(e, request);
		}
		
		if(categories == null)
			categories = Collections.emptyList();
		
		request.setAttribute("categories", categories);
	
		forward("/index.jsp", request, response);
		
	}
	
	public void feedList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("feedList()...");
		
		List<Feed> feeds = Collections.emptyList();
		
		Integer categoryID = null;
		
		try{
			
			categoryID = ((request.getParameter("categoryID") != null && !request.getParameter("categoryID").isEmpty()) ? Integer.valueOf(request.getParameter("categoryID")) : 0);
			
			logger.debug("categoryID = " + categoryID);
			
			feeds = feedBO.findByCategory(categoryID);
			
		}
		catch(Exception e){
			logger.error("feedList", e);

			printStackTraceToString(e, request);
		}
		
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("feeds", feeds);
		
		forward("/feedList.jsp", request, response);

	}
	
	public void markAsRead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("markAsRead()...");
		
		try{
			
			Integer feedID = ((request.getParameter("feedID") != null && !request.getParameter("feedID").isEmpty()) ? Integer.valueOf(request.getParameter("feedID")) : 0);
			
			logger.debug("feedID = " + feedID);
			
			feedBO.markAsRead(feedID);
			
		}
		catch(Exception e){
			logger.error("markAsRead", e);

			printStackTraceToString(e, request);
		}
	
	}
	
	public void markAllAsRead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("markAllAsRead()...");
		
		try{
			
			Integer categoryID = ((request.getParameter("categoryID") != null && !request.getParameter("categoryID").isEmpty()) ? Integer.valueOf(request.getParameter("categoryID")) : 0);
			
			logger.debug("categoryID = " + categoryID);
			
			feedBO.markAllAsRead(categoryID);
			
		}
		catch(Exception e){
			logger.error("markAllAsRead", e);

			printStackTraceToString(e, request);
		}
	
	}
	

}
