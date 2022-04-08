import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		try(Connection con = new ConnectionFactory().recuperarConexao()){
			con.setAutoCommit(false);
			try(PreparedStatement st = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)" ,
					Statement.RETURN_GENERATED_KEYS)) {
				
				adicionarValores(st, "Geladeira", "Geladeira Azul");
				adicionarValores(st, "Televisão", "TV LG");	
				con.commit();
				
				st.close();
				ConnectionFactory.fecharConexao(con);
				System.out.println("Insert Executando com sucesso!");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Executando rollback");
				con.rollback();
			}
		}
	}

	private static void adicionarValores(PreparedStatement st, String nome, String descricao) throws SQLException {
		try(ResultSet rs = st.getGeneratedKeys()) {
			st.setString(1, nome);
			st.setString(2, descricao);
			
			st.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
