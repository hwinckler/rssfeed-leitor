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
import rssfeedleitor.model.Category;

@Singleton
public class CategoryController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
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
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.debug("action()...");
		
		String erro = "Erro: <br>";
		
		try{
			
			String act = ((request.getParameter("act") != null) ? request.getParameter("act") : "");
			//TODO fix
//			if(act.isEmpty()){
//				throw new Exception("No action found!");
//			}
			
			String title = ((request.getParameter("title") != null) ? request.getParameter("title") : "");
			Integer id = ((request.getParameter("id") != null && !request.getParameter("id").isEmpty()) ? Integer.valueOf(request.getParameter("id")) : 0);
			
			logger.debug("act = " + act);
			logger.debug("title = " + title);
			logger.debug("id = " + id);
			
			Category category = null;
			
			if(act.equals("insert")){
				categoryBO.insert(title);
			}
			else if(act.equals("delete")){
				categoryBO.delete(id);
			}
			else if(act.equals("update")){
				categoryBO.update(id, title);
			}
			else if(act.equals("select")){
				category = categoryBO.findById(id);
			}
				
			request.setAttribute("category", category);
			
		}
		catch(Exception e){
			logger.error("action", e);
			
			erro += e.getMessage() + "<br>";
			
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			erro += errors.toString();
			
		}
		
		List<Category> categories = categoryBO.findAll();
		if(categories == null){
			categories = Collections.emptyList();
		}
		
		request.setAttribute("categories", categories);
		request.setAttribute("erro", erro);
	
		logger.debug("dispatcher()...");
		
		request.getRequestDispatcher("/category.jsp").forward(request, response);
		
	}

}
