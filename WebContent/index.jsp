<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UniMed</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/">UniMed</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Cadastro <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="AgendaController.do?action=">Agenda</a></li>
							<li><a href="MedicoController.do?action=">Médico</a></li>
							<li><a href="PacienteController.do?action=">Paciente</a></li>
							<li><a href="UsuarioController.do?action=">Usuário</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Início da página -->
	<div class="container">
		<div class="page-header">
			<h1>Bem vindo ao UniMed</h1>
		</div>
	</div>

	<footer class="footer">
		<div class="container">
			<p class="text-muted">Sistema UniMed - UCSal_2017.1</p>
		</div>
	</footer>

	<!-- Core JS -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
