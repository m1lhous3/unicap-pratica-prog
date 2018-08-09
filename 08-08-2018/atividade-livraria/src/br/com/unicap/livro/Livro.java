package br.com.unicap.livro;


public class Livro {

	private int ISBN;
	private int quantity;
	private double price;
	private String title;
	private String author;
	
	public Livro(int isbn, int quantity, double price, String title, String author) {
		this.ISBN = isbn;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "ISBN: " + this.ISBN + "\n" +
				"Título: " + this.title + "\n" +
				"Autor(a/es): " + this.author + "\n" +
				"Quantidade em estoque: " + this.quantity + "\n" +
				"Preço unitário: " + this.price + "\n\n";
	}
	
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		this.ISBN = iSBN;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
