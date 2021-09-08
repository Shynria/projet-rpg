<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/StyleAccueil.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<script defer src="assets/js/son.js"></script>
<title>A toi de jouer !</title>
</head>
<body>
	<header>
	<p>
		<img src="assets/icones/coins.png" alt="coins" width="30px" height="30px">Gold
		<img src="assets/icones/hearts.png" alt="heart" width="30px" height="30px">PV
	</p>
	<h1>Bienvenue dans le monde de Golarion !</h1>
	</header>

	<section> <img src="assets/icones/epee (1).png"
		alt="Partir en expédition" width="50px" height="50px">
	<p>
		<a href="marchand"> <img src="assets/icones/trader.png" alt="trader"
			width="100px" height="100px">
		</a>
	</p>
	<p>
		<a href="#taverne"> <img src="assets/icones/auberge.png" alt="auberge"
			width="70px" height="70px"></a>
	</p>
	<p>
		<a href="#tente"> <img src="assets/icones/tent.png" alt="tente"
			width="100px" height="100px"></a>
	</p>

	<div class="modal" id="taverne">
		<div class="modal_content">
			<h2>Vous passez une nuit douce et chalereuse à l'auberge</h2>
			<img src="assets/images/tavern.jpg" alt="taverne" width="700px">
			<p>Vous regagnez X PV</p>
			<a href="#1" class="modal_close">&times;</a>
		</div>
	</div>

	<div class="modal" id="tente">
		<div class="modal_content">
			<h2>Vous passez une nuit paisible à vous reposer</h2>
			<img src="assets/images/camp_fire.jpg" alt="camp_fire" width="700px">
			<p>Vous regagnez X PV</p>
			<a href="#2" class="modal_close">&times;</a>
		</div>
	</div>

	<div id="sound">
		<img src="assets/icones/pause.png" id="pause" alt="pause" width="=25px"
			height="25px"> <img src="icones/play-button-arrowhead.png"
			id="play" alt="play" width="=25px" height="25px" hidden="true">
		<img src="assets/icones/mute.png" alt="sound-off" id="sound_off"
			width="=25px" height="25px"> <img
			src="assets/icones/speaker-filled-audio-tool.png" id="sound_on"
			alt="sound-on" width="=30px" height="30px" hidden="true">

		<audio controls src="assets/sounds/accueil_music.mp3" id="accueil"
			autoplay="true" loop="true" hidden="true"></audio>
		<audio controls src="assets/sounds/around_the_fire.mp3" id="sound_camp_fire"
			loop="true"></audio>
		<audio controls src="assets/sounds/skyrim_tavern.mp3" id="sound_taverne"
			loop="true"></audio>

		<script>
			document.querySelector('audio').volume = 0.1;
		</script>
	</div>

	</section>
</body>
</html>