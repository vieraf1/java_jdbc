import java.sql.Connection;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class TestaInsercaoEListagemProduto {
	public static void main(String[] args) {
		Produto produto = new Produto("Estante", "Estante preta");
		
		try(Connection con = new ConnectionFactory().recuperarConexao()) {		
			ProdutoDAO produtoDao = new ProdutoDAO(con);
			produtoDao.salvar(produto);	
			List<Produto> listaProdutos = produtoDao.buscar();
			listaProdutos.stream().forEach(p -> System.out.println(p));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
