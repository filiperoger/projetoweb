package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Medico;
import util.DBUtil;

public class MedicoDAO {

	private Connection conn;

	public MedicoDAO() {
		conn = DBUtil.getConnection();
	}

	public void adicionar(Medico medico) {
		
		try {
			String query = "insert into medico (nome, crm) values (?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, medico.getNome());
			preparedStatement.setString(2, medico.getCrm());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Medico medico) {
		
		try {
			String query = "update medico set nome=?, crm=? where medicoId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, medico.getMedicoId());
			preparedStatement.setString(2, medico.getNome());
			preparedStatement.setString(3, medico.getCrm());
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int medicoId) {
		
		try {
			String query = "delete from medico where medicoId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, medicoId);
			
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Medico> listarTodos() {
		
		List<Medico> medicos = new ArrayList<Medico>();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from medico");
			
			while(resultSet.next()) {
				
				Medico medico = new Medico();
				medico.setMedicoId (resultSet.getInt("medicoId"));
				medico.setNome(resultSet.getString("nome"));
				medico.setCrm(resultSet.getString("crm"));

				medicos.add(medico);
			}
			
			resultSet.close();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return medicos;
	}
}