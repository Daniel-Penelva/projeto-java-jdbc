package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoJDBC.SingleConnection;
import model.Usuario;

/**
 * A função do DAO é gerenciar os objetos do banco de dados.
 * Para cada tipo de entidade cria-se um DAO.
 * A classe de conexão tem um vinculo com a classe dao para que seja possivel o acesso ao BD.
 * Portanto, o UsuarioDao precisa de um connection, isto é, ele é ativado através do método getConnection().
 * É na classe dao que vai ser manipulado a linguagem sql, através do comando "preparedStatement".
 * Então, o sql preparado vai para a connection que terá a função de inserir no BD.
 * */

public class UsuarioDao {

	private Connection connection;
	
	public UsuarioDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Usuario usuario) {
		
		String sql = "INSERT INTO USUARIO(id, nome, email)VALUES(?,?,?)";
		
		try {
			PreparedStatement inserir = connection.prepareStatement(sql);
			inserir.setLong(1, usuario.getId());
			inserir.setString(2, usuario.getNome());
			inserir.setString(3, usuario.getEmail());
			inserir.execute();
			connection.commit();
			System.out.println("Cadastrado com sucesso!");
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
}
