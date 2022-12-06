package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoJDBC.SingleConnection;
import model.Usuario;

/**
 * A função do DAO é gerenciar os objetos do banco de dados. 
 * Para cada tipo de entidade cria-se um DAO. 
 * A classe de conexão tem um vinculo com a classe dao para que seja possivel o acesso ao BD. 
 * Portanto, o UsuarioDao precisa de um connection, isto é, ele é ativado através do método getConnection(). 
 * É na classe dao que vai ser manipulado a linguagem sql, através do comando "preparedStatement". 
 * Então, o sql preparado vai para a connection que terá a função de inserir no BD. 
 * ResultSet é um objeto capaz de guardar e buscar resultados no banco. 
 * Todos os dados criados e manipulados estarão dentro do ResultSet. 
 * No UsuarioDAO é feito um "execute()" para retornar um boolean, 
 * entretanto, com o ResultSet é usado o "executeQuery()", 
 * uma vez que retorna todos os resultados da consulta. 
 * Para extrair o resultado linha por linha dentro do resultSet é add o objeto usuário correspondente para ele.
 */

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		connection = SingleConnection.getConnection();
	}

	// Cadastrar um usuário
	public void salvar(Usuario usuario) {

		String sql = "INSERT INTO USUARIO(nome, email)VALUES(?,?)";

		try {
			PreparedStatement inserir = connection.prepareStatement(sql);
			inserir.setString(1, usuario.getNome());
			inserir.setString(2, usuario.getEmail());
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

	// Listar os usuários
	public List<Usuario> listar() throws Exception {
		List<Usuario> list = new ArrayList<Usuario>();

		String sql = "select * from usuario";

		PreparedStatement buscar = connection.prepareStatement(sql);
		ResultSet resultado = buscar.executeQuery();

		// Enquanto existir usuario add na lista retorna os valores.
		while (resultado.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(resultado.getLong("id"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setEmail(resultado.getString("email"));

			list.add(usuario);
		}

		System.out.println("Lista mostrada com sucesso!");

		return list;
	}

	// Buscar o usuário através do id
	public Usuario buscar(Long id) throws Exception {

		Usuario buscarUsuario = new Usuario();

		String sql = "select * from usuario where id = " + id;

		PreparedStatement buscar = connection.prepareStatement(sql);
		ResultSet resultado = buscar.executeQuery();

		// Enquanto estiver usuario retorna o valor
		while (resultado.next()) {

			buscarUsuario.setId(resultado.getLong("id"));
			buscarUsuario.setNome(resultado.getString("nome"));
			buscarUsuario.setEmail(resultado.getString("email"));
		}

		return buscarUsuario;
	}

	// Atualizar dados do usuário
	public void atualizar(Usuario usuario) {

		try {
			String sql = "update usuario set nome = ?, email = ? where id = " + usuario.getId();
			PreparedStatement atualizar = connection.prepareStatement(sql);
			atualizar.setString(1, usuario.getNome());
			atualizar.setString(2, usuario.getEmail());
			atualizar.execute();
			connection.commit();

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
