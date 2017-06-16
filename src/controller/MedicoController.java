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
	public static final String LISTAR_MEDICO = "/todosMedicos.jsp";
	public static final String EDITAR = "/editarMedicos.jsp";

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
		}
		else if( action.equalsIgnoreCase( "inserir" ) ) {
            forward = INSERIR;
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
        medico.setNome(request.getParameter("nome"));
        medico.setCrm(request.getParameter("crm"));
 
        if( medico.getMedicoId() == 0)
            dao.adicionar(medico);
        else {
            dao.alterar(medico);
        }
        response.sendRedirect("login.jsp");
    }
}