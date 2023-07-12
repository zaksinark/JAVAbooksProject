<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<h1>Welcome <c:out value="${user.userName}"/></h1>
	<a href="/logout" class="btn btn-outline-danger">Log Out</a>
	<a href="/create" class="btn btn-outline-primary">add a Book</a>
	<table>
	    <thead> 
	        <tr> 
	            <th>ID</th>
	            <th>Title</th>
	            <th>Author</th>
	            <th>Posted By</th>
	        </tr>
	    </thead>
    	<tbody>
        <c:forEach var="eachBook" items="${allBooks}"> 
            <tr>
                <td><c:out value="${eachBook.id}"/></td>
                <td><a href="/${eachBook.id}"><c:out value="${eachBook.title}"/></a></td>
                <td><c:out value="${eachBook.author}"/></td>
                <td><c:out value="${eachBook.user.userName}"/></td>
            </tr>
        </c:forEach>
    	</tbody>
    </table>
</body>
</html>