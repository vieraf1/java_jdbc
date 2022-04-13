package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Produto;

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

	public List<Categoria> listarComProdutos() throws SQLException {
		Categoria ultimo = null;
		List<Categoria> lista = new ArrayList<>();
		
		String sql = "SELECT C.ID, C.NOME, P.ID, P.NOME, P.DESCRICAO "
				+ "   FROM CATEGORIA C"
				+ "   INNER JOIN PRODUTO P ON P.CATEGORIA_ID = C.ID";
		try(PreparedStatement st = connection.prepareStatement(sql)) {
			st.execute();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()) {
				if(ultimo == null || !ultimo.getNome().equals(rs.getString(2))) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					ultimo = categoria;
					lista.add(categoria);
				}
				Produto produto = new Produto(rs.getInt(3), rs.getString(4), rs.getString(5));
				ultimo.adicionar(produto);
			}
			
			st.close();
		}
		return lista;
	}

}
