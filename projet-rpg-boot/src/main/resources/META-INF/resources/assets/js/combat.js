document.querySelector('#combat_facile').addEventListener('click', () => {
    fetch('http://localhost:8080/api/combat_facile').then(resp=>resp.json())
        .then(rencontre=> {
            if(rencontre.mort==true){
                window.location ="/gameover"
            }
            let ligne = document.createElement('div');
            ligne.innerHTML =
            `<h1>Vous faites la rencontre d'un terrible monstre ! Le monstrueux ${rencontre.monstreRencontre.nom}</h1>
            <img src="${rencontre.monstreRencontre.image}" alt="monstreRencontré" width="600px" height="600px">
            <div>"Après un combat acharné, vous Réussissez à le vaincre. Vous gagnez ${rencontre.monstreRencontre.thune} or,
                ${rencontre.monstreRencontre.XpDonnee} XP et vous perdez ${rencontre.PvPerdu} PV.
            `;
            document.querySelector('#expedition div').append(ligne);
            let ligne2 = document.createElement('div');
            if (rencontre.levelUp == true) {
                ligne2.innerHTML = 
                `<h2> Vous montez en Niveau ! </h2>`;
                document.querySelector('#expedition div').append(ligne2);
                setTimeout(() => {
                    window.location="/levelup"
                }, 5000);
            };
            
        });
});

document.querySelector('#combat_moyen').addEventListener('click', () => {
    fetch('http://localhost:8080/api/combat_moyen').then(resp => resp.json())
        .then(rencontre => {
            if(rencontre.mort==true){
                window.location ="/gameover"
            }
            let ligne = document.createElement('div');
            ligne.innerHTML =
                `<h1>Vous faites la rencontre d'un terrible monstre ! Le monstrueux ${rencontre.monstreRencontre.nom}</h1>
            <img src="${rencontre.monstreRencontre.image}" alt="monstreRencontré" width="600px" height="600px">
            <div>"Après un combat acharné, vous Réussissez à le vaincre. Vous gagnez ${rencontre.monstreRencontre.thune} or,
                ${rencontre.monstreRencontre.XpDonnee} XP et vous perdez ${rencontre.PvPerdu} PV.
            `
            document.querySelector('#expedition div').append(ligne);
            let ligne2 = document.createElement('div');
            if (rencontre.levelUp == true) {
                ligne2.innerHTML = 
                `<h2> Vous montez en Niveau ! </h2>`;
                document.querySelector('#expedition div').append(ligne2);
                setTimeout(() => {
                    window.location="/levelup"
                }, 5000);
            };
        });
});

document.querySelector('#combat_difficile').addEventListener('click', () => {
    fetch('http://localhost:8080/api/combat_difficile').then(resp => resp.json())
        .then(rencontre => {
            if(rencontre.mort==true){
                window.location ="/gameover"
            }
            let ligne = document.createElement('div');
            ligne.innerHTML =
                `<h1>Vous faites la rencontre d'un terrible monstre ! Le monstrueux ${rencontre.monstreRencontre.nom}</h1>
            <img src="${rencontre.monstreRencontre.image}" alt="monstreRencontré" width="600px" height="600px">
            <div>"Après un combat acharné, vous Réussissez à le vaincre. Vous gagnez ${rencontre.monstreRencontre.thune} or,
                ${rencontre.monstreRencontre.XpDonnee} XP et vous perdez ${rencontre.PvPerdu} PV.
            `
            document.querySelector('#expedition div').append(ligne);
            let ligne2 = document.createElement('div');
            if (rencontre.levelUp == true) {
                ligne2.innerHTML = 
                `<h2> Vous montez en Niveau ! </h2>`;
                document.querySelector('#expedition div').append(ligne2);
                setTimeout(() => {
                    window.location="/levelup"
                }, 5000);
            };
        })
});

document.querySelector('#taverneimg').addEventListener('click', () => {
    fetch('http://localhost:8080/api/taverne').then(resp => resp.json())
        .then(repos => {
            let ligne = document.createElement('div');
            ligne.innerHTML =
                `<h2>Vous passez une nuit douce et chalereuse à l'auberge</h2>
                <img src="assets/images/tavern.jpg" alt="taverne" width="700px">
                <p>Vous regagnez ${repos.pvRecupere} PV pour la somme de ${repos.argentperdu}gold </p>
                `
                document.querySelector('#taverne div').append(ligne);
        })
});

document.querySelector('#tenteimg').addEventListener('click', () => {
    fetch('http://localhost:8080/api/tente').then(resp => resp.json())
        .then(repos => {
            let ligne = document.createElement('div');
            ligne.innerHTML =
                `<h2>Vous passez une nuit paisible à vous reposer</h2>
                <img src="assets/images/camp_fire.jpg" alt="camp_fire" width="700px">
                <p>Vous regagnez ${repos.pvRecupere} PV</p>
                `
                document.querySelector('#tente div').append(ligne);
        })
});

document.querySelector('a[href="#1"]' ).addEventListener('click', () => {
    document.getElementById('taverneimg').style.visibility='hidden';
    document.getElementById('tenteimg').style.visibility='hidden';
})

document.querySelector('a[href="#2"]' ).addEventListener('click', () => {
    document.getElementById('taverneimg').style.visibility='hidden';
    document.getElementById('tenteimg').style.visibility='hidden';
})

document.querySelector('a[href="#3"]' ).addEventListener('click', () => {
    window.location="/accueil";
})