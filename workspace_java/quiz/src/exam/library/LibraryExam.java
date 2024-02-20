package exam.library;

public class LibraryExam {

	public static void main(String[] args) {
		
		Library library = new Library();
		
		Book book1 = new Book("제목1", "저자1", "출판사1", 2023, "abc123");
		Book book2 = new Book("제목2", "저자2", "출판사2", "def456");
		Book book3 = new Book("제목3", "저자3", "출판사3", "def789");
		
		Book book1_1 = book1.deepCopy();
		System.out.println("1 == 1_1 : "+ (book1 == book1_1));
		
		
		library.add(book1);
		library.add(book2);
		library.add(book3);
		library.add(book1_1);
		
		library.printCount();
		
		book1.rent();
		library.rentableList();
		
		library.searchTitle("목");
		
	}
	
	

}







