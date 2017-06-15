package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import util.DBUtil;

public class UsuarioDAO{

	private Connection conn;

	public UsuarioDAO() {
		conn = DBUtil.getConnection();
	}

	public void adicionar(Usuario usuario) {

		try {

			String query = "insert into usuario (nome, email, senha) values (?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterar(Usuario usuario) {

		try {

			String query = "update usuario set nome=?, email=?, senha=? where usuarioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, usuario.getNome());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getSenha());
			preparedStatement.setInt(4, usuario.getUsuarioId());

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int usuarioId) {

		try {

			String query = "delete from usuario where usuarioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setInt(1, usuarioId);

			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> listarTodos() {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from usuario");

			while(resultSet.next()) {

				Usuario usuario = new Usuario();
				usuario.setUsuarioId (resultSet.getInt("usuarioId"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));

				usuarios.add(usuario);
			}

			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public Usuario buscarPorId(int usuarioId) {

		Usuario usuario = new Usuario();

		try {

			String query = "select * from usuario where usuarioId=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setInt(1, usuarioId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

				usuario.setUsuarioId(resultSet.getInt( "usuarioId"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
			}

			resultSet.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}