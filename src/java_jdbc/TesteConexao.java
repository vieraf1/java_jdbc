package java_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager
	            .getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC"
	            		,"root"
	            		,"1234");

		System.out.println("Conectado!");
		
	    con.close();
	}
	
}
