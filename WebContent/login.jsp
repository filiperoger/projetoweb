<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/bootstrap/css/sticky-footer-navbar.css" rel="stylesheet">
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
	</div>

	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/bootstrap/js/jquery.min.js"></script>
	<script	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>