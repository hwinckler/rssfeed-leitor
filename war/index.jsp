<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>RSSFeed-Leitor</title>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/normalize.css" rel="stylesheet" media="screen">

</head>
<body>
  <div class="container">

	<c:import url="commons/header.jsp?opt=index" />

    <div class="row">
      <div class="col-md-4">
        <div class="list-group">
  			<c:forEach var="category" items="${categories}" varStatus="status">
            	<a href="index?act=select_category&category_id=${category.id}" class="list-group-item ${category.id == categoryID ? 'active' : ''}">${category.title} <span class="badge">14</span></a>
  			</c:forEach>
        </div>
      </div>
      <div class="col-md-8">

        <div class="list-group">
        	<c:forEach var="feed" items="${feeds}">
	          <a href="#" class="list-group-item">
	            <h4 class="list-group-item-heading">${feed.title}</h4>
	            <p class="list-group-item-text">${feed.link}</p>
	          </a>        	
        	</c:forEach>
        </div>
      </div>
    </div>


	<br>
	${erro}


  </div> <!-- /container -->



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
