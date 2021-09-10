<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="assets/css/StyleAccueil.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
<script defer src="assets/js/son.js"></script>
<script defer src="assets/js/combat.js"></script>
<title>A toi de jouer !</title>
</head>
<body>
	<header>
		<p>
			<h1>${hero.getNom()}, bienvenue dans le monde de Golarion !</h1>
			${hero.getArgent()} Gold<img src="assets/icones/coins.png" alt="coins" width="30px" height="30px">
			${hero.getPvActuel()}/${hero.getPvMax()}<img src="assets/icones/hearts.png" alt="heart" width="30px" height="30px">
		</p>
	</header>

	<section> <a href="#expedition"><img src="assets/icones/epee (1).png"
		alt="Partir en expedition" width="50px" height="50px"></a>
	<p>
		<a href="marchand"> <img src="assets/icones/trader.png" alt="trader"
			width="100px" height="100px">
		</a>
	</p>
	<p>
		<a href="#taverne"> <img src="assets/icones/auberge.png" alt="auberge"
			width="70px" height="70px" id="taverneimg"></a>
	</p>
	<p>
		<a href="#tente"> <img src="assets/icones/tent.png" alt="tente"
			width="100px" height="100px" id="tenteimg"></a>
	</p>

	<p>
		<a href="inventaire"> <img src="assets/icones/knapsack.png" alt="inventaire" 
			width="60px" height="60px" ></a>
	</p>

	<p>
		<a href="bestiaire"> <img src="assets/icones/bestaire.png" alt="bestaire" 
			width="60px" height="60px" ></a>
	</p>

	<p>
		<a href="liste-objet"> <img src="assets/icones/objet-index.png" alt="index-objet" 
			width="60px" height="60px" ></a>
	</p>

	<p>
		<a href="menu-demarrer"> <img src="assets/icones/porte.png" alt="exit" 
			width="60px" height="60px" ></a>
	</p>




	<div class="modal" id="taverne">
		<div class="modal_content">
			
			<a href="#1" class="modal_close">&times;</a>
		</div>
	</div>

	<div class="modal" id="tente">
		<div class="modal_content">
			
			<a href="#2" class="modal_close">&times;</a>
		</div>
	</div>

	<div class="modal" id="expedition">
		<div class="modal_content">
			<div>
				Etes-vous temeraire?
			</div>
			<button id="combat_facile">Mauviette</button>
			<button id="combat_moyen">Aventurier</button>
			<button id="combat_difficile">Legende</button>
			<a href="#3" class="modal_close">&times;</a>
		</div>
	</div>

	<div id="sound">
		<img src="assets/icones/pause.png" id="pause" alt="pause" width="=25px"
			height="25px"> <img src="assets/icones/play.png"
			id="play" alt="play" width="=25px" height="25px" hidden="true">
		<img src="assets/icones/mute.png" alt="sound-off" id="sound_off"
			width="=25px" height="25px"> <img
			src="assets/icones/speaker-filled-audio-tool.png" id="sound_on"
			alt="sound-on" width="=30px" height="30px" hidden="true">

		<audio controls src="assets/sounds/accueil_music.mp3" id="accueil"
			autoplay="true" loop="true" hidden="true"></audio>
		<audio controls src="assets/sounds/around_the_fire.mp3" id="sound_camp_fire"
			loop="true" hidden="true"></audio>
		<audio controls src="assets/sounds/skyrim_tavern.mp3" id="sound_taverne"
			loop="true" hidden="true"></audio>

		<audio controls src="assets/sounds/ffi-victory.mp3" id="sound_fight" 
			loop="true" hidden="true"></audio>

		<script>
			document.querySelector('audio').volume = 0.1;
		</script>
	</div>

	</section>
</body>
</html>