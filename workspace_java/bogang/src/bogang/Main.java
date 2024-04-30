package bogang;

public class Main {
	public static void main(String[] args) {
		Library library = new Library();
		
		Book book1 = new Book("가");
		Book book2 = new Book("나");
		library.추가(book1);
		library.추가(book2);
		
		System.out.println(library.books[0].title);
		System.out.println(library.books[1].title);
	}
}
