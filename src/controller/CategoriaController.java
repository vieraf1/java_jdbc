package controller;

import java.sql.Connection;
import java.util.List;

import dao.CategoriaDAO;
import factory.ConnectionFactory;
import model.Categoria;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;
	
	public CategoriaController() {
		Connection con = new ConnectionFactory().recuperarConexao();
		categoriaDAO = new CategoriaDAO(con);
	}

	public List<Categoria> listar() {
		return categoriaDAO.listar();
	}
}
