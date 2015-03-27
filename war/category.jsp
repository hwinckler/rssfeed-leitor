<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>RSSFeed-Leitor</title>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/normalize.css" rel="stylesheet" media="screen">

</head>
<body>
  <div class="container">

	<c:import url="commons/header.jsp?opt=category" />
    
    
    <ol class="breadcrumb">
      <li><a href="index">Home</a></li>
      <li class="active">Categories</li>
    </ol>
    <form action="category" method="post">
      <div class="form-group">
        <label for="category">Category</label>
        <input type="hidden" id="id" name="id" value="${category.id}">
        <input type="hidden" id="act" name="act" value="add">
        <input type="text" class="form-control" id="title" name="title" placeholder="Java" value="${category.title}">
      </div>
      <button type="submit" class="btn btn-primary">add</button>
    </form>
    <br>
    <ul class="list-group">

		<c:forEach var="category" items="${categories}">
		
	      <li class="list-group-item"><a href="">${category.title}</a>
	
	        <p class="navbar-right">
	          <a href="category?act=del&id=${category.id}"><span class="glyphicon glyphicon-trash">&nbsp;</span></a>
	        </p>
	
	      </li>	
	
		</c:forEach>

    </ul>


  </div> <!-- /container -->



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>