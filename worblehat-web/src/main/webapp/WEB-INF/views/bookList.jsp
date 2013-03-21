<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
	<title>Show all Books</title>
</head>
<body>
<div style="width:200px; float:left;">
<b>Users</b>
	<ul style="list-style-type:none; 
	margin-left:20px; 
	color : #000000;
	background-color: #FFFFFF;
	font-weight: normal;
	vertical-align: top;" >
<li style="padding-left: 10px"><a href="<spring:url value="/bookList" htmlEscape="true" />" >List all Books</a></li>
   <li style="padding-left: 10px"><a href="<spring:url value="/borrow" htmlEscape="true" />" >Borrow Book</a></li>
   <li style="padding-left: 10px"><a id="returnAllBooks" href="<spring:url value="/returnAllBooks" htmlEscape="true" />" >Return all Books</a></li></ul>
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
</div>
<div>
<h1>All Books In The Library</h1>
	<table>
	<thead>  
		<tr style="padding-left:5px; text-align:left">
			<th style="padding-right:20px; width:150px;">Title</th>
			<th style="padding-right:20px; width:100px">Author</th>
			<th style="padding-right:20px; width: 50px">Year</th>
			<th style="padding-right:20px; width:50px">Edition</th>
			<th style="padding-right:20px; width:100px">ISBN</th>
			<th style="padding-right:20px; width:150px">Borrower</th>
			<th style="padding-right:20px; width:100px">Description</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${books}" var="book">
		<tr >
			<td style="">${book.title}</td>
			<td style="">${book.author}</td>
			<td style="">${book.year}</td>
			<td style="">${book.edition}</td>
			<td style="">${book.isbn}</td>
			<td style="">${book.currentBorrowing.borrowerEmailAddress}</td>
			<td style="">${book.description}</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>
	</div>
	<hr />
	<a href="<spring:url value="/" htmlEscape="true" />">Back to Home</a>
</body>
</html>