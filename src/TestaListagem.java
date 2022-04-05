import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.recuperarConexao();

		Statement st = con.createStatement();
		st.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		ResultSet rs = st.getResultSet();
		
		while(rs.next()) {
			Integer id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao = rs.getString("DESCRICAO");
			System.out.println("ID = " + id + ", Nome = " + nome + ", descrição = " + descricao);
		}
		
		ConnectionFactory.fecharConexao(con);
	}

}
