package exam.library;

import java.util.ArrayList;

// 책을 관리하는 클래스

// 책 추가
// 보유 도서 총 권수 출력
// 대여 가능한 목록
// 제목으로 검색
public class Library {

	ArrayList bookList = new ArrayList();
	
	// 책 추가
	// 전달인자 : Book
	void add(Book book) {
		
		// 추가되는 책의 제목 출력
		System.out.println("추가 도서 제목 : "+ book.title);
		
		// 도서관 책 목록에 추가
		bookList.add(book);
	}
	
	// 보유 도서 총 권수 출력
	void printCount() {
		System.out.println("보유 도서는 총: "+ bookList.size() +"권");
	}
	
	// 대여 가능한 목록
	// 각 도서마다 isRentable의 값이 true인 것만 분류
	// 리턴타입 : ArrayList; 대여 가능한 도서 목록
	ArrayList rentableList() {

		// bookList에서 하나씩 꺼내서
		// 대여 가능하면 또다른 ArrayList에 저장해놓고
		// 반복이 끝나면 return
		
		ArrayList result = new ArrayList();
		
		for(int i=0; i<bookList.size(); i++) {
			
			// bookList에서 하나씩 꺼내서
			Book book = (Book)bookList.get(i);
			
			// 대여 가능하면 
			if(book.isRentable) {
				// 또다른 ArrayList에 저장해놓고
				result.add(book);
			}
		}
		
		printBookList(result);
		
		// 반복이 끝나면 return
		return result;
	}
	
	// 제목으로 검색
	// 전달인자 : 제목
	ArrayList searchTitle(String keyword) {
		
		ArrayList result = new ArrayList();
		
		for(int i=0; i<bookList.size(); i++) {
			
			// bookList에서 하나씩 꺼내서
			Book book = (Book)bookList.get(i);
			
			// 완벽히 일치
//			if( book.title.equals(keyword) ) {
			if( book.title.indexOf(keyword) != -1 ) {
				result.add(book);
			}
		}
		
		
//		System.out.println("도서 목록");
//		System.out.print("[");
//		for(int i=0; i<result.size(); i++) {
//			
//			Book book = (Book)result.get(i);
//			String title = book.title;
//			if(i != result.size() - 1) {
//				title += ", ";
//			}
//			
//			System.out.print(title);
//		}
//		System.out.println("]");
		
		printBookList(result);

		
		return result;
	}
	
	void printBookList(ArrayList list) {
		System.out.println("도서 목록");
		System.out.print("[");
		for(int i=0; i<list.size(); i++) {
			
			Book book = (Book)list.get(i);
			String title = book.title;
			if(i != list.size() - 1) {
				title += ", ";
			}
			
			System.out.print(title);
		}
		System.out.println("]");
	}
}














