package exam.library.silro;

public class Libraryexam {

	public static void main(String[] args) {

		Library library = new Library();

		Book book1 = new Book("제목1", "저자1", "출판사1", 2021,  "abc123");
		Book book2 = new Book("제목2", "저자2", "출판사2", "abc124");
		Book book3 = new Book("제목3", "저자3", "출판사3", "def123");
		Book book4 = new Book("제목4", "저자4", "출판사4", "def123");

		library.printCount();
		
		library.add(book1);
		library.add(book2);
		library.add(book3);
		library.add(book4);

		library.printCount();

		book1.rent();
		// book1은 빌려서 도서 목록에 안나타날것임
		library.rentableList();
		
	
		
		
	}

	
}
