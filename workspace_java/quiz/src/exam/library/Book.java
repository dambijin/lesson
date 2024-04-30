package exam.library;

public class Book {

//	도서를 관리하는 시스템을 만들려고 합니다. 각각의 책은 여러 정보와 대여 가능 여부를 관리해야 합니다. 다음의 설계를 참고해 도서 클래스를 구현하여 도서 클래스를 사용하는 main 메소드를 이용해 실
//	행해보세요. 
//	1. 생성자를 사용해 책의 제목, 저자, 출판사, 출판년도, 고유번호를 입력 받을 수 있습니다. 
//	2. 올해 출판되는 책은 모두 출판년도가 같으므로 편의상 생성자에 출판년도가 없는 경우 “2024”년
//	을 기본값으로 가집니다. (이 경우 출판년도를 입력받는 생성자를 이용합니다.)
//	3. 대여 가능 여부를 확인하는 메소드를 구현하세요. 대여 가능 여부를 true/false로 관리하는 필드
//	에 따라 가능/불가능이 출력되게 구현하세요
//	4. 대여 메소드를 구현하세요. 대여가 가능한 경우 대여 가능 여부를 변경해서 저장하세요. 그래야 
//	다음에 대출을 막을 수 있습니다. 대여가 불가능한 경우 불가능하다는 메시지를 출력하세요. 
//	5. 반납 메소드를 구현하세요. 반납이 완료되었다는 메시지가 출력되고 대여 가능 여부를 변경해서 
//	저장해 두세요. 대여한 적이 없다면 반납이 불가능하다는 메시지를 출력하세요
	
	
	String title;	// 제목
	String writer;	// 저자
	String publish;	// 출판사
	int year;		// 출판년도
	String isbn;	// 고유번호

	boolean isRentable = true;	// 대여 가능 여부; true:대여 가능, false:대여 불가능

//	Book(){
//		System.out.println();
//	}
	
	// 1. 생성자를 사용해 책의 제목, 저자, 출판사, 출판년도, 고유번호를 입력 받을 수 있습니다. 2. 올해 출판되는 책은 모두 출판년도가 같으므로 편의상 생성자에 출판년도가 없는 경우 “2024”년
	Book(String title, String writer, String publish, int year, String isbn){
		System.out.println("1 생성자 실행");
//		System.out.println("제목title : "+ title);
//		System.out.println("writer : "+ writer);
		
		this.title = title;
		this.writer = writer;
		this.publish = publish;
		this.year = year;
		this.isbn = isbn;
	}

//	2. 올해 출판되는 책은 모두 출판년도가 같으므로 
//	편의상 생성자에 출판년도가 없는 경우 “2024”년을 기본값으로 가집니다. 
//	(이 경우 출판년도를 입력받는 생성자를 이용합니다.)
	Book(String title, String writer, String publish, String isbn){
		// 미리 만들어 놓은 생성자 호출해서 떠넘기기
		// 유지보수면에서 좋다
		// 왜냐면 한군데에 몰아둬서 하나만 수정해도 되니까
		// 다른 생성자를 호출하는 this()는 가장 먼저 실행되야 함
		this(title, writer, publish, 2024, isbn);
		System.out.println("2 생성자 실행");
	}

//	3. 대여 가능 여부를 확인하는 메소드를 구현하세요. 
//	대여 가능 여부를 true/false로 관리하는 필드에 따라
//	가능/불가능이 출력되게 구현하세요
	// 메소드명 : rentInfo
	// 전달인자 : 없음
	// 리턴타입 : 없음
	void rentInfo() {
		System.out.println("title : "+ title);
		System.out.println("writer : "+ writer);
		System.out.println("publish : "+ publish);
		System.out.println("year : "+ year);
		System.out.println("isbn : "+ isbn);
		
//		if(isRentable == true) {
		if(this.isRentable) {
			System.out.println("대여 가능");
		} else {
			System.out.println("대여 불가능");
		}
	}
	
//	4. 대여 메소드를 구현하세요. 
//	대여가 가능한 경우 대여 가능 여부를 변경해서 저장하세요. 
//	그래야 다음에 대출을 막을 수 있습니다. 
//	대여가 불가능한 경우 불가능하다는 메시지를 출력하세요. 
	void rent() {
		// 대여가 가능한 경우
		if(this.isRentable) {
			System.out.println(this.title +" 책을 대여 합니다");
			this.isRentable = false;	// 대여 중으로 상태 변환
		} else {
			System.out.println(this.title +" 이 책은 이미 대여 중입니다");
		}
	}
	
//	5. 반납 메소드를 구현하세요. 
//	반납이 완료되었다는 메시지가 출력되고 대여 가능 여부를 변경해서 저장해 두세요.
//	대여한 적이 없다면 반납이 불가능하다는 메시지를 출력하세요
	void turnBack() {
		// 대여 중 이라면
//		if(this.isRentable == false) {
		if(!this.isRentable) {
			System.out.println(this.title +" 책을 반납합니다");
			this.isRentable = true;		// 대여 가능 상태로 변경
		} else {
			System.out.println(this.title +" 이 책은 대여한 적이 없어 반납할 수 없습니다");
		}
	}
	
	
	// Book 클래스 깊은 복사 메소드
	// 메소드명 : deepCopy
	// 전달인자 : Book(얕은 복사)
	// 리턴타입 : Book(깊은 복사 된 결과물의 얕은 복사)
	Book deepCopy(Book b) {
		Book newBook = new Book(b.title, 
							b.writer, 
							b.publish, 
							b.year, 
							b.isbn);
		return newBook;
	}

	// Book 클래스 깊은 복사 메소드
	// 메소드명 : deepCopy
	// 전달인자 : Book(얕은 복사)
	// 리턴타입 : Book(깊은 복사 된 결과물의 얕은 복사)
	Book deepCopy() {
		Book newBook = new Book(this.title, 
							this.writer, 
							this.publish, 
							this.year, 
							this.isbn);
		return newBook;
	}

}
