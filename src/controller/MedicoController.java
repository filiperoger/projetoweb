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
	public static final String INSERIR = "/pages/medico.jsp";
	public static final String LISTAR_MEDICO = "/todosMedicos.jsp";
	public static final String EDITAR = "/editarMedicos.jsp";

	public MedicoController() {
		dao = new MedicoDAO();
	}

	//    public MedicoController() {
	//        super();
	//        // TODO Auto-generated constructor stub
	//    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

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
			request.setAttribute("usuario", medico);
		}
		else if( action.equalsIgnoreCase( "inserir" ) ) {
            forward = INSERIR;
        }
		else {
			forward = LISTAR_MEDICO;
			request.setAttribute("usuarios", dao.listarTodos());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		Medico medico = new Medico();
        medico.setNome(request.getParameter("nome"));
        medico.setCrm(request.getParameter("crm"));
        // usuario.setEmail(request.getParameter("email"));
        // usuario.setSenha(request.getParameter("senha"));
//        String usuarioId = request.getParameter("usuarioId");
 
        if( medico.getMedicoId() == 0)
            dao.adicionar(medico);
        else {
//            usuario.setUsuarioId(Integer.parseInt(usuarioId));
            dao.alterar(medico);
        }
        response.sendRedirect("pages/login.jsp");
    }

}
