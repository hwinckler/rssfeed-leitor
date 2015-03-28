<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>RSSFeed-Leitor</title>
  <!-- Bootstrap -->
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/normalize.css" rel="stylesheet" media="screen">
  <script type="text/javascript">
  	function parseFeed(){
  		
  		$('#act').val('parse_feed');
  		$('#form').submit();
  	}
  </script>
</head>
<body>
  <div class="container">

	<c:import url="commons/header.jsp?opt=feed" />
    
    <ol class="breadcrumb">
      <li><a href="index">Home</a></li>
      <li class="active">Feeds</li>
    </ol>
    
    <form action="feed" method="post" id="form">
      <div class="form-group">
        <label for="feed">Feed</label>
        <input type="text" class="form-control" id="link" name="link" placeholder="http://blog.caelum.com.br/feed/" value="${channel.link}" onchange="parseFeed();">
        
        <label for="feed">Title</label>
        <input type="text" class="form-control" id="title" name="title" value="${channel.title}" disabled="disabled">
        
        <label for="feed">Description</label>
        <input type="text" class="form-control" id="description" name="description" value="${channel.title}" disabled="disabled">
                        
        <label class="control-label" for="category">Category</label>
        <select class="form-control" id="category" onchange="feed?act=select_category;">
        	<option></option>
        	<c:forEach var="category" items="${categories}">
          		<option value="${category.id}">${category.title}</option>
          	</c:forEach>
        </select>
      </div>

		<input type="hidden" id="id" name="id" value="${channel.id}">
		<input type="hidden" id="act" name="act" value="${empty channel ? 'insert' : 'update'}">

      <button type="submit" class="btn btn-primary">add</button>
     </form>
    <br>
    <ul class="list-group">
    
    	<c:forEach var="feed" items="${feeds}">
	      <li class="list-group-item"><a href="">${feed.link}</a>
	
	        <p class="navbar-right">
	          <a href=""><span class="glyphicon glyphicon-trash">&nbsp;</span></a>
	        </p>
	
	      </li>    	
    	</c:forEach>

    </ul>

	<br>
	${erro}

  </div> <!-- /container -->



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>
</html>
