package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import dao.UsuarioDAO;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	
	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;

	public CadastroServlet() {
		dao = new UsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));

		if(usuario.getUsuarioId() == 0){
			dao.adicionar(usuario);
		}
		else {
			dao.alterar(usuario);
		}
		response.sendRedirect("login.jsp");
	}
}