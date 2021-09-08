function achatPotion(potion){
    let texteAchat = document.querySelector("#div");
    let nombrePotions= document.getElementById('compt').textContent;
    let prixPotion=document.querySelector('#prixPotion').textContent;
    texteAchat.textContent="Merci pour votre achat! Vous avez achetez "+nombrePotions
    + potion+"-"+prixPotion*nombrePotions+"G!";
}

function achatEpee(epee){
    let texteAchat = document.querySelector("#div");
    texteAchat.textContent="Merci pour votre achat! Vous avez achetez "+ epee+" -7G!";
    document.querySelector('#itemEpee').style="opacity:0.5";
    document.getElementById('buttonEpee').onclick="";
}

function achatArmure(armure){
    let texteAchat = document.querySelector("#div");
    texteAchat.textContent="Merci pour votre achat! Vous avez achetez "+ armure+" -10G!";
    document.querySelector('#itemArmure').style="opacity:0.5";
    document.getElementById('buttonArmure').onclick="";
}

function achatBijou(bijou){
    let texteAchat = document.querySelector("#div");
    texteAchat.textContent="Merci pour votre achat! Vous avez achetez "+ bijou+" -15G!";
    document.querySelector('#itemBijou').style="opacity:0.5";
    document.getElementById('buttonBijou').onclick="";
}

let ouvrirMenuAchat=document.querySelector('.btn');
ouvrirMenuAchat.addEventListener('click',()=>{
    if (document.getElementById('tableAchat').style.visibility == "hidden"){
    document.getElementById('tableAchat').style.visibility="visible";
    document.getElementById('div').style.visibility="visible";
}else{
        document.getElementById('tableAchat').style.visibility="hidden";
        document.getElementById('div').textContent="";
    }
    });

let ajoutPotion=document.querySelector('.comptPlus');
ajoutPotion.addEventListener('click',()=>{
    document.getElementById('compt').textContent++;
});
let retraitPotion=document.querySelector('.comptMinus');
retraitPotion.addEventListener('click',()=>{
    if (document.getElementById('compt').textContent>0){
    document.getElementById('compt').textContent--;}
});
