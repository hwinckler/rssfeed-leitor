package rssfeedleitor.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rssfeedleitor.user.bo.UserBO;
import rssfeedleitor.user.model.User;

import com.google.appengine.api.users.UserServiceFactory;

@Singleton
public class ServletController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(ServletController.class);
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UserBO userBO;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet()...");
		doAction(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost()...");
		doAction(request, response);
	}
	
	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doAction()...");
		
		String act = (request.getParameter("act") == null || request.getParameter("act").isEmpty()) ? "index" : request.getParameter("act");

		logger.debug("act: " + act);
		
		try{
			this.getClass().getMethod(act, HttpServletRequest.class, HttpServletResponse.class).invoke(this, request, response); 
		}
		catch(Exception e){
			logger.error("doAction", e);
		}
		
	}
	
	protected void forward(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("forward()...");
		
		getServletContext().getRequestDispatcher("/pages" + path).forward(request,response);
	} 

	protected void printStackTraceToString(Exception e, HttpServletRequest request) throws ServletException, IOException {
		logger.debug("printStackTraceToString()...");
		
		String erro = "Erro: <br> " + e.getMessage() + "<br>";
		
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		erro += errors.toString();
		
		request.setAttribute("erro", erro);
	}
	
	public User getUserLogged(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		User user = null;
	
		com.google.appengine.api.users.User currentUser = UserServiceFactory.getUserService().getCurrentUser();
		if(currentUser == null){
			forward("/signin.jsp", request, response);
		}
		else{
			try {
				user = userBO.createsNotExist(new User(currentUser.getEmail()));
				
			} catch (Exception e) {
				logger.error("getUserLogged", e);
				throw new ServletException(e.getMessage());
			}
		}
			
		return user;
	}
}
