/**
 * 
 */

//This is an event that happens when you click on another tab on the dashboard
$(document).on("click",".sidebar-toggle",function(){
    $(".wrapper").toggleClass("toggled");
    console.log("clicked");
});

$(document).on("click","#editSettingsButton",function(){
	$('#settingsModal').modal({backdrop: 'static', keyboard: true, show:true});
    console.log("clicked");
});

$(document).on("click","#logout",function(){
	console.log($("#logout").val().currentUser);
	$("#logout").val().invalidate();
    console.log("Logout clicked");
    console.log($("#logout").val().currentUser);
});

$(document)
.ready(
		function() {
			document.getElementById("saveSettingsButton").addEventListener(
					"click", updateProfile, true);
		});

function Users(pFirstName, pLastName, pUserName, pPassword,
		pEmail, pPhone) {

	this.firstName = pFirstName;
	this.lastName = pLastName;
	this.userName = pUserName;
	this.password = pPassword;
	this.email = pEmail;
	this.phone = pPhone;
};

function updateProfile() {
	
	console.log("Save Profile Button Clicked");

	$.ajax({
		cache : false,
		url : "home/updateUser",
		type : "GET",
		data : {
			"fname": $("#editFirstName").val(), 
			"lname": $("#editLastName").val(), 
			"uname": $("#editUserName").val(), 
			"pwd":	 $("#editPassword").val(), 
			"email": $("#editEmail").val(), 
			"phone": $("#editPhone").val()
		},
		success : function(result) {
			console.log("SUCCESS");
		},
		error : function(status) {
			console.log("Ajax error please submit again");
		},
		complete : function(status) {
			console.log("done settings: "+($("#phoneP").text()));
			$("#phoneP").text("Phone#: "+ $("#editPhone").val());
		}
	});

}