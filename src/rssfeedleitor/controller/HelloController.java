package rssfeedleitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rssfeedleitor.dao.CategoryDAO;
import rssfeedleitor.model.Category;

@Singleton
public class HelloController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@Inject
	private CategoryDAO categoryDAO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String texto = "Saida: \n";
		
		try{
			
			List<Category> list = categoryDAO.findAll();
			for (Category category : list) {
				texto += category.getTitle() + " \n" ;
			}
			
		}
		catch(Exception e){
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			texto += errors.toString();
		}
	
		response.getOutputStream().print(texto);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

}
