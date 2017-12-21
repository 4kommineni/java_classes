<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
</head>
<body>

	<sf:form action="regSubmit" method="post" commandName="reg">
		<label class="text-danger text-center">${regError}</label>
		<sf:errors path="*" class="form-control text-danger" />

		<div class="form-group">
			<label for="first_name">First Name:</label>
			<sf:input path="first_name" type="text" class="form-control"
				placeholder="Enter First Name" />
			<sf:errors path="first_name" class="form-control text-danger" />
		</div>

		<div class="form-group">
			<label for="last_name">Last Name:</label>
			<sf:input path="last_name" class="form-control"
				placeholder="Enter Last Name" />
			<sf:errors path="last_name" class="form-control text-danger" />
		</div>

		<div class="form-group">
			<label for="email">Email Id:</label>
			<sf:input path="email" type="email" class="form-control"
				placeholder="Enter Email" />
			<sf:errors path="email" class="form-control text-danger" />
		</div>

		<div class="form-group">
			<label for="password">Password:</label>
			<sf:password path="password" class="form-control"
				placeholder="Enter Password" />
			<sf:errors path="password" class="form-control text-danger" />
		</div>

		<div class="form-group">
			<label for="repassword">Re-Enter-Password:</label> <input
				name="repassword" id="repassword" class="form-control"
				placeholder="Re-Enter Password" />
		</div>

		<div class="form-group">
			<label for="age">Age:</label>
			<sf:input path="age" type="number" class="form-control"
				placeholder="Enter Age" />
			<sf:errors path="age" class="form-control text-danger" />
		</div>

		<sf:button class="btn btn-primary">Register</sf:button>

	</sf:form>

</body>
</html>