package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PacienteDAO;
import model.Paciente;

@WebServlet("/PacienteController")
public class PacienteController extends HttpServlet {
	
	private PacienteDAO dao;
    private static final long serialVersionUID = 1L;
	public static final String INSERIR = "/paciente.jsp";
    public static final String LISTAR_PACIENTE = "/paciente.jsp";
    public static final String EDITAR = "/paciente.jsp";
    
    public PacienteController() {
        dao = new PacienteDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward = "";
        String action = request.getParameter("action");
 
        if(action.equalsIgnoreCase("deletar")) {
            forward = LISTAR_PACIENTE;
            int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
            dao.excluir(pacienteId);
            request.setAttribute("pacientes", dao.listarTodos());
        }
        else if(action.equalsIgnoreCase("editar")) {
            forward = EDITAR;
            int pacienteId = Integer.parseInt(request.getParameter("pacienteId"));
            Paciente paciente = dao.buscarPorId(pacienteId);
            request.setAttribute("paciente", paciente);
        }
		else if( action.equalsIgnoreCase("inserir")) {
            forward = INSERIR;
        }
        else {
            forward = LISTAR_PACIENTE;
            request.setAttribute("pacientes", dao.listarTodos());
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Paciente paciente = new Paciente();
		String pacienteId = request.getParameter("pacienteId");
        paciente.setNome(request.getParameter("nome"));
        paciente.setCpf(request.getParameter("cpf"));
        paciente.setRg(request.getParameter("rg"));
 
		if(pacienteId == null || pacienteId.isEmpty())
			dao.adicionar(paciente);
		else {
			paciente.setPacienteId(Integer.parseInt(pacienteId));
			dao.alterar(paciente);
		}
		response.sendRedirect("PacienteController.do?action=");
	}
}