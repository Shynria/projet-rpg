<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;700&display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
        crossorigin="anonymous"></script>
<link rel="stylesheet" href="assets/css/StyleCreerHero.css">
<script defer src="assets/js/creerHero.js"></script>

<title>Cr�er un Hero</title>
</head>

<body>
    <header>
        <div>
            <h1>Bienvenue dans le monde de Golarion</h1>
        </div>

        <div>
            <h2>Cr�ez votre H�ro !</h2>
        </div>
    </header>

    <section>
        <form method="POST" class="was-validated">
            <div class="col-6">
                <label for="nomHero" class="form-label" id="nomHero">Nom du H�ro : </label>
                <input type="text" class="form-control" id="nomHero" aria-describedby="nomHero" name="nom" required >

                <div class="valid-feedback">Nom valide</div>
                <div class="invalid-feedback">Nom invalide, veuillez recommencer</div>
            </div>

            <div>
                <label for="statHero" class="form-label">Stats de votre Hero : 10 points de competences à
                    attribuer</label>
            </div>

            <div class="col-6">
                <label for="statAtk" class="form-label">Stats d'attaque : </label>
            </div>
            <div class="btn-group Atk required" role="group" id="statAtk" aria-label="Basic radio toggle button group"
                aria-required="true">
                <input value="0" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk0" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk0">0</label>

                <input value="1" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk1" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk1">1</label>

                <input value="2" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk2" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk2">2</label>

                <input value="3" name="atk"  type="radio" class="btn-check" for="btnradio" id="statAtk3" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk3">3</label>

                <input value="4" name="atk"  type="radio" class="btn-check" for="btnradio" id="statAtk4" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk4">4</label>

                <input value="5" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk5" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk5">5</label>

                <input value="6" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk6" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk6">6</label>

                <input value="7" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk7" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk7">7</label>

                <input value="8" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk8" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk8">8</label>

                <input value="9" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk9" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk9">9</label>

                <input value="10" name="atk" type="radio" class="btn-check" for="btnradio" id="statAtk10" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAtk10">10</label>
            </div>

            <div class="col-6">
                <label for="statDef" class="form-label">Stats de d�fense : </label>
            </div>
            <div class="btn-group Def required" role="group" aria-label="Basic radio toggle button group"
                aria-required="true">
                <input value="0" name="def" type="radio" class="btn-check" for="btnradio" id="statDef0" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef0">0</label>

                <input value="1" name="def" type="radio" class="btn-check" for="btnradio" id="statDef1" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef1">1</label>

                <input value="2" name="def" type="radio" class="btn-check" for="btnradio" id="statDef2" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef2">2</label>

                <input value="3" name="def" type="radio" class="btn-check" for="btnradio" id="statDef3" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef3">3</label>

                <input value="4" name="def" type="radio" class="btn-check" for="btnradio" id="statDef4" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef4">4</label>

                <input value="5" name="def" type="radio" class="btn-check" for="btnradio" id="statDef5" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef5">5</label>

                <input value="6" name="def" type="radio" class="btn-check" for="btnradio" id="statDef6" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef6">6</label>

                <input value="7" name="def" type="radio" class="btn-check" for="btnradio" id="statDef7" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef7">7</label>

                <input value="8" name="def" type="radio" class="btn-check" for="btnradio" id="statDef8" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef8">8</label>

                <input value="9" name="def" type="radio" class="btn-check" for="btnradio" id="statDef9" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef9">9</label>

                <input value="10" name="def" type="radio" class="btn-check" for="btnradio" id="statDef10" autocomplete="off">
                <label class="btn btn-outline-dark" for="statDef10">10</label>
            </div>

            <div class="col-6">
                <label for="statAgi" class="form-label">Stats d'agilit� : </label>
            </div>
            <div class="btn-group Agi required" role="group" aria-label="Basic radio toggle button group"
                aria-required="true">
                <input value="0" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi0" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi0">0</label>

                <input value="1" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi1" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi1">1</label>

                <input value="2" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi2" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi2">2</label>

                <input value="3" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi3" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi3">3</label>

                <input value="4" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi4" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi4">4</label>

                <input value="5" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi5" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi5">5</label>

                <input value="6" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi6" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi6">6</label>

                <input value="7" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi7" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi7">7</label>

                <input value="8" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi8" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi8">8</label>

                <input value="9" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi9" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi9">9</label>

                <input value="10" name="agi" type="radio" class="btn-check" for="btnradio" id="statAgi10" autocomplete="off">
                <label class="btn btn-outline-dark" for="statAgi10">10</label>
            </div>

            <div class="col-6">
                <label for="statVit" class="form-label">Stats de vitalit� : </label>
            </div>
            <div class="btn-group Vit required" role="group" aria-label="Basic radio toggle button group"
                aria-required="true">
                <input value="0" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit0" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit0">0</label>

                <input value="1" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit1" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit1">1</label>

                <input value="2" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit2" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit2">2</label>

                <input value="3" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit3" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit3">3</label>

                <input value="4" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit4" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit4">4</label>

                <input value="5" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit5" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit5">5</label>

                <input value="6" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit6" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit6">6</label>

                <input value="7" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit7" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit7">7</label>

                <input value="8" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit8" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit8">8</label>

                <input value="9" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit9" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit9">9</label>

                <input value="10" name="vit" type="radio" class="btn-check" for="btnradio" id="statVit10" autocomplete="off">
                <label class="btn btn-outline-dark" for="statVit10">10</label>
            </div>

            <div class="d-grid gap-2 col-4 mx-auto" id="boutton">
                <a class="btn btn-primary" href="menu-demarrer" type="button">Retour</a>
               	<input class="btn btn-success" type="submit" value="Valider" />
            </div>

        </form>
    </section>

</body>

</html>