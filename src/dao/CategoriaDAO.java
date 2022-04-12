package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO {
	
	private Connection connection;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> lista = new ArrayList<>();
		
		String sql = "SELECT ID, NOME FROM CATEGORIA";
		try(PreparedStatement st = connection.prepareStatement(sql)) {
			st.execute();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()) {
				Categoria categoria = new Categoria(rs.getInt("ID"), rs.getString("NOME"));
				lista.add(categoria);
			}
			
			st.close();
		}
		return lista;
	}

}
