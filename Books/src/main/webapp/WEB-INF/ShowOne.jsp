<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${book.title}"/></h1>
	<h3><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/></h3>
	<h5>Here are <c:out value="${book.user.userName}"/> thoughts:</h5>
	<p><c:out value="${book.ideas}"/>
	<div>
		<a href="/edit/${book.id}">Edit</a>
	    <form action="${book.id}" method="post">
	    	<input type="hidden" name="_method" value="delete"/>
	    	<input type="submit" value="delete" class="btn btn-outline-white btn-danger"/>
	   	</form>
   	</div>
</body>
</html>