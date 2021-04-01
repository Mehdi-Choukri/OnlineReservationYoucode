<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Public/Style/Connexion.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
    <title>S'inscrire</title>
</head>
<style>
.btn-sinscrire:hover
{
    color:white;
    background-color: #2E7FFF;
    border:none;

}
.btn-sinscrire2:hover
{
    color:white;
    background-color:black;
    border:none;
}
.subContainer
{
display : flex;
}
</style>
<body style="font-family: 'Montserrat', sans-serif;">
    <header>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light ">
                <div class="container-fluid">
                    <img src="${pageContext.request.contextPath}/resources/images/logo-youcode-ma.png" style="width: 180px"></img>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav" style="margin-left: 600px;">
                            <a class="nav-link active"  aria-current="page" href="${pageContext.request.contextPath}/home">Home</a>
                            <span class="nav-link" style="margin-left: 25px;" href="#">Calendar</span>
                            <span class="nav-link" style="margin-left: 20px; "href="#">About us</span>
                            <button type="button" style="border-radius: 1.5em; border-color: black; width: 150px ;"
                            class="btn btn-sinscrire" onclick="location.href='${pageContext.request.contextPath}/register'">S'inscrire</button>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
    </header>

    <div class="container" style="padding: 5%;">
       <div class="subContainer">
        <div class="col-sm">
            <img src="${pageContext.request.contextPath}/resources/images/nerd2.png" style="width: 70%;">
             
        </div>
        <div class="row">
            <div class="col-sm" style="padding: 6%; margin-left: -160px; ">
                <div class="col-sm border" style="padding: 15%;">
                    <div class="form-group ">
                        <div class="btn-group btn-group-toggle" data-toggle="buttons">
                            <label class="btn btn-light active">
                                <input type="radio" name="options"
                                    style="border-radius: 1.5em; border-color: black; width: 150px ;" id="option1"
                                    onclick="window.location.href='${pageContext.request.contextPath}/login'"> Se connecter
                            </label>
                            <label class="btn btn-primary">
                                <input type="radio" name="options" id="option2"> S'inscrire
                            </label>
                           
                        </div>
                      
                        <form method="post" style="align-content: center;">
                            <p>Vous êtes Nouveau ? <br>
                                Inscrivez-vous pour profiter de toutes les fonctionnalités</p>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Nom :</label>
                                <input type="text" pattern="[A-Za-z]{3,}" required name="nom" class="form-control" id="exampleInputPassword1"
                                    style="background-color: #E8EFF6; border-color: transparent;">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Prénom :</label>
                                <input type="text" name="prenom" class="form-control"  pattern="[A-Z a-z]{3,}"  required id="exampleInputPassword1"
                                    style="background-color: #E8EFF6; border-color: transparent;">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Email :</label>
                                <input type="email" name="email" class="form-control" required id="exampleInputEmail1"
                                    style="background-color: #E8EFF6; border-color: transparent;"
                                    aria-describedby="emailHelp">
 
                            </div>
                            <div class="form-group">
                                <label class="control-label">Ville</label>
                                 <select class="form-control" name="ville" required>
                                 <option >Safi</option>
                                 <option>Rabat</option>
                                  <option>Casabalanca</option>
                                 <option>Skhirat</option>
                                   <option>Marrakech</option>
                                 <option>Eljadida</option>
                                 </select>
                                <span></span>
                            </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Mot de passe :</label>
                                    <input type="password" name="password"  required class="form-control" id="exampleInputPassword1"
                                        style="background-color: #E8EFF6; border-color: transparent;">

                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Confirmation de mot de passe :</label>
                                    <input required type="password" name="cpassword" class="form-control" id="exampleInputPassword1"
                                        style="background-color: #E8EFF6; border-color: transparent;">

                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault" style="font-size: 10px;">
                                        I accept to share my data with us. I acknowledge that the
                                        collection and use of my personal data will follow
                                        the treatment as described on their privacy policies
                                    </label>
                                </div>
                                <button type="submit" id="idRegisterBtn" class="btn btn-primary"
                                    style="  padding:8px 25px; margin-left: 150px; border-radius: 2em;">S'inscrire</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
       </div>
    </div>
     <div class="footer" style="padding: 2px;
    text-align: center;
    background: black;
    line-height: 25px;
    color: #fff;
    font-size: 15px;
    letter-spacing: 2px;
    margin: 0px;
    margin-top: 150px;">
        <div>Powered By YouCode-Safi.</div>
        <p>Copyright © 2021. All rights reserved.</p>
    </div>
   






</body>

</html>