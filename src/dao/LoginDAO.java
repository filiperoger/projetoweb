package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import model.Usuario;
import util.DBUtil;

public class LoginDAO {
	public static Usuario checkUser(String email, String senha) {
		ResultSet rs = null;
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("/db.properties");
		Usuario usuario = null;

		Properties properties = new Properties();

		try {
			properties.load(inputStream);
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			// loading drivers
			Class.forName(driver);

			// creating connection with the database
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from usuario where email=? and senha=?");
			ps.setString(1, email);
			ps.setString(2, senha);
			rs = ps.executeQuery();

			if (rs.next()) {
				usuario = new Usuario();
				usuario.setUsuarioId(rs.getInt("usuarioId"));
				usuario.setNome(rs.getString("nome"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
}