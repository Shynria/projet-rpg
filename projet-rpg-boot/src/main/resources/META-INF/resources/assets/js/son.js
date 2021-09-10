//Clique sur le bouton "sound_offr"
document.querySelector('#sound_off')
    .addEventListener('click', () => {
        //Changte le volume a 0
        document.getElementById('accueil').volume=0;
        document.getElementById('sound_off').style.display='none';
        document.getElementById('sound_on').style.display='inline';
});

document.querySelector('#sound_on').addEventListener('click', () => {
    document.getElementById('accueil').volume=0.1;
    document.getElementById('sound_off').style.display='inline';
    document.getElementById('sound_on').style.display='none';
});

document.querySelector('#pause').addEventListener('click', () => {
    document.getElementById('pause').style.display='none';
    document.getElementById('play').style.display='inline';
    document.getElementById('accueil').pause();
});

document.querySelector('#play').addEventListener('click', () => {
    document.getElementById('play').style.display='none';
    document.getElementById('pause').style.display='inline';
    document.getElementById('accueil').play();
});

//Musique page camp
document.querySelector('a[href="#tente"]').addEventListener('click', () => {
    document.getElementById('sound_camp_fire').play();
    document.getElementById('sound_camp_fire').volume=0.2;
    document.getElementById('accueil').pause();
})

document.querySelector('a[href="#2"]').addEventListener('click', () => {
    document.getElementById('sound_camp_fire').pause();
    document.getElementById('sound_camp_fire').currentTime=0;
    document.getElementById('accueil').play();
})

//Musique page taverne
document.querySelector('a[href="#taverne"]').addEventListener('click', () => {
    document.getElementById('sound_taverne').play();
    document.getElementById('sound_taverne').volume=0.2;
    document.getElementById('accueil').pause();
})
document.querySelector('a[href="#1"]').addEventListener('click', () => {
    document.getElementById('sound_taverne').pause();
    document.getElementById('sound_taverne').currentTime=0;
    document.getElementById('accueil').play();
})

//Musique page fight
document.querySelector('a[href="#expedition"]').addEventListener('click', () => {
    document.getElementById('sound_fight').play();
    document.getElementById('sound_fight').volume=0.2;
    document.getElementById('accueil').pause();
})
document.querySelector('a[href="#3"]').addEventListener('click', () => {
    document.getElementById('sound_fight').pause();
    document.getElementById('sound_fight').currentTime=0;
    document.getElementById('accueil').play();
})