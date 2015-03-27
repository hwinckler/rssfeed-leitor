package rssfeedleitor.controller;

import java.io.IOException;
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
import rssfeedleitor.model.Category;

@Singleton
public class IndexController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CategoryBO categoryBO;
	
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
		
		try{
			
			categories = categoryBO.findAll();
			
		}
		catch(Exception e){
			logger.error("doGet", e);
		}
	
		request.setAttribute("categories", categories);
	
		logger.debug("dispatcher()...");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	

}
