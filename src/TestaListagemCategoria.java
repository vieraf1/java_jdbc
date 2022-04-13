import java.sql.Connection;
import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;
import model.Produto;

public class TestaListagemCategoria {

	public static void main(String[] args) {
		try(Connection con = new ConnectionFactory().recuperarConexao()) {		
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			List<Categoria> categorias = categoriaDAO.listarComProdutos();
			
			for(Categoria categoria : categorias) {
				System.out.println(categoria + ": ");
				for(Produto produto : categoria.getProdutos()) {
					System.out.println(produto);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
