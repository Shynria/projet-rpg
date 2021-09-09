<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
	
	<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />
</head>
<body>
<div class="container">
	<h2>Liste des objets du jeux :</h2>
	<table class="table table-striped">
		<thead style="text-align:center;">
			<tr>
				<th>Nom</th>
				<th>Type</th>
				<th>Level</th>
				<th>Prix</th>
				<th>Attribut modifie</th>
				<th>Effets</th>
				<th>PV rendu</th>
			</tr>
		</thead>
		<tbody style="text-align:center;">
			<c:forEach items="${objets }" var="objet">
				<tr>
					<td>${objet.nom }</td>
					<td>${objet.type }</td>
					<td>${objet.level }</td>
					<td>${objet.prix }</td>
					<td>${objet.attribut }</td>
					<td>${objet.changement }</td>
					<td>${objet.pvRendu }</td>
			</c:forEach>
		</tbody>

	</table>

	<div class="d-grid gap-2 col-4 mx-auto">
		<a class="btn btn-primary" href="accueil" type="button" >Retour</a>
	</div>
</div>
</body>
</html>