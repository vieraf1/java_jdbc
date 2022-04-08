import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexao();

		System.out.println("Conectado!");
		
		ConnectionFactory.fecharConexao(con);
	}
	
}
