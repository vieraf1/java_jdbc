import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.recuperarConexao();

		Statement st = con.createStatement();
		st.execute("DELETE FROM PRODUTO WHERE ID > 4");
		
		System.out.println("quantidade de linhas removidas: " + st.getUpdateCount());
	}

}
