package conexaoJDBCTest;

import org.junit.Test;

import conexaoJDBC.SingleConnection;

public class SingleConnectionTest {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}
}
