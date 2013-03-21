<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Add Book - Worblehat Bookmanager</title>
</head>
<body>

<div style="width: 200px; float: left;">
<b>Users</b>
	<ul style="list-style-type:none; 
	margin-left:20px; 
	color : #000000;
	background-color: #FFFFFF;
	font-weight: normal;
	vertical-align: top;" >
<li style="padding-left: 10px"><a href="<spring:url value="/bookList" htmlEscape="true" />" >List all Books</a></li>
   <li style="padding-left: 10px"><a href="<spring:url value="/borrow" htmlEscape="true" />" >Borrow Book</a></li>
   <li style="padding-left: 10px"><a id="returnAllBooks" href="<spring:url value="/returnAllBooks" htmlEscape="true" />" >Return all Books</a></li>
    <li style="padding-left: 10px"><a href="<spring:url value="/showBorrowedBooks" htmlEscape="true" />">Show borrowed Books</a></li>  
   </ul>
  <b>Administrators</b>
  <ul style="list-style-type:none; 
	margin-left:20px; 
	color : #000000;
	background-color: #FFFFFF;
	font-weight: normal;
	vertical-align: top;" >
  <li style="padding-left: 10px"><a href="<spring:url value="/insertBooks" htmlEscape="true" />" >Add a new book</a></li>
   <!-- <li><a href="<spring:url value="/showBorrowedBooks" htmlEscape="true" />">Show borrowed Books</a></li>  -->
</ul> </p>
</div><div>
	<h1>Add A New Book</h1>

	<form:form commandName="bookDataFormData" method="POST">
	
	<table>
		<tr>
		<td>Title</td>
		<td><form:input id="title" path="title" />
		</td>
		<td><form:errors path="title" /></td>
		</tr>
		
		<tr>
		<td>Author</td>
		<td><form:input id="author" path="author" /></td>
		<td><form:errors path="author" /></td>
		</tr>
		
		<tr>
		<td>Year</td>
		<td><form:input id="year" path="year" size="4"/></td>
		<td><form:errors path="year" /></td>
		</tr>
		
		<tr>
		<td>Edition</td>
		<td><form:input id="edition" path="edition" />
		</td>
		<td><form:errors path="edition" /> </td>
		</tr>
		
		<tr>
		<td>ISBN</td>
		<td><form:input id="isbn" path="isbn" /></td>
		<td><form:errors path="isbn" /></td>
		</tr>
		

		<tr>
		<td>Description</td>
		<td> <form:textarea id="description" path="description" cols="40" rows="10" /></td>
		<td><form:errors path="description" /></td>
		</tr>
		<tr>
		<td colspan="2">
			<input type="submit" id="addBook" value="Add Book" /></td>
		</tr>
	</table>
           
		
		<hr/>
		<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
	</form:form>
	
</div>
</body>
</html>
