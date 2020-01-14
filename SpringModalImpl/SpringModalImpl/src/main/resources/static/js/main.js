$(document).ready(function() {
	$('.table .edit').on('click', function(event) {
		event.preventDefault();

		var href = $(this).attr('href');

		$.get(href, function(coun, status) {
            $('#ids').val(coun.id);
            $('#names').val(coun.name);
            $('#capitals').val(coun.capital);
		});

		$("#editModal").modal();
	});
	
	
	$('.table .delete').on('click',function(event){
		event.preventDefault();
		var href=$(this).attr('href');
		$('#deleteModal #deleteButton').attr('href',href);
		$('#deleteModal').modal();
	});
});