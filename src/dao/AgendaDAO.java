package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Agenda;
import util.DBUtil;

public class AgendaDAO {

	private Connection conn;

	public AgendaDAO() {
		conn = DBUtil.getConnection();
	}

	public void adicionar(Agenda agenda) {
		
		try {
			String query = "insert into agenda (data, hora, pacienteId, medicoId) values (?, ?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, agenda.getData());
			preparedStatement.setString(2, agenda.getHora());
			preparedStatement.setInt(3, agenda.getPaciente().getPacienteId());
			preparedStatement.setInt(4, agenda.getMedico().getMedicoId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Agenda agenda) {
		
		try {
			String query = "update agenda set data=?, hora=?, pacienteId=?, medicoId=? where agendaId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, agenda.getData());
			preparedStatement.setString(2, agenda.getHora());
			preparedStatement.setInt(3, agenda.getPaciente().getPacienteId());
			preparedStatement.setInt(4, agenda.getMedico().getMedicoId());
			preparedStatement.setInt(5, agenda.getAgendaId());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int agendaId) {
		
		try {
			String query = "delete from agenda where agendaId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, agendaId);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Agenda> listarTodos() {
		
		List<Agenda> agendas = new ArrayList<Agenda>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from agenda");
			
			while(resultSet.next()) {
				
				Agenda agenda = new Agenda();
				agenda.setAgendaId (resultSet.getInt("agendaId"));
				agenda.setData(resultSet.getString("data"));
				agenda.setHora(resultSet.getString("hora"));
			    agenda.setPaciente(new PacienteDAO().buscarPorId(resultSet.getInt("pacienteId")));
                agenda.setMedico(new MedicoDAO().buscarPorId(resultSet.getInt("medicoId")));
				
				agendas.add(agenda);
			}
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agendas;
	}
	
	public Agenda buscarPorId(int agendaId) {

		Agenda agenda = new Agenda();

		try {

			String query = "select * from agenda where agendaId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setInt(1, agendaId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

				agenda.setAgendaId (resultSet.getInt("agendaId"));
				agenda.setData(resultSet.getString("data"));
				agenda.setHora(resultSet.getString("hora"));
                agenda.setPaciente(new PacienteDAO().buscarPorId(resultSet.getInt("pacienteId")));
                agenda.setMedico(new MedicoDAO().buscarPorId(resultSet.getInt("medicoId")));
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agenda;
	}
}