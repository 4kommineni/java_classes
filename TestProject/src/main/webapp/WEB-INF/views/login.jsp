<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>
<body>
<form action="loginSubmit" method="post">
    <label class="text-danger text-center">${loginError}</label>
    <label class="text-danger text-center" id="loginError"></label>
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" name="emailid" id="emailid" aria-describedby="emailHelp" placeholder="Enter email" required="required">    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="pswd" id="pswd" placeholder="Password" required="required">
  </div>  
  <div class="form-group">
  <div class="form-check form-check-inline">
  <label class="form-check-label">
    <input class="form-check-input" type="checkbox" name="intr" value="one"> 1
  </label>
</div>
<div class="form-check form-check-inline">
  <label class="form-check-label">
    <input class="form-check-input" type="checkbox" name="intr" value="two"> 2
  </label>
</div>
  </div>  
  <button type="submit" id="getSubmit" class="btn btn-primary">Get Submit</button>
  <button type="button" id="login" class="btn btn-primary">Submit</button>  
  <button type="button" id="path" class="btn btn-warning">Get By PAth</button>
</form>
<script type="text/javascript" src="resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>
</body>
</html>