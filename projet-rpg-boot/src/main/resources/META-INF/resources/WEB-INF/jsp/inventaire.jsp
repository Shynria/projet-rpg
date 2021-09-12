<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Inventaire</title>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
            crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

        <link rel="stylesheet" href="assets/css/style-inventaire.css">

    </head>

    <body>
        <div class="container">
            <h2>Status de ${ hero.nom } :</h2>

            <div class="col" id="carte-hero">
                <div class="card text-center border-secondary text-dark bg-light mb-3">
                    <div class="card-body text-dark">
                        <div class="card-header">
                            <h5 value="${ hero.nom }">${ hero.nom }</h5>
                        </div>
                        <p class="card-text" value="${ hero.getNiveau() }">Level: ${ hero.getNiveau() }</p>
                        <c:forEach items="${ levels }" var="level">
                            <c:if test="${ level.id == hero.niveau }">
                                <p class="card-text" value="${ hero.getXp() }">
                                <div class="progress">
                                    <div class="progress-bar bg-primary fw-bold" role="progressbar"
                                        style="width: ${ (hero.xp / level.pointXP) * 100 }%;">
                                    </div>
                                    <span>XP: ${ hero.getXp() } / ${ level.pointXP }</span>
                                </div>
                                </p>
                            </c:if>
                        </c:forEach>
                        <p class="card-text" value="${ hero.getPvActuel() }">
                        <div class="progress">
                            <div class="progress-bar bg-danger fw-bold" role="progressbar"
                                style="width: ${ (hero.pvActuel / hero.pvMax) * 100 }%;">
                            </div>
                            <span>PV: ${ hero.getPvActuel() } / ${ hero.getPvMax() }</span>
                        </div>
                        </p>

                        <p class="card-text" value="${ hero.getArgent() }">argent: ${ hero.getArgent() }</p>
                        <p class="card-text">stats:
                        <table class="table">
                            <thead style="text-align:center;">
                                <tr>
                                    <th>atk</th>
                                    <th>def</th>
                                    <th>agi</th>
                                    <th>vit</th>
                                </tr>
                            </thead>
                            <tbody style="text-align:center;">
                                <tr>
                                    <td>${ hero.getAttribut().getAtk() }</td>
                                    <td>${ hero.getAttribut().getDef() }</td>
                                    <td>${ hero.getAttribut().getAgi() }</td>
                                    <td>${ hero.getAttribut().getVit() }</td>
                                </tr>
                            </tbody>
                        </table>
                        </p>

                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <h2>Equipement de ${ hero.nom } :</h2>
            <table class="table table-striped">
                <thead style="text-align:center;">
                    <tr>
                        <th>Arme</th>
                        <th>Armure</th>
                        <th>Bijoux</th>
                    </tr>
                </thead>
                <tbody style="text-align:center;">
                    <tr>
                        <td>
                            ${ hero.arme.nom }
                            <a href="retirer-objet?id=${ hero.arme.id }" class="btn btn-danger">Retirer</a>
                        </td>
                        <td>
                            ${ hero.armure.nom }
                            <a href="retirer-objet?id=${ hero.armure.id }" class="btn btn-danger">Retirer</a>
                        </td>
                        <td>
                            ${ hero.bijoux.nom }
                            <a href="retirer-objet?id=${ hero.bijoux.id }" class="btn btn-danger">Retirer</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="container">
            <h2>Inventaire de ${ hero.getNom() } :</h2>
            <table class="table table-striped">
                <thead style="text-align:center;">
                    <tr>
                        <th></th>
                        <th>Nom</th>
                        <th>Type</th>
                        <th>Level</th>
                        <th>Attribut modifié</th>
                        <th>Effets</th>
                        <th>PV rendu</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody style="text-align:center;">
                    <c:forEach items="${ objets }" var="objet">
                        <tr>
                            <c:if test="${objet.type.equals('potion')}">
                                <td><img src="assets/icones/potion-d'amour.png" width="40px" /> </td>
                            </c:if>
                            <c:if test="${objet.type.equals('arme')}">
                                <td><img src="assets/icones/epee.png" width="40px" /> </td>
                            </c:if>
                            <c:if test="${objet.type.equals('armure')}">
                                <td><img src="assets/icones/armure.png" width="40px" /> </td>
                            </c:if>
                            <c:if test="${objet.type.equals('bijoux')}">
                                <td><img src="assets/icones/bijou.png" width="40px" /> </td>
                            </c:if>
                            <td>${objet.nom }</td>
                            <td>${objet.type }</td>
                            <td>${objet.level }</td>
                            <td>${objet.attribut }</td>
                            <td>${objet.changement }</td>
                            <td>${objet.pvRendu }</td>
                            <td>
                                <c:if
                                    test="${ objet.type.equals('arme') || objet.type.equals('armure') || objet.type.equals('bijoux') }">
                                    <a href="equiper-objet?id=${ objet.id }" class="btn btn-primary">Equiper</a>
                                </c:if>
                                <c:if test="${ objet.type.equals('potion')}">
                                    <a href="utiliser-potion?id=${ objet.id }" class="btn btn-success">Utiliser</a>
                                </c:if>
                            </td>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="d-grid gap-2 col-4 mx-auto">
            <a class="btn btn-primary" href="accueil" type="button">Retour</a>
        </div>

    </body>

    </html>