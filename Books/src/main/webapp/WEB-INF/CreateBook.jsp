<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add A Book To Your Shelf</h1>
	<a href="/home">Back to the Shelves</a>
    <form:form action="/process/create" modelAttribute="book" method="post">
        <form:input type="hidden" path="user" value="${user_id}"/>
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
        <input type="submit" value="add book" class="btn btn-outline-success"/>
     </form:form>
</body>
</html>