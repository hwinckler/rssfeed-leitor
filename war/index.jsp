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
  
  	var loading = '<img src=\"img/ajax-loader.gif\" class=\"loading\" />'
  
  	function init(){
  		
		$('.category').click(function(event) {
			
			$('.category').removeClass('active');
			
			$(this).addClass('active')
		    feedList($(this).find('#cat_id').text());
		    
		    
		});
		
		var categoryID = $('.categories a:first-child').attr('id');
		
		feedList(categoryID);
  	}
  	
  	function feedList(categoryID){
  		
  		$.ajax({
  		    url : 'index',
  		    type : 'POST',
  		    data : {
  		        'act' : 'feedList',
  		      	'categoryID' : categoryID
  		    },
  		    success : function(data) {              
  		        $('#feed_content').html(data);
  		        
  				$('.feed').click(function(event) {
  					
  					$(this).removeClass('list-group-item-info');
  					
  					var link = $(this).find('#link').text();
  					var feedID = $(this).find('#feed_id').text();
  					
  					window.open(link, '_blank');
  					
  					markAsRead(feedID);
  				    
  				});
  		    },
  		  	beforeSend: function(){
  				$('#feed_content').html(loading);
  			},
  		});
  		
  	}
  	
  	function markAsRead(feedID){
  		
  		$.ajax({
  		    url : 'index',
  		    type : 'POST',
  		    data : {
  		        'act' : 'markAsRead',
  		      	'feedID' : feedID
  		    },
  		    success : function(data) {              

  		    },
  		});
  		
  	}
 	
  </script>
</head>
<body>
  <div class="container">
  
	<c:import url="commons/header.jsp?opt=index" />

    <div class="row">
      <div class="col-md-4">
        <div class="list-group categories" id="99">
  			<c:forEach var="category" items="${categories}" varStatus="status">
            	<a href="#" class="list-group-item ${status.first ? 'active' : '' } category" id="${category.id}">${category.title} <span class="badge">14</span><span id="cat_id" style="display: none;">${category.id}</span></a>
  			</c:forEach>
        </div>
      </div>
      
      <div class="col-md-8" id="feed_content">
		<img src="img/ajax-loader.gif" class="loading" />
      </div>
    </div>


	<br>
	${erro}


  </div> <!-- /container -->



	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			init();
		});
	</script>
</body>
</html>
