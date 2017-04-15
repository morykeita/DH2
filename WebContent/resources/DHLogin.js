/**
 * 
 */

//This simply runs the code inside when the document (page) is ready
$(document)
		.ready(
				function() {
				//THis pulls up the modal and makes it so you cant leave it (in this case it shows up immideately when you get to the page)
					$('#loginModal').modal({backdrop: 'static', keyboard: true, show:true});
				});