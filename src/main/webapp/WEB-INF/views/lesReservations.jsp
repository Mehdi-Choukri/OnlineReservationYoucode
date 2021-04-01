<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Les réservations</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
 
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>
</head>
<style>
.btn-sinscrire:hover {
	color: white;
	background-color: #2E7FFF;
	border: none;
}

.btn-sinscrire2:hover {
	color: white;
	background-color: black;
	border: none;
}

.c_imgReservation i {
	font-size: 27px;
	color: #2E7FFF;
}

.c_imgReservation p {
	text-align: center;
}
.spanmsg
{
	color:green;
	font-size:24px;
}
</style>
<body>
<header>
		<nav class="navbar navbar-expand-lg navbar-light ">
			<div class="container-fluid">
				<img
					src="${pageContext.request.contextPath}/resources/images/logo-youcode-ma.png"
					style="width: 180px"></img>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
					aria-controls="navbarNavAltMarkup" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav" style="margin-left: 600px;">
						<a class="nav-link " aria-current="page"
							href="${pageContext.request.contextPath}/allUser">Tous les
							Utilisateurs</a> <a class="nav-link active" style="margin-left: 25px;"
							href="${pageContext.request.contextPath}/lesReservations">Les réservations</a> <a class="nav-link "
							style="margin-left: 20px;"
							href="${pageContext.request.contextPath}/addReservation">Ajouter
							les réservations</a>
						<button type="button"
							style="border-radius: 1.5em; border-color: black; width: 150px;"
							class="btn btn-sinscrire"
							onclick="location.href='${pageContext.request.contextPath}/logout'">Déconnexion</button>
					</div>
				</div>
			</div>
		</nav>
	</header>
	<div class="container">
	 
		<div class="panel  panel-primary">
	 
			<div class="panel-body">
			 
				<table class="table">
					<tr>
						<th scope="col">ID</th>
						<th scope="col">ID Réservation</th>
						<th scope="col">Date Réservation</th>
						<th scope="col">Nom Utilisateur</th>
						<th scope="col">Prénom Utilisateur</th>
						 <th scope="col">Etat</th>
						<th colspan="2" scope="col">Actions à faire</th>
					</tr>
					<c:forEach items="${listReservation}" var="r">
						<tr>
							<td>${r.id}</td>
							<td>${r.reserver.id}</td>
							<td>${r.reserver.date}</td>
							<td>${r.utilisateur.nom}</td>
							<td>${r.utilisateur.prenom}</td>
							<td>${r.etat}</td>
							 
					 
							<td><a
								 
								href="validerReservation?id=${r.id}">Valider</a></td>
								<td><a
								onclick="return confirm('êtes-vous sur de vouloir reserver cette date ?')"
								href="refuserReservation?id=${r.id}">Refuser</a></td>
						</tr>

					</c:forEach>

				</table>
			</div>


		</div>
	</div>


</body>
</html>