package br.com.unicap.cadastro;

import java.util.ArrayList;
import br.com.unicap.livro.Livro;

public class Cadastro {
	private static volatile Cadastro instance;
	
	ArrayList<Livro> bookList;

	private Cadastro() {
		this.bookList = new ArrayList<Livro>();
	}

	public static Cadastro getInstance() {
		if (null == instance) {
			synchronized (Cadastro.class) {
				if (null == instance) {
					instance = new Cadastro();
				}
			}
		}
		return instance;
	}

	public ArrayList<Livro> getBookList() {
		return bookList;
	}

	public void addBook(Livro book) {
		this.bookList.add(book);
	}
	
	public void deleteBook(Livro book) {
		this.bookList.remove(book);
	}
	
	
}
