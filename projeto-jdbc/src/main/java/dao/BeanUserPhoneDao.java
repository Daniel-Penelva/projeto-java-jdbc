package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoJDBC.SingleConnection;
import model.BeanUserPhone;

public class BeanUserPhoneDao {

	private Connection connection;

	public BeanUserPhoneDao() {
		connection = SingleConnection.getConnection();
	}

	// Buscar pelo id
	public List<BeanUserPhone> buscarUserPhone(Long id) {

		List<BeanUserPhone> lista = new ArrayList<BeanUserPhone>();
		String sql = "select nome, numero, email from telefone as t inner join usuario as u on t.usuariopessoa = u.id where u.id = "
				+ id;

		/**
		 * Pode fazer concatenando tb - exemplo: 
		 * String sql = "select nome, numero, email from telefone as t"; 
		 * sql += " inner join usuario as u"; 
		 * sql += " on t.usuariopessoa = u.id"; 
		 * sql += " where u.id = " + id";
		 */

		try {
			PreparedStatement prepararSql = connection.prepareStatement(sql);
			ResultSet rs = prepararSql.executeQuery();

			while (rs.next()) {
				BeanUserPhone userPhone = new BeanUserPhone();
				userPhone.setNome(rs.getString("nome"));
				userPhone.setTelefone(rs.getString("numero"));
				userPhone.setEmail(rs.getString("email"));

				lista.add(userPhone);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	// Listar todos
	public List<BeanUserPhone> listarUserPhone() {

		List<BeanUserPhone> lista = new ArrayList<BeanUserPhone>();

		String sql = "select nome, numero, email from telefone as t";
		sql += " inner join usuario as u";
		sql += " on t.usuariopessoa = u.id";

		try {
			PreparedStatement preparandoSql = connection.prepareStatement(sql);
			ResultSet rs = preparandoSql.executeQuery();

			while (rs.next()) {
				BeanUserPhone userPhone = new BeanUserPhone();
				userPhone.setNome(rs.getString("nome"));
				userPhone.setTelefone(rs.getString("numero"));
				userPhone.setEmail(rs.getString("email"));
				
				lista.add(userPhone);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Lista mostrada com sucesso!");
		return lista;
	}

}
