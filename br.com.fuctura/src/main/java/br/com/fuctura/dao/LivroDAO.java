package br.com.fuctura.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fuctura.interfacedao.InterfaceDAO;
import br.com.fuctura.models.Livro;

public class LivroDAO implements InterfaceDAO {
	
	private EntityManagerFactory emf;
	
	public LivroDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@Override
	public void inserir(Livro livro) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			
			em.close();
			
			System.out.println("\nLivro inserido com sucesso!");
		}catch(Exception e) {
			System.out.println("\nErro ao inserir livro!");
		}
		
	}

	@Override
	public Livro listar(Integer id) {
		Livro livro = null;
		
		try {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		livro = em.find(Livro.class, id);
		
		em.getTransaction().commit();
		em.close();
		
		if(livro != null) {
			System.out.println("Livro encontrado:" + livro.toString());
		}else {
			System.out.println("Nenhum livro encontrado com o Id:" + id);
		}
		
	}catch(Exception e) {
		System.out.println("Erro ao buscar livro:" + e.getMessage());
	}
	
	return livro;
	}
}
