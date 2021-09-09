document.querySelector('#combat_facile').addEventListener('click', () => {
    fetch('http://localhost:8080/api/combat_facile').then(resp=>resp.json())
        .then(rencontre=> {
            let ligne = document.createElement('div');
            ligne.innerHTML =
            `<h1>Vous faites la rencontre d'un terrible monstre ! Le monstrueux ${rencontre.monstreRencontre.nom}</h1>
            <img src="${rencontre.monstreRencontre.image}" alt="monstreRencontré" width="600px">
            <div>"Après un combat acharné, vous Réussissez à le vaincre. Vous gagnez ${rencontre.monstreRencontre.thune} or,
                ${rencontre.monstreRencontre.XpDonnee} XP et vous perdez ${rencontre.PvPerdu} PV.
            `
            document.querySelector('#expedition div').append(ligne);
        })
})