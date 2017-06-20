<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="shortcut icon" href="image/unimedicon.png" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form class="form-signin" action="LoginServlet" method="post">
			<h3 class="form-signin-heading">Autenticação do Usuário</h3>
			<label for="inputEmail" class="sr-only">Email</label> <input
				type="email" name="inputEmail" class="form-control"
				placeholder="Email" required autofocus> <label
				for="inputPassword" class="sr-only">Senha</label> <input
				type="password" name="inputPassword" class="form-control"
				placeholder="Senha" required>
			<button class="btn btn-primary btn-block" type="submit">Entrar</button>
		</form>
		<form action="CadastroServlet" method="post">
		<button class="btn btn-primary btn-block" type="submit">Cadastre-se</button>
		</form>
	</div>

	<!-- Core JS -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>