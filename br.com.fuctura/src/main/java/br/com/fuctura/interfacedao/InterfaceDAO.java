package br.com.fuctura.interfacedao;

import br.com.fuctura.models.Livro;

public interface InterfaceDAO {
	
	public void inserir(Livro livro);
	public Livro listar(Integer id);
	
}
