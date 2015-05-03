package rssfeedleitor.filter;

import java.io.IOException;

import javax.inject.Singleton;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;


@Singleton
public class UserFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(UserFilter.class);

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		logger.debug("doFilter()...");
		
		HttpServletRequest req = (HttpServletRequest) request;
		String requestURI = req.getRequestURI();
		HttpSession session = req.getSession();
		
		rssfeedleitor.user.model.User user = (rssfeedleitor.user.model.User) session.getAttribute("user"); 

		logger.debug("user authenticate: " + UserServiceFactory.getUserService().getCurrentUser());
		
		if(user == null && (!requestURI.contains("signin.jsp") && !requestURI.contains("about.jsp") && !requestURI.contains("login") && !requestURI.contains("logout") && !requestURI.contains("oauth2callback"))){
			HttpServletResponse res = (HttpServletResponse) response;
			logger.debug("redirect login.jsp...");
			res.sendRedirect("signin.jsp");
			return;
		}
		
		logger.debug("user: " + ((user != null) ? user.getEmail() : ""));
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
