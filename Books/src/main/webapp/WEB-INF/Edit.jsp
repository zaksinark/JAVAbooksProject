<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.2/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Change Your Entry</h1>
	<a href="/home">Back to the Shelves</a>
    <form:form action="/process/${book.id}" modelAttribute="book" method="post">
    	<input type="hidden" name="_method" value="put"/>
        <form:hidden path="user"/>
        <div>
            <label>Title</label>
            <form:input type="text" path="title"/>
            <form:errors path="title"/>
        </div>
        <div>
            <label>Author</label>
            <form:input type="text" path="author"/>
            <form:errors path="author"/>
        </div>
        <div>
            <label>My Thoughts</label>
            <form:input type="text" path="ideas"/>
            <form:errors path="ideas"/>
        </div>
        <input type="submit" value="Edit Book" class="btn btn-outline-success"/>
        </form:form>
</body>
</html>