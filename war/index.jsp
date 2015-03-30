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
  	function openFeed(id, url){
  		
  		window.open(url, '_blank');
  		
		$('#act').val('mark_visualized');
		$('#feed_id').val(id);
		$('#form').submit();

  	}  	
  </script>
</head>
<body>
  <div class="container">
  
   <form action="index" method="post" id="form">
   		<input type="hidden" id="category_id" name="category_id" value="${categoryID}">
		<input type="hidden" id="feed_id" name="feed_id" value="">
		<input type="hidden" id="act" name="act" value="">   
   </form>

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
	          <a href="#" onclick="openFeed(${feed.id}, '${feed.link}');" class="list-group-item ${feed.visualized ? '' : 'list-group-item-info'}">
	            <h4 class="list-group-item-heading">${feed.title}</h4>
	            <p class="list-group-item-text">${feed.description}</p>
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
