<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>RSSFeed-Leitor</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap -->
  <link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="../css/normalize.css" rel="stylesheet" media="screen">

</head>
<body>
  <div class="container">

	<c:import url="header.jsp?opt=about" />

    <ol class="breadcrumb">
      <li><a href="index">Home</a></li>
      <li class="active">About</li>
    </ol>

    <div class="jumbotron">
      <h1>RSSFeed Leitor v.1</h1>
      <p class="navbar-right"><a class="navbar-brand" href="https://github.com/hwinckler/rssfeed-leitor.git" target="_blank">https://github.com/hwinckler/rssfeed-leitor.git</a></p>
    </div>

  </div> <!-- /container -->



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</body>
</html>
