package exam.library.silro;

public class Bookexam {

	public static void main(String[] args) {
		// Book(String title, String writer, String publish, int year, String isbn)
		Book book1 = new Book("제목1", "저자1", "출판사1", 2021, "abc123");
		Book book2 = new Book("제목2", "저자2", "출판사2", "abc124");

		book1.rentInfo();

		book1.rent();
		book1.rent();

		book1.turnBack();
		book1.turnBack();

		book2.rentInfo();

		Book[] books = new Book[10];
		books[0] = book1;
		books[1] = new Book("제목3", "저자3", "출판사3", "def123");
		
		books = new Book[] {book1, book2, new Book("제목4", "저자4", "출판사4", "grd143")};
	}
	
	

}
