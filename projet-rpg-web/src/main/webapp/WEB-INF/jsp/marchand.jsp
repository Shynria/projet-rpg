<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Marchand</title>
<link rel="stylesheet" href="assets/css/style-marchand.css">
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
<script defer src="assets/js/marchand.js"></script>

</head>

<body>
	<nav>
	<ul>
		<li><a id="accueil" href="accueil">accueil</a></li>
		<li><a id="pageDemarrage" href="menu-demarrer">Page de
				démarrage</a></li>
	</ul>
	</nav>
	<div>
		<a href="accueil"><img id="exit" src="assets/icones/exit.png"></a>
		<a href="shop" class="btn">
			<img id="buy" src="assets/icones/buy.png">
		</a>
	</div>

<!-- 	<div id="div"></div> -->
<!-- 	<table id="tableAchat" style="visibility: hidden" -->
<!-- 		style="margin-left: 10px;" id="table" -->
<!-- 		class="table table-bordered border-primary"> -->
<!-- 		<thead style="text-align: center;"> -->
<!-- 			<tr> -->
<!-- 				<th scope="col">Icone</th> -->
<!-- 				<th scope="col">Nom</th> -->
<!-- 				<th scope="col">Bonus</th> -->
<!-- 				<th scope="col">Prix (G)</th> -->
<!-- 				<th scope="col">Action</th> -->
<!-- 			</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody style="text-align: center;"> -->

<!-- 			<tr> -->
<!-- 				<th scope="row"><img width="40px" height="40px" -->
<!-- 					src="assets/icones/potion-d'amour.png"></th> -->
<!-- 				<td>Potion de soin</td> -->
<!-- 				<td>+10HP</td> -->
<!-- 				<td id="prixPotion">5</td> -->
<!-- 				<td><button class="button" -->
<!-- 						onclick="achatPotion('Potion de soin');">ACHETER</button> -->
<!-- 					<button class="comptMinus">-</button> -->
<!-- 					<button class="comptPlus">+</button> -->
<!-- 					<button id="compt">1</button></td> -->
<!-- 			</tr> -->
<!-- 			<tr id="itemEpee"> -->
<!-- 				<th scope="row"><img width="40px" height="40px" -->
<!-- 					src="assets/icones/epee.png"></th> -->
<!-- 				<td>Epée blanche</td> -->
<!-- 				<td>+10ATK</td> -->
<!-- 				<td>7</td> -->
<!-- 				<td><button class="button" id="buttonEpee" -->
<!-- 						onclick="achatEpee('Epée blanche');">ACHETER</button></td> -->
<!-- 			</tr> -->
<!-- 			<tr id="itemArmure"> -->
<!-- 				<th scope="row"><img width="40px" height="40px" -->
<!-- 					src="assets/icones/armure.png"></th> -->
<!-- 				<td>Côte de maille</td> -->
<!-- 				<td>+10DEF</td> -->
<!-- 				<td>10</td> -->
<!-- 				<td><button class="button" id="buttonArmure" -->
<!-- 						onclick="achatArmure('Côte de maille');">ACHETER</button></td> -->
<!-- 			</tr> -->
<!-- 			<tr id="itemBijou"> -->
<!-- 				<td><img width="40px" height="40px" -->
<!-- 					src="assets/icones/bijou.png"></td> -->
<!-- 				<td>Collier magique</td> -->
<!-- 				<td>+5AGI,+5ATK</td> -->
<!-- 				<td>15</td> -->
<!-- 				<td><button class="button" id="buttonBijou" -->
<!-- 						onclick="achatBijou('Collier magique');">ACHETER</button></td> -->
<!-- 			</tr> -->
<!-- 		</tbody> -->
<!-- 	</table> -->
<!-- 	</div> -->
	<div>
		<audio controls src="assets/sounds/shop-doorbell.mp3" autoplay="true"
			hidden="true"></audio>
		<script>document.querySelector('audio').volume=0.1</script>
	</div>

</body>
</html>