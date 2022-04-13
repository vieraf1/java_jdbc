package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Categoria;
import model.Produto;

public class ProdutoDAO {

	private Connection connection;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Produto produto) {
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		try(PreparedStatement st = connection.prepareStatement(sql,	Statement.RETURN_GENERATED_KEYS)) {
			
			st.setString(1, produto.getNome());
			st.setString(2, produto.getDescricao());
			
			st.execute();

			try(ResultSet rs = st.getGeneratedKeys()) {
				while(rs.next()) {
					produto.setId(rs.getInt(1));
				}	
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Produto> buscar() throws SQLException {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO";
		try(PreparedStatement st = connection.prepareStatement(sql)) {
			st.execute();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"));
				lista.add(produto);
			}
			
			st.close();
		}
		return lista;
	}

	public List<Produto> listasPorCategoria(Categoria categoria) throws SQLException {
		List<Produto> lista = new ArrayList<>();
		String sql = "SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE CATEGORIA_ID = ?";
		try(PreparedStatement st = connection.prepareStatement(sql)) {
			st.setInt(1, categoria.getId());
			st.execute();
			ResultSet rs = st.getResultSet();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"));
				lista.add(produto);
			}
			
			st.close();
		}
		return lista;
	}
}
