<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="shortcut icon" href="image/unimedicon.png">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form class="form-signin" action="CadastroServlet" method="post">
			<h3 class="form-signin-heading">Cadastro de Usuário</h3>
			
			<label for="inputNome" class="sr-only">Nome</label>
			<input type="text" name="inputNome" class="form-control" placeholder="Nome" required autofocus>
			<label for="inputEmail" class="sr-only">Email</label>
			<input type="email" name="inputEmail" class="form-control" placeholder="Email" required>
			<label for="inputPassword" class="sr-only">Senha</label>
			<input type="password" name="inputPassword" class="form-control" placeholder="Senha" required>
			
			<button class="btn btn-primary btn-block" type="submit">Cadastrar</button>
		</form>
	</div>

	<!-- Core JS -->
	<script src="bootstrap/js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>