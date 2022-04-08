import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	public DataSource dataSource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPool = new ComboPooledDataSource();
		comboPool.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPool.setUser("root");
		comboPool.setPassword("1234");
		
		comboPool.setMaxPoolSize(15);
		
		dataSource = comboPool;
	}
	
	public Connection recuperarConexao() throws SQLException {
		return dataSource.getConnection();
	}
	
	public static void fecharConexao(Connection con) throws SQLException {
		con.close();
	}
	
}
