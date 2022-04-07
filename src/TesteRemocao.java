import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteRemocao {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.recuperarConexao();

		PreparedStatement st = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		st.setInt(1, 4);
		st.execute();
		
		System.out.println("quantidade de linhas removidas: " + st.getUpdateCount());
		
		st.close();
		ConnectionFactory.fecharConexao(con);
	}

}
