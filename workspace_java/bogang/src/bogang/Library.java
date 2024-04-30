package bogang;

public class Library {
	Book[] books = new Book[1000];
	
	void 추가(Book book) {
		for(int i = 0 ; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = book;
				break;
			}
		}
	}
}
