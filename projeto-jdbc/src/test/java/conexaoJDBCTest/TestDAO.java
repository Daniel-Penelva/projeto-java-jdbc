package conexaoJDBCTest;

import java.util.List;

import org.junit.Test;

import dao.UsuarioDao;
import model.Usuario;

public class TestDAO {

	@Test
	public void testeCadastrarBanco() {
		Usuario usu = new Usuario();
		UsuarioDao usuDao = new UsuarioDao();

		usu.setId(6L);
		usu.setNome("Miranda Nunes");
		usu.setEmail("miranda@gmail.com");

		usuDao.salvar(usu);
	}

	@Test
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

	@Test
	public void testeBuscarDados() {
		UsuarioDao usuDao = new UsuarioDao();

		try {
			Usuario usu = usuDao.buscar(4L);
			System.out.println(usu);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
