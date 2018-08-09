package br.com.unicap.livraria;

import java.util.ArrayList;

import br.com.unicap.cadastro.Cadastro;
import br.com.unicap.livro.Livro;

public class Livraria {
	private static volatile Livraria instance;

	Cadastro lib;
	
	private Livraria() {
		this.lib = Cadastro.getInstance();
	}

	
	public static Livraria getInstance() {
		if (null == instance) {
			synchronized (Livraria.class) {
				if (null == instance) {
					instance = new Livraria();
				}
			}
		}
		return instance;
	}
	
	
	public void addBook(Livro book) {
		if (false == bookExist(book.getISBN())) { 
			lib.addBook(book);
			System.out.println("Livro adicionado com sucesso.\n");
		}
		else { System.out.println("Livro com ISBN Já cadastrado. -- " + book.getISBN() + ".\n"); }
	}
	
	public void removeBook(int isbn) {
		boolean flag = false;
		
		if (true == bookExist(isbn)) { 
			ArrayList<Livro> allBooks = this.lib.getBookList();
			
			if (null != allBooks) {
				for (Livro vBook : allBooks) {
					if (vBook.getISBN() == isbn) {
						this.lib.deleteBook(vBook);
						flag = true;
						System.out.println("Livro com ISBN " + vBook.getISBN() + " removido.\n");
					}
				}
			}
		}
		if (false == flag) { System.out.println("Livro com ISBN " + isbn + " não encontrado.\n"); }
	}
	
	public void printAll() {
		ArrayList<Livro> allBooks = this.lib.getBookList();
		
		if (null != allBooks) {
			for (Livro vBook : allBooks) {
				System.out.println(vBook);
			}
		}
	}
	
	
	public void printInfosByTitle(String title) {
		ArrayList<Livro> allBooks = this.lib.getBookList();
		
		if (null != allBooks) {
			for (Livro vBook : allBooks) {
				if (vBook.getTitle().toLowerCase().equals(title.toLowerCase())) {
					System.out.println("Autor: " + vBook.getAuthor() + "\n");
					System.out.println("Quantidade em estoque: " + vBook.getQuantity() + "\n");
					System.out.println("Valor unitário: R$ " + vBook.getPrice() + "\n\n");
				}
			}
		}
	}
	

	public void printInfosByAuthor(String author) {
		ArrayList<Livro> allBooks = this.lib.getBookList();
		
		if (null != allBooks) {
			for (Livro vBook : allBooks) {
				if (vBook.getAuthor().toLowerCase().equals(author.toLowerCase())) {
					System.out.println("Titulo: " + vBook.getTitle() + "\n");
					System.out.println("Quantidade em estoque: " + vBook.getQuantity() + "\n");
					System.out.println("Valor unitário: R$ " + vBook.getPrice() + "\n\n");
				}
			}
		}
	}
	
	public void printLowerQuantity() {
		ArrayList<Livro> allBooks = this.lib.getBookList();
		
		if (null != allBooks) {
			for (Livro vBook : allBooks) {
				if (10 > vBook.getQuantity()) {
					System.out.println(vBook);
				}
			}
		}
	}
	
	public void printCheapAndExpensiveBooks() {
		ArrayList<Livro> allBooks = this.lib.getBookList();
		Livro cheap = null;
		Livro expensive = null;
		
		if (null != allBooks) {
			for (Livro vBook : allBooks) {
				if(null == cheap) { cheap = vBook; }
				if(null == expensive) { expensive = vBook; }
				
				if (cheap.getPrice() > vBook.getPrice()) {
					cheap = vBook;
				}
				
				if (expensive.getPrice() < vBook.getPrice()) {
					expensive = vBook;
				}
			}
		}
		
		System.out.println("\nLivro mais barato\n" + cheap);
		System.out.println("\nLivro mais caro\n" + expensive);
	}
	
	
	public ArrayList<Livro> getBooks() {
		return this.lib.getBookList();
	}
	
	
	public boolean bookExist(int isbn) {
		ArrayList<Livro> allBooks = this.lib.getBookList();
		
		if (null != allBooks) {
			for (Livro vBook : allBooks) {
				if (vBook.getISBN() == isbn) { return true; }
			}
		}
		
		return false;
	}
	
}
