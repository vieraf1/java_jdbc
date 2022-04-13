package model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + "]";
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adicionar(Produto produto) {
	    produtos.add(produto);
	}
}
