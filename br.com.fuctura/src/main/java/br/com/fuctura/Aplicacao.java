package br.com.fuctura;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fuctura.dao.LivroDAO;
import br.com.fuctura.models.Escritor;
import br.com.fuctura.models.Livro;

public class Aplicacao {
	
	public static int leiaInt(String num) {
		 int n = 0;
		while(true) {
			try {
				n = Integer.valueOf(num);
			}catch(Exception e) {
				System.out.println("Erro, digite apenas números inteiros!");
			}
			return n;
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meu-persistence-unit");
		
		Scanner scan = new Scanner(System.in);
		int opc;
		
		System.out.println("\nEscolha a opção");

		System.out.println("|---------------------------|");
		System.out.println("|   1 - Inserir Livro       |");
		System.out.println("|   2 - Listar livro        |");
		System.out.println("|---------------------------|");
		System.out.println("|---------------------------|");
		System.out.println("|---------------------------|");
		System.out.println("|---------------------------|");
		System.out.println("|---------------------------|");

		System.out.println("Opção:");
		opc = leiaInt(scan.nextLine());
		
		if(opc == 1) {
			br.com.fuctura.models.Escritor escritor = new Escritor();
			
			Livro livro = new Livro();
			

			System.out.println("\nDigite o título do livro ");
			livro.setTitulo(scan.nextLine());

			System.out.println("\nDigite o gênero do livro ");
			livro.setGenero(scan.nextLine());

			System.out.println("\nDigite a editora do livro ");
			livro.setEditora(scan.nextLine());

			System.out.println("\nDigite o nome do escritor ");
			escritor.setNome(scan.nextLine());

			System.out.println("\nDigite a nacionalidade do escritor ");
			escritor.setNacionalidade(scan.nextLine());

			System.out.println("\nDigite o e-mail do escritor ");
			escritor.setEmail(scan.nextLine());
			
			livro.setEscritor(escritor);
			
			LivroDAO lf = new LivroDAO(emf);
			
			lf.inserir(livro);
			
		}
	}
	
}
