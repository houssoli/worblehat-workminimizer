<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false"%>
<html>
<head>
<title>Worblehat Bookmanager</title>
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
   <li style="padding-left: 10px"><a id="returnAllBooks" href="<spring:url value="/returnAllBooks" htmlEscape="true" />" >Return all Books</a></li>
    <li style="padding-left: 10px"><a href="<spring:url value="/showBorrowedBooks" htmlEscape="true" />">Show borrowed Books</a></li>  </ul>
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
<h1 id="welcome_heading">Worblehat Bookmanager - Version <spring:message code="versionsnummer" /> </h1></div>
</body>
</html>
