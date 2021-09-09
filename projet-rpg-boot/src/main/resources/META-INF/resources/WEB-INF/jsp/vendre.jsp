<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shop</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>


</head>
<h1>Menu de vente</h1>
<body>

	<header>
		<p>
			${hero.getArgent()} Gold<img src="assets/icones/coins.png" alt="coins" width="30px" height="30px">
			${hero.getPvActuel()}/${hero.getPvMax()}<img src="assets/icones/hearts.png" alt="heart" width="30px" height="30px">
		</p>
	</header>

	<table class="table table-stripped">
		<thead style="text-align:center">
			<tr>
				<th>Type</th>
				<th>Nom</th>
				<th>Bonus</th>
				<th>Stat</th>
				<th>Prix</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody style="text-align:center">
		<c:forEach items="${objets}" var="objet">
	
			<tr>
			<c:if test="${objet.type.equals('potion')}"><td><img src="assets/icones/potion-d'amour.png" width="40px"/> </td></c:if>
			<c:if test="${objet.type.equals('arme')}"><td><img src="assets/icones/epee.png" width="40px"/> </td></c:if>
			<c:if test="${objet.type.equals('armure')}"><td><img src="assets/icones/armure.png" width="40px"/> </td></c:if>
			<c:if test="${objet.type.equals('bijoux')}"><td><img src="assets/icones/bijou.png" width="40px"/> </td></c:if>
			
				<td>${objet.nom}</td>
				<td>${objet.changement } </td>
				<td>${objet.attribut } </td>
				<td>${objet.prix.divide(2) }</td>
				<td><a href="vente?id=${objet.id }" class="btn btn-danger">VENDRE</a></td>
			</tr>
	
			</c:forEach>
		</tbody>
	</table>
	<div>
<a style="margin-left: 50%;" href="marchand" class="btn btn-danger">RETOUR</a>
</body>
</html>