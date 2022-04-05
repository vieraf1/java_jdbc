import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		Connection con = ConnectionFactory.recuperarConexao();
		
		PreparedStatement st = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)" ,
				Statement.RETURN_GENERATED_KEYS);
		st.setString(1, "Fone de Ouvido");
		st.setString(2, "Fone de Ouvido");
		
		st.execute();
		
		ResultSet rs = st.getGeneratedKeys();
		while(rs.next()) {
			Integer id = rs.getInt(1);
			
			System.out.println("Id do produto inserido na base é: " + id);
		}
		
		ConnectionFactory.fecharConexao(con);
	}
	
}
