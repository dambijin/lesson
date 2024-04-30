package test03;

public class Book1 {

	String title; // 제목
	String name; // 저자
	String publisher; // 출판사
	String year; // 출판년도
	String number; // 고유번호
	// 3. 대여 가능 여부를 확인하는 메소드를 구현하세요.
	// 대여 가능 여부를 true/false로 관리하는 필드에 따라 가능/불가능이 출력되게 구현하세요
	boolean borrow = false; // 대여가능상태

	Book1(String title, String name, String publisher, String year, String number) {
		this.title = title;
		this.name = name;
		this.publisher = publisher;
		// 2번. 생성자에 출판년도가 없는 경우 “2024”년을 기본값으로 가집니다
		// year==""; 이렇게 쓰면 안됨 
		if (year.equals("")) {
			this.year = "2024";
		} else {
			this.year = year;
		}
		this.number = number;

		System.out.println("제목 : " + this.title);
		System.out.println("저자 : " + this.name);
		System.out.println("출판사 : " + this.publisher);
		System.out.println("출판년도 : " + this.year);
		System.out.println("고유번호 : " + this.number);
	}

	// 4. 대여 메소드를 구현하세요. 대여가 가능한 경우 대여 가능 여부를 변경해서 저장하세요.
	// 그래야 다음에 대출을 막을 수 있습니다. 대여가 불가능한 경우 불가능하다는 메시지를 출력하세요
	void bor() {
		// if (this.borrow == false) 와 같다
		if (!borrow) {
			System.out.println("대여 했습니다.");	
			this.borrow = true;
		} else {
			System.out.println("대여 불가능합니다.");
			
		}
	}

	// 5. 반납 메소드를 구현하세요. 반납이 완료되었다는 메시지가 출력되고 대여 가능 여부를 변경해서
	// 저장해 두세요. 대여한 적이 없다면 반납이 불가능하다는 메시지를 출력하세요
	void ret() {
		if (this.borrow == true) {
			System.out.println("반납이 완료되었습니다.");
			this.borrow = false;
		} else {
			System.out.println("반납 불가능");
		}
	}

}
