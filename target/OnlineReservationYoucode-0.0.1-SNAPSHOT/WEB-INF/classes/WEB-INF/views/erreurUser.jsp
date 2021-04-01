<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../Public/Style/Connexion.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<title>Erreur</title>
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

.subContainer {
	display: flex;
}

.footer {
	margin-top:250px;
	
}
.alertmsg
{
	width:fit-content;
	text-align:center;
	width:50%;
	margin:auto;
	margin-top:100px;
}
.alertmsg p 
{
	text-align:center;
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
						<a class="nav-link active" aria-current="page"
							href="${pageContext.request.contextPath}/home">Home</a> <span
							class="nav-link" style="margin-left: 25px;" href="#">Calendar</span>
						<span class="nav-link" style="margin-left: 20px;" href="#">About
							us</span>
						<button type="button"
							style="border-radius: 1.5em; border-color: black; width: 150px;"
							class="btn btn-sinscrire"
							onclick="location.href='${pageContext.request.contextPath}/register'">S'inscrire</button>
					</div>
				</div>
			</div>
		</nav>
	</header>

	 
					<div class="alert alert-danger alertmsg" role="alert"> 
						<p> ${msgErreur}</p></div>
 


</body>
</html>