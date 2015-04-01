function init() {

	
	$('.btn-clear').click(function(event) {
		$('.btn-add').text('add');
		$('form').trigger('reset');
	});
	
	categoryList();
}

function categoryList() {

	$.ajax({
		url : 'feed',
		type : 'POST',
		data : {
			'act' : 'categorySelectList'
		},
		success : function(data) {
			$('#category_content').html(data);
			
			var categoryID = $('#category option:selected').val();
			channelListByCategory(categoryID);
			
		},
		beforeSend : function() {
			$('#category_content').html(loading);
		},
	});

}

function channelListByCategory(categoryID) {

	$.ajax({
		url : 'feed',
		type : 'POST',
		data : {
			'act' : 'channelListByCategory',
			'categoryID' : categoryID
		},
		success : function(data) {
			$('#channel_content').html(data);
			
			
		},
		beforeSend : function() {
			$('#channel_content').html(loading);
		},
	});

}
