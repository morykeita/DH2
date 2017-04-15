<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Login</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  --%>

<!-- JQuery, required for parts of Bootstrap that use it -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Alegreya Sans">
<style type="text/css">
body {
	text-align: center;
	font-family: 'Alegreya Sans';
	background-color: #2A3F54;
	background-repeat: no-repeat;
	-webkit-user-select: none;
}

.loginText {
	color: #000000
}

.button {
	padding: 15px 25px;
	font-size: 24px;
	text-align: center;
	cursor: pointer;
	outline: none;
	color: #fff;
	background-color: #543a2a;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
}

.button:hover {
	background-color: #422917
}

.button:active {
	background-color: #422917;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

form {
	text-align: center;
}

/* to prevent closing with the login modal with Esc button or by clicking outside of the modal */
$('#loginModal').modal({
backdrop: 'static', keyboard: false)
})

</style>
</head>
<body>

	<form action=${pageContext.request.contextPath}/DHApp/DHLogin method="POST">
		<!--  This modal is given the Id 'loginModal' and uses the classes 'modal' and 'fade' which makes it a modal and the fade is what makes the modal fade in/out
		  The 'dialog' role is used for people who may be disabled and it allows the modal to be read by the browser for them 
		  Vertical-align and margin-top is for spacing the modal to the roughly the middle of the screen
		  If you wanted a darker background BEHIND the modal, place a background-color field in the style attribute-->
		<div id="loginModal" class="modal fade" role="dialog"
			style="vertical-align: middle; margin-top: 5%;">
			<!-- the modal-xl class is what makes the modal larger. For a smaller login form it isnt needed but is still safe to use as the modal then scales as needed -->
			<div class="modal-dialog modal-xl">
				<!-- Your content goes here. The background color is the color of the modal itself. This Alice Blue is essentially white but has a very soft blue tint -->
				<div class="modal-content" style="background-color: AliceBlue;">
					<!-- If you wanted a modal that can be closed with an 'x' in the top corner, then put this under the header tag (<button type="button" class="close" data-dismiss="modal">&#x274C;</button>) -->
					<div class="modal-header">
						<h1 class="loginText">
							<strong>Welcome to DH2!</strong>
						</h1>
					</div>
					<div id="modal-body" style="text-align: center;">
						<h1 class="loginText">Username</h1>
						<h1>
							<!-- <input type="text" name="uname"> -->
							<input type="text" name="userName" /> <br>
						</h1>
						<br>
						<h1 class="loginText">Password</h1>
						<h1>
							<input type="password" name="password" /> <br>
						</h1>
					</div>
					<div class="modal-footer" style="text-align: center;">
						<input type="hidden" name="ConstantValue" value="example">
						<button class="button">Login</button>
						<br />
					</div>
				</div>
			</div>
		</div>
	</form>

	<script type="text/javascript" src="resources/DHLogin.js"></script>
</body>
</html>