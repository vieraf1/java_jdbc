import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		Connection con = new ConnectionFactory().recuperarConexao();

		PreparedStatement st = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		st.execute();
		ResultSet rs = st.getResultSet();
		
		while(rs.next()) {
			Integer id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao = rs.getString("DESCRICAO");
			System.out.println("ID = " + id + ", Nome = " + nome + ", descrição = " + descricao);
		}
		
		st.close();
		ConnectionFactory.fecharConexao(con);
	}

}
