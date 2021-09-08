<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;700&display=swap"
	rel="stylesheet">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="assets/css/styleChargerHero.css">

<title>Charger un Hero</title>
</head>

<body>
	<header>
	<div>
		<h1>Bienvenue dans le monde de Golarion</h1>
	</div>

	<div>
		<h2>Choisissez votre Hero !</h2>
	</div>
	</header>

	<section>
	<div class="row row-cols-3 row-cols-md-2 g-4">
		<c:forEach items="${ heros }" var="hero">
			<div class="col" id="carte-hero">
				<div
					class="card text-center border-secondary text-dark bg-light mb-3">
					<div class="card-body text-dark">
						<div class="card-header">
							<h5 value="${ hero.nom }">${ hero.nom }</h5>
						</div>
						<p class="card-text" value="${ hero.getNiveau() }">Level: ${ hero.getNiveau() }</p>
						<c:forEach items="${ levels }" var="level">
						<c:if test="${ level.id == hero.niveau }">
							<p class="card-text" value="${ hero.getXp() }">
							<div class="progress">
								<div class="progress-bar bg-primary fw-bold" role="progressbar"
									style="width: ${ (hero.xp / level.pointXP) * 100 }%;">
									</div>
								<span>XP: ${ hero.getXp() } / ${ level.pointXP }</span>
							</div>
							</p>
						</c:if>
						</c:forEach>
						<p class="card-text" value="${ hero.getPvActuel() }">
						<div class="progress">
							<div class="progress-bar bg-danger fw-bold" role="progressbar"
								style="width: ${ (hero.pvActuel / hero.pvMax) * 100 }%;">
								</div>
							<span>PV: ${ hero.getPvActuel() } / ${ hero.getPvMax() }</span>
						</div>
						</p>
						<p class="card-text" value="${ hero.getArgent() }">argent: ${ hero.getArgent() }</p>

						<div class="d-grid gap-2 d-md-block">
							<a href="choisir-hero?id=${ hero.id }" class="btn btn-success">Choisir</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>



	</div>

	<div class="d-grid gap-2 col-4 mx-auto" id="boutton">
		<a class="btn btn-primary" href="menu-demarrer" type="button">Retour</a>
	</div>
	</section>

</body>

</html>