package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicoDAO;
import model.Medico;

@WebServlet("/MedicoController")
public class MedicoController extends HttpServlet {

	private MedicoDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String INSERIR = "/medico.jsp";
	public static final String LISTAR_MEDICO = "/medico.jsp";
	public static final String EDITAR = "/medico.jsp";

	public MedicoController() {
		dao = new MedicoDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");

		if(action.equalsIgnoreCase("deletar")) {
			forward = LISTAR_MEDICO;
			int medicoId = Integer.parseInt(request.getParameter("medicoId"));
			dao.excluir(medicoId);
			request.setAttribute("medicos", dao.listarTodos());
		}
		else if(action.equalsIgnoreCase("editar")) {
			forward = EDITAR;
			int medicoId = Integer.parseInt(request.getParameter("medicoId"));
			Medico medico = dao.buscarPorId(medicoId);
			request.setAttribute("medico", medico);
<<<<<<< HEAD
=======
		}
		else if( action.equalsIgnoreCase("inserir")) {
			forward = INSERIR;
>>>>>>> c503e3c3ca010880d197a8a63876488ee0af128b
		}
		else {
			forward = LISTAR_MEDICO;
			request.setAttribute("medicos", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Medico medico = new Medico();
		String medicoId = request.getParameter("medicoId");
		medico.setNome(request.getParameter("nome"));
		medico.setCrm(request.getParameter("crm"));

		if(medicoId == null || medicoId.isEmpty())
			dao.adicionar(medico);
		else {
			medico.setMedicoId(Integer.parseInt(medicoId));
			dao.alterar(medico);
		}
		response.sendRedirect("MedicoController.do?action=");
	}
}