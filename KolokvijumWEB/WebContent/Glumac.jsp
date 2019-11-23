<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Glumac</title>
</head>
<body>
	<form action="PrikazUlogaGlumca" method="get">
		<table>
			<tr><td>Podaci o glumcu</td></tr>
			<tr><td>Ime: </td><td><input type="text" name="ime"></td></tr>
			<tr><td>Prezime: </td><td><input type="text" name="prezime"></td></tr>
		</table>
		<input type="submit" value="Prikazi uloge glumca">
	</form>
	<br><br>
	<c:if test="${postojiRezultat}">
		<table>
			<c:forEach var="item" items="${uloge}">
				<tr><td>${item.naziv}</td></tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!postojiRezultat}">
		<h2>Nema uloga za trazenog glumca</h2>
	</c:if>
	<!-- 
	<c:out value="${postojiRezultat}"></c:out>
	<c:out value="${uloge.size()}"></c:out>
	-->
</body>
</html>