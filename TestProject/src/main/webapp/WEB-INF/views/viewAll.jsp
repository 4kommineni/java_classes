<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>S.NO.</th>
				<th>firstname</th>
				<th>lname</th>
				<th>email</th>
				<th>password</th>
				<th>age</th>

			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${allEmps}" var="emp" varStatus="i" >
				<tr>
					<td>${i.count}</td>
					<td>${emp.getFirst_name()}</td>
					<td>${emp.getLast_name()}</td>
					<td>${emp.getEmail()}</td>
					<td>${emp.getPassword()}</td>
					<td>${emp.getAge()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="logout">Logout Here</a>
</body>
</html>