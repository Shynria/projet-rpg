<%@ page language="java" contentType="text/html; charset=UTF-8" %>
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
	<header>
		<p>
			${hero.argent} Gold<img src="assets/icones/coins.png" alt="coins" width="30px" height="30px">
			${hero.pvActuel}/${hero.pvMax}<img src="assets/icones/hearts.png" alt="heart" width="30px" height="30px">
		</p>
	</header>

		<a href="accueil"><img id="exit" src="assets/icones/exit.png"></a>
		<a href="shop" class="btn">
			<img id="buy" src="assets/icones/buy.png">
		</a>
		<a href="vendre"><img id="vendre" src="assets/icones/vendre.png"></a>
	</div>




	<div>
		<audio controls src="assets/sounds/shop-doorbell.mp3" autoplay="true"
			hidden="true"></audio>
		<script>document.querySelector('audio').volume=0.1</script>
	</div>

</body>
</html>