package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {

	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;

	public CadastroServlet() {
		dao = new UsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("inputNome"));
		usuario.setEmail(request.getParameter("inputEmail"));
		usuario.setSenha(request.getParameter("inputPassword"));

		dao.adicionar(usuario);

		response.sendRedirect("login.jsp");
	}
}