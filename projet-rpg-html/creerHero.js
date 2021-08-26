function validerCreationHero() {
    let defense = document.querySelector('[name="defense"]:checked').value;



 let tableAtk = document.querySelectorAll('id="statAtk"');
 for (let a of tableAtk){
     if ('input [type="checkbox"]' == true){
        console.log(a);
    }
 }

}

// function sauvegarderHero(Hero){
//     let heroes = JSON.parse(localStorage.getItem('heroes'));

//     if (heroes == null) {
//         heroes = [];
//     }
//     heroes.push(Hero);

//     localStorage.setItem('heroes', JSON.stringify(heroes));
// }