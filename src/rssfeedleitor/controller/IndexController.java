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
import rssfeedleitor.bo.FeedBO;
import rssfeedleitor.model.Category;
import rssfeedleitor.model.Feed;

@Singleton
public class IndexController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CategoryBO categoryBO;
	
	@Inject
	private FeedBO feedBO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet()...");
		action(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost()...");
		action(request, response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("action()...");
		
		List<Category> categories = Collections.emptyList();
		List<Feed> feeds = Collections.emptyList();
		
		String erro = "Erro: <br>";
		Integer categoryID = null;
		
		try{
			
			String act = ((request.getParameter("act") != null) ? request.getParameter("act") : "");
			//TODO fix
//			if(act.isEmpty()){
//				throw new Exception("No action found!");
//			}
			
			categoryID = ((request.getParameter("category_id") != null && !request.getParameter("category_id").isEmpty()) ? Integer.valueOf(request.getParameter("category_id")) : 0);
			
			logger.debug("act = " + act);
			logger.debug("categoryID = " + categoryID);
			
			categories = categoryBO.findAll();
			if(categoryID == 0 && (categories != null && !categories.isEmpty())){
				categoryID = categories.get(0).getId();
			}
			
			if(act.equals("select_category")){
				feeds = feedBO.findByCategory(categoryID);
			}
			
		}
		catch(Exception e){
			logger.error("action", e);
			
			erro += e.getMessage() + "<br>";
			
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			erro += errors.toString();
		}
	
		request.setAttribute("erro", erro);
		
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("categories", categories);
		request.setAttribute("feeds", feeds);
	
		logger.debug("dispatcher()...");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	

}
