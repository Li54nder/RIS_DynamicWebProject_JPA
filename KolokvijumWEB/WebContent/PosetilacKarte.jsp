<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Posetilac Karte</title>
</head>
<body>
	<form action="PosetilacKarte" method="get">
		ID posetioca: <input type="text" name="idP"><br>
		<input type="submit" value="Prikaze posetioca">
	</form>
	
	<c:out value="${posetilac.ime}"></c:out>
	<c:out value="${posetilac.prezime}"></c:out>
	<table border=1>
		<c:forEach var="karta" items="${posetilac.kartas}">
			<tr><td>${karta.mesto.sekcija}</td><td>${karta.mesto.scena.naziv}</td><td>${karta.izvodjenje.datum}</td>
			<td>${karta.izvodjenje.predstava.naziv}</td><td>${karta.cena}</td><td><a href="PrikaziKartu?id=${karta.idKarta}">Provera placanja</a></td></tr>
		</c:forEach>
	</table>
	
	<c:if test="${placena}">
		<h2>Selektovana karta je placena</h2>
	</c:if>
</body>
</html>