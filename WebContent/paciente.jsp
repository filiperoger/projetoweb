<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="shortcut icon" href="image/unimedicon.png">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Paciente</title>

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
				<a class="navbar-brand" href="/ProjetoFinal/index.jsp">UniMed</a>
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
			<h2>Paciente</h2>
		</div>
		<form action="PacienteController.do" method="post">
			<div class="form-group" style="margin-top: 30px;">
				<label class="col-sm-2">Matrícula:</label>
				<div class="col-sm-10">
					<input type="text" name="pacienteId" class="form-control"
						value="<c:out value="${paciente.pacienteId}" />"
						readonly="readonly" />
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="form-group" style="margin-top: 5px;">
				<label for="nome" class="col-sm-2">Nome: </label>
				<div class="col-sm-10">
					<input type="text" name="nome" class="form-control"
						value="<c:out value="${paciente.nome}" />"
						placeholder="Informe o nome" required autofocus />
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="form-group" style="margin-top: 5px;">
				<label for="nome" class="col-sm-2">CPF: </label>
				<div class="col-sm-10">
					<input type="text" name="cpf" class="form-control"
						value="<c:out value="${paciente.cpf}" />"
						placeholder="Informe o CPF" required />
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="form-group" style="margin-top: 5px;">
				<label for="nome" class="col-sm-2">RG: </label>
				<div class="col-sm-10">
					<input type="text" name="rg" class="form-control"
						value="<c:out value="${paciente.rg}" />"
						placeholder="Informe o RG" required />
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="form-group" style="margin-top: 10px;">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Salvar" class="btn btn-primary" /> <input
						type="reset" value="Cancelar" class="btn btn-primary" />
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="col-sm-12">
				<table class="table table-bordered" style="margin-top: 20px;">
					<thead>
						<tr>
							<th colspan="6" style="text-align: center;">Paciente</th>
						</tr>
						<tr>
							<th></th>
							<th></th>
							<th style="text-align: center;">Mat.</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>RG</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pacientes}" var="paciente">
							<tr>
								<td class="col-sm-1"><a
									href="PacienteController.do?action=editar&pacienteId=<c:out value="${paciente.pacienteId}"/>">Editar</a></td>
								<td class="col-sm-1"><a
									href="PacienteController.do?action=deletar&pacienteId=<c:out value="${paciente.pacienteId}"/>">Excluir</a></td>
								<td class="col-sm-1" style="text-align: center;"><c:out
										value="${paciente.pacienteId}" /></td>
								<td><c:out value="${paciente.nome}" /></td>
								<td><c:out value="${paciente.cpf}" /></td>
								<td><c:out value="${paciente.rg}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form>
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