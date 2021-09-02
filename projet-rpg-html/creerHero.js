function validerCreationHero() {
    document.getElementById('btn-valider').addEventListener('click', () => {
		let atk = document.querySelector('[name="attaque"]:checked').value;
	    let def = document.querySelector('[name="defense"]:checked').value;
	    let agi = document.querySelector('[name="agilite"]:checked').value;
	    let vit = document.querySelector('[name="vitalite"]:checked').value;

	    console.log(atk, def, agi, vit);
	    console.log(parseInt(atk) + parseInt(def) + parseInt(agi) + parseInt(vit));

	    if (parseInt(atk) + parseInt(def) + parseInt(agi) + parseInt(vit) == 10){
	    	document.getElementById('btn-valider').innerHTML= 'href="accueil.html"';
	    } else {
	        document.getElementById('btn-valider').innerHTML= "";
	    }
	})
};

/*  function sauvegarderHero(Hero){
    let heroes = JSON.parse(localStorage.getItem('heroes'));

    if (heroes == null) {
         heroes = [];
    }
    heroes.push(Hero);

    localStorage.setItem('heroes', JSON.stringify(heroes));
 }; */