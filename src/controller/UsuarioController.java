package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet{

	private UsuarioDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String INSERIR = "/usuario.jsp";
	public static final String LISTAR_USUARIO = "/usuario.jsp";
	public static final String EDITAR = "/usuario.jsp";

	public UsuarioController() {
		dao = new UsuarioDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("deletar")) {
			forward = LISTAR_USUARIO;
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
			dao.excluir(usuarioId);
			request.setAttribute("usuarios", dao.listarTodos());
		}
		else if(action.equalsIgnoreCase("editar")) {
			forward = EDITAR;
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
			Usuario usuario = dao.buscarPorId(usuarioId);
			request.setAttribute("usuario", usuario);
		}
		else if(action.equalsIgnoreCase("inserir")) {
			forward = INSERIR;
		}
		else {
			forward = LISTAR_USUARIO;
			request.setAttribute("usuarios", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Usuario	usuario = new Usuario();
        String usuarioId = request.getParameter("usuarioId");
		usuario.setNome(request.getParameter("nome"));
		usuario.setEmail(request.getParameter("email"));
		usuario.setSenha(request.getParameter("senha"));
        
        if(usuarioId == null || usuarioId.isEmpty())
            dao.adicionar(usuario);
        else {
            usuario.setUsuarioId(Integer.parseInt(usuarioId));
            dao.alterar(usuario);
        }
		response.sendRedirect("UsuarioController.do?action=");
	}
}