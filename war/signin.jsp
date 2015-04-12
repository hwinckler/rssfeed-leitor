<%@page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@page import="com.google.appengine.api.users.UserService"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt_BR">
<head>
  <meta charset="utf-8">
  <title>RSSFeed-Leitor</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/normalize.css" rel="stylesheet" media="screen">
 
</head>
<body>

<%
    UserService userService = UserServiceFactory.getUserService();

	if(userService.getCurrentUser() != null){
		
%>
<script type="text/javascript">
location.href = "index";
</script>
<%
		
	}
%>

  <div class="container">
  
  <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>

	<br>
	${erro}


  </div> <!-- /container -->



	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>
