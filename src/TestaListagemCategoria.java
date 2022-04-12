import java.sql.Connection;
import java.util.List;

import dao.CategoriaDAO;
import model.Categoria;

public class TestaListagemCategoria {

	public static void main(String[] args) {
		try(Connection con = new ConnectionFactory().recuperarConexao()) {		
			CategoriaDAO categoriaDAO = new CategoriaDAO(con);
			List<Categoria> categorias = categoriaDAO.listar();
			
			for(Categoria categoria : categorias) {
				System.out.println(categoria);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
