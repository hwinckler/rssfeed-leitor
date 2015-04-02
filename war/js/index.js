function init() {

	$('.lnk-category').click(function(event) {

		$('.lnk-category').removeClass('active');

		$(this).addClass('active')
		feedList($(this).find('#cat_id').text());

	});

	var categoryID = $('.categories a:first-child').attr('id');

	feedList(categoryID);
}

function feedList(categoryID) {

	$.ajax({
		url : 'index',
		type : 'POST',
		data : {
			'act' : 'feedList',
			'categoryID' : categoryID
		},
		success : function(data) {
			$('#feed_content').html(data);

			$('.lnk-feed').click(function(event) {

				$(this).removeClass('list-group-item-info');

				var link = $(this).find('#link').text();
				var feedID = $(this).find('#feed_id').text();

				window.open(link, '_blank');

				markAsRead(feedID);

			});
		},
		beforeSend : function() {
			$('#feed_content').html(loading);
		},
	});

}

function markAsRead(feedID) {

	$.ajax({
		url : 'index',
		type : 'POST',
		data : {
			'act' : 'markAsRead',
			'feedID' : feedID
		},
		success : function(data) {

			var categoryID = $('.lnk-category active').attr('id');
			alert('categoryID: ' + categoryID);
		},
	});

}
