package conexaoJDBCTest;

import java.util.List;
import org.junit.Test;
import dao.UsuarioDao;
import model.Usuario;

public class TestDAO {

	// @Test
	public void testeCadastrarBanco() {
		Usuario usu = new Usuario();
		UsuarioDao usuDao = new UsuarioDao();

		usu.setNome("Caio Marques");
		usu.setEmail("caio@gmail.com");

		usuDao.salvar(usu);
	}

	// @Test
	public void testeListarBanco() {
		UsuarioDao usuDao = new UsuarioDao();
		try {
			List<Usuario> list = usuDao.listar();

			for (Usuario usu : list) {
				// imprimi o toString
				System.out.println(usu);
				System.out.println("------------------------------------");
			}

			for (Usuario usu : list) {
				// imprimi o id e o nome
				System.out.println("Nome: " + usu.getNome() + " - id: " + usu.getId());
				System.out.println("------------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Test
	public void testeBuscarDados() {

		try {
			UsuarioDao usuDao = new UsuarioDao();
			Usuario usu = usuDao.buscar(7L);

			if (usu.getId() != null) {
				System.out.println(usu);
			} else {
				System.out.println("Usuário não encontrado!");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	// @Test
	public void testeAtualizarBanco() {

		try {

			UsuarioDao usuDao = new UsuarioDao();

			// Tem que buscar o id do usuário através do método de busca.
			Usuario usu = usuDao.buscar(5L);

			if (usu.getId() != null) {

				usu.setNome("Helena Peres");
				usu.setEmail("helena@gmail.com");

				usuDao.atualizar(usu);

				System.out.println("Usuário alterado - para:");
				System.out.println("Nome: " + usu.getNome() + " - email: " + usu.getEmail());
			} else {
				System.out.println("Usuário não encontrado para alteração!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testeDeletarUsuarioBanco() {
		try {

			UsuarioDao usuDao = new UsuarioDao();
			Usuario usu = new Usuario();

			usuDao.deletar(7L);
		} catch (Exception e) {

		}
	}

	@Test
	public void TesteDeletarUsuarioBanco1() {

		Usuario usu = new Usuario();
		usu.setId(6L);

		if (usu.getId() != null) {
			UsuarioDao usuDao = new UsuarioDao();
			usuDao.deletar1(usu);
			System.out.println("Deletado com sucesso!");
		} else {
			System.out.println("Usuário não existe no banco de dados!");
		}
	}
}
