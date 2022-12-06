package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoJDBC.SingleConnection;
import model.Telefone;

public class TelefoneDao {

	private Connection connection;

	public TelefoneDao() {
		connection = SingleConnection.getConnection();
	}

	// Cadastrar um telefone
	public void salvar(Telefone telefone) {

		String sql = "INSERT INTO telefone(numero, tipo, usuariopessoa) VALUES (?, ?, ?)";

		try {
			PreparedStatement inserir = connection.prepareStatement(sql);
			inserir.setString(1, telefone.getNumero());
			inserir.setString(2, telefone.getTipo());
			inserir.setLong(3, telefone.getFk_pessoa());
			inserir.execute();
			connection.commit();
			System.out.println("Telefone cadastrado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
