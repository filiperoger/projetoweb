package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Paciente;
import util.DBUtil;

public class PacienteDAO {

	private Connection conn;

	public PacienteDAO() {
		conn = DBUtil.getConnection();
	}

	public void adicionar(Paciente paciente) {

		try {
			String query = "insert into paciente (nome, cpf, rg) values (?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setInt(2, paciente.getCpf());
			preparedStatement.setInt(3, paciente.getRg());

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Paciente paciente) {

		try {
			String query = "update paciente set nome=?, cpf=?, rg=? where pacienteId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setInt(2, paciente.getCpf());
			preparedStatement.setInt(3, paciente.getRg());
			preparedStatement.setInt(4, paciente.getPacienteId());

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int pacienteId) {

		try {
			String query = "delete from paciente where pacienteId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, pacienteId);

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Paciente> listarTodos() {

		List<Paciente> pacientes = new ArrayList<Paciente>();

		try {
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from paciente");

			while( resultSet.next() ) {

				Paciente paciente = new Paciente();
				paciente.setPacienteId (resultSet.getInt("pacienteId"));
				paciente.setNome(resultSet.getString("nome"));
				paciente.setCpf(resultSet.getInt("cpf"));
				paciente.setRg(resultSet.getInt("rg"));

				pacientes.add(paciente);
			}

			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pacientes;
	}

	public Paciente buscarPorId(int pacienteId) {

		Paciente paciente = new Paciente();

		try {

			String query = "select * from paciente where pacienteId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setInt(1, pacienteId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

				paciente.setPacienteId(resultSet.getInt( "usuarioId"));
				paciente.setNome(resultSet.getString("nome"));
				paciente.setCpf(Integer.parseInt(resultSet.getString("cpf")));
				paciente.setRg(Integer.parseInt(resultSet.getString("rg")));
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return paciente;
	}
}
