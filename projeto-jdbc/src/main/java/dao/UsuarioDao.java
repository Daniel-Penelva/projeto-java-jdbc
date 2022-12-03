package dao;

import java.sql.Connection;

import conexaoJDBC.SingleConnection;

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
	
}
