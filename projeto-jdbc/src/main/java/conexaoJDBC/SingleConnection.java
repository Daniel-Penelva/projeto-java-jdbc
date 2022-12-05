package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5433/projetoJDBC"; // referencia o banco de dados postgresql
	private static String password = "admin"; // referencia a senha do usuario
	private static String user = "postgres"; // referencia o usuario
	private static Connection connection = null;
	
	static {
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if(connection == null) {
				/* Carregar o drive do JDBC*/
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false); // Para não comitar automaticamente
				
				System.out.println("Banco conectado!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
