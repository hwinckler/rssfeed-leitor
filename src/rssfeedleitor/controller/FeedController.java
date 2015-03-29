package rssfeedleitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.bo.CategoryBO;
import rssfeedleitor.bo.ChannelBO;
import rssfeedleitor.bo.RSSFeedBO;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Channel;

@Singleton
public class FeedController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(FeedController.class);
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CategoryBO categoryBO;
	
	@Inject
	private RSSFeedBO rssFeedBO;
	
	@Inject
	private ChannelBO channelBO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet()...");
		action(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost()...");
		action(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("action()...");
		
		String erro = "Erro: <br>";
	
		try{
			
			String act = ((request.getParameter("act") != null) ? request.getParameter("act") : "");
			//TODO fix
//			if(act.isEmpty()){
//				throw new Exception("No action found!");
//			}
			
			String link = ((request.getParameter("link") != null) ? request.getParameter("link") : "");
			Integer id = ((request.getParameter("id") != null && !request.getParameter("id").isEmpty()) ? Integer.valueOf(request.getParameter("id")) : 0);
			Integer categoryID = ((request.getParameter("category_id") != null && !request.getParameter("category_id").isEmpty()) ? Integer.valueOf(request.getParameter("category_id")) : Category.DEFAULT_ID);
			
			logger.debug("act = " + act);
			logger.debug("link = " + link);
			logger.debug("id = " + id);
			logger.debug("categoryID = " + categoryID);
			
			Channel channel = null;
				
			if(act.equals("parse_feed")){
				channel = rssFeedBO.parse(link);
			}
			else if(act.equals("insert")){
				channelBO.insert(link, categoryID);
			}			
//			else if(act.equals("update")){
//				feedBO.update(id, title);
//			}
			else if(act.equals("select")){
				channel = channelBO.findById(id);
			}
			else if(act.equals("delete")){
				channelBO.delete(id);
			}
			
			List<Channel> channels = channelBO.findByCategory(categoryID);
			if(channels == null){
				channels = Collections.emptyList();
			}
			
			List<Category> categories = categoryBO.findAll();
			if(categories == null){
				categories = Collections.emptyList();
			}
			
			request.setAttribute("link", link);
			request.setAttribute("categoryID", categoryID > 0 ? categoryID : Category.DEFAULT_ID);
			request.setAttribute("channels", channels);
			request.setAttribute("channel", channel);
			request.setAttribute("categories", categories);
			
		}
		catch(Exception e){
			logger.error("action", e);
			
			erro += e.getMessage() + "<br>";
			
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			erro += errors.toString();
			
		}
		
		request.setAttribute("erro", erro);
	
		logger.debug("dispatcher()...");
		
		request.getRequestDispatcher("/feed.jsp").forward(request, response);
		
	}

}
