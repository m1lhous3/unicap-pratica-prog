import java.util.Scanner;

import br.com.unicap.livraria.Livraria;
import br.com.unicap.livro.Livro;

public class Main {
	
	static private int menuKey;
	static private Scanner scan;
	static private Livraria library;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		library = Livraria.getInstance();
				
		while(true) {
			System.out.println("\n=== Livraria Ler Mais ===\n");
			System.out.println("1 - Adicionar um livro");
			System.out.println("2 - Remover um livro");
			System.out.println("3 - Exibir todos os livros");
			System.out.println("4 - Exibir livro(s) por título");
			System.out.println("5 - Exibir livro(s) por autor");
			System.out.println("6 - Exibir o livro mais caros e o livro mais barato.");
			System.out.println("7 - Exibir livro(s) com baixo estoque.");
			System.out.println("0 - Sair.");
			
			System.out.println("Insira o número da opção desejada: ");
			
			menuKey = Integer.parseInt(scan.nextLine());
			
			
			switch (menuKey) {
			case 1:
				System.out.println("Adicionar um livro.");
				addBook();
				break;
				
			case 2:
				System.out.println("Remover um livro.");
				removeBook();
				break;
				
			case 3:
				System.out.println("Exibir todos os livros.");
				printAll();
				break;
				
			case 4:
				System.out.println("Exibir livro(s) por título.");
				printByTitle();
				break;
	
			case 5:
				System.out.println("Exibir livro(s) por autor.");
				printByAuthor();
				break;
	
			case 6:
				System.out.println("Exibir o livro mais caros e o livro mais barato.");
				printCheapAndExpensiveBooks();
				break;
	
			case 7:
				System.out.println("Exibir livro(s) com baixo estoque.");
				printLowerQuantity();
				break;
				
			case 0:
				System.out.println("Saindo...");
				scan.close();
				System.exit(0);
	
			default:
				System.out.println("Opção inválida");
				break;
			}			
		}
	}
	
	
	static private void addBook() {
		int isbn;
		int quantity;
		double price;
		String title;
		String author;
		
		System.out.println("Insira o ISBN: ");
		isbn = Integer.parseInt(scan.nextLine());
		
		if (false == library.bookExist(isbn)) {
		
			System.out.println("Insira a quantidade do livro em estoque: ");
			quantity = Integer.parseInt(scan.nextLine());
			
			System.out.println("Insira o valor unitário do livro: ");
			price = Double.parseDouble(scan.nextLine());
			
			System.out.println("Insira o título do livro: ");
			title = scan.nextLine();
			
			System.out.println("Insira o autor do livro: ");
			author = scan.nextLine();
			
			Livro book = new Livro(isbn, quantity, price, title, author);
			library.addBook(book);
		} else { System.out.println("Livro com ISBN já cadastrado."); }
			
	}
	
	
	static private void removeBook() {
		int isbn;
		isbn = Integer.parseInt(scan.nextLine());
		library.removeBook(isbn);
	}
	
	
	static private void printAll() {
		library.printAll();
	}
	
	
	static private void printByTitle() {
		String title;
		title = scan.nextLine();
		library.printInfosByTitle(title.toLowerCase());
	}
	
	
	static private void printByAuthor() {
		String author;
		author = scan.nextLine();
		library.printInfosByTitle(author.toLowerCase());
	}
	
	
	static private void printCheapAndExpensiveBooks() {
		library.printCheapAndExpensiveBooks();
	}
	
	
	static private void printLowerQuantity() {
		library.printLowerQuantity();
	}
}
