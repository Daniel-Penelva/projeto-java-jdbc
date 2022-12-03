package conexaoJDBCTest;

import org.junit.Test;

import dao.UsuarioDao;
import model.Usuario;

public class TestDAO {

	@Test
	public void testeCadastrarBanco() {
		Usuario usu = new Usuario();
		UsuarioDao usuDao = new UsuarioDao();
		
		usu.setId(4L);
		usu.setNome("Eduarda Andrade");
		usu.setEmail("eduarda@gmail.com");
		
		usuDao.salvar(usu);
	}
}
