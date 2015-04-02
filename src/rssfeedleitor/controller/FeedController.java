package rssfeedleitor.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.bo.RSSFeedBO;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@Singleton
public class FeedController extends ServletController {
	
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CategoryBO categoryBO;
	
	@Inject
	private RSSFeedBO rssFeedBO;
	
	@Inject
	private ChannelBO channelBO;
	
	
	public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("index()...");
	
		forward("/feed.jsp", request, response);
		
	}
	
	public void categorySelectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("categorySelectList()...");
		
		List<Category> categories = null;
		
		try{
			
			categories = categoryBO.findAll();
			
		}
		catch(Exception e){
			logger.error("categorySelectList", e);
			
			printStackTraceToString(e, request);
			
		}
		
		if(categories == null){
			categories = Collections.emptyList();
		}
		
		request.setAttribute("categories", categories);
	
		forward("/categorySelectList.jsp", request, response);
		
	}
	
	public void channelListByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("channelList()...");
		
		List<Channel> channels = null;
		
		try{
			
			Integer categoryID = ((request.getParameter("categoryID") != null && !request.getParameter("categoryID").isEmpty()) ? Integer.valueOf(request.getParameter("categoryID")) : Category.DEFAULT_ID);
			
			logger.debug("categoryID = " + categoryID);
			
			channels = channelBO.findByCategory(categoryID);
			
		}
		catch(Exception e){
			logger.error("channelList", e);
			
			printStackTraceToString(e, request);
			
		}
		
		if(channels == null){
			channels = Collections.emptyList();
		}
		
		request.setAttribute("channels", channels);
	
		forward("/channelList.jsp", request, response);
		
	}
	
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("delete()...");
		
		try{
			
			Integer id = ((request.getParameter("id") != null && !request.getParameter("id").isEmpty()) ? Integer.valueOf(request.getParameter("id")) : 0);
			
			logger.debug("id = " + id);
			
			channelBO.delete(id);
			
		}
		catch(Exception e){
			logger.error("delete", e);
			
			printStackTraceToString(e, request);
			
		}
	
	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("insert()...");
		
		try{
			
			String link = ((request.getParameter("link") != null) ? request.getParameter("link") : "");
			Integer categoryID = ((request.getParameter("categoryID") != null && !request.getParameter("categoryID").isEmpty()) ? Integer.valueOf(request.getParameter("categoryID")) : Category.DEFAULT_ID);
			
			logger.debug("link = " + link);
			logger.debug("categoryID = " + categoryID);
			
			channelBO.insert(link, categoryID);
			
		}
		catch(Exception e){
			logger.error("insert", e);
			
			printStackTraceToString(e, request);
			
		}
	
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("update()...");
		
		try{
			
			Integer id = ((request.getParameter("id") != null && !request.getParameter("id").isEmpty()) ? Integer.valueOf(request.getParameter("id")) : 0);
			Integer categoryID = ((request.getParameter("categoryID") != null && !request.getParameter("categoryID").isEmpty()) ? Integer.valueOf(request.getParameter("categoryID")) : Category.DEFAULT_ID);
			
			logger.debug("id = " + id);
			logger.debug("categoryID = " + categoryID);
			
			channelBO.update(id, categoryID);
			
		}
		catch(Exception e){
			logger.error("update", e);
			
			printStackTraceToString(e, request);
			
		}
	
	}

	public void parse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("parse()...");
		
		Channel channel = null;
		
		try{
			
			String link = ((request.getParameter("link") != null) ? request.getParameter("link") : "");
			
			logger.debug("link = " + link);
			
			channel = rssFeedBO.parse(link);
			
		}
		catch(Exception e){
			logger.error("parse", e);
			
			printStackTraceToString(e, request);
			
		}
		
		JSONObject json = new JSONObject();
		
		try {
			
			json.put("link", (channel != null) ? channel.getLink() : "");
			json.put("title", (channel != null) ? channel.getTitle() : "");
			json.put("description", (channel != null) ? channel.getDescription() : "");
			
		} catch (JSONException e) {
			logger.error("json.put", e);
		}
		
		response.getOutputStream().print(json.toString());
	
	}

}
