import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.recuperarConexao();
		con.setAutoCommit(false);
		
		try {
			PreparedStatement st = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)" ,
					Statement.RETURN_GENERATED_KEYS);
			
			adicionarValores(st, "Geladeira", "Geladeira Azul");
			adicionarValores(st, "Televis�o", "TV LG");	
			con.commit();
			
			st.close();
			ConnectionFactory.fecharConexao(con);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Executando rollback");
			con.rollback();
		}
	}

	private static void adicionarValores(PreparedStatement st, String nome, String descricao) throws SQLException {
		st.setString(1, nome);
		st.setString(2, descricao);
		
		st.execute();
		
		ResultSet rs = st.getGeneratedKeys();
		while(rs.next()) {
			Integer id = rs.getInt(1);
			
			System.out.println("Id do produto inserido na base �: " + id);
		}
	}
	
}
