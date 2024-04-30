package exam.library;

public class BookExam {

	public static void main(String[] args) {
		
		//Book(String title, String writer, String publish, int year, String isbn){
		Book book1 = new Book("제목1", "저자1", "출판사1", 2023, "abc123");
		
		book1.rentInfo();
		
		book1.rent();
		book1.rent();
		
		book1.turnBack();
		book1.turnBack();
		
		Book book2 = new Book("제목2", "저자2", "출판사2", "def456");
		book2.rentInfo();
		
		
		book1.rent();
		book2.rent();
		
		
		Book[] books = new Book[10];
		books[0] = book1;
		books[1] = new Book("제목2", "저자2", "출판사2", "def456");
		
		books = new Book[] {book1, book2, new Book("제목3", "저자3", "출판사3", "def789")};
	}

}
