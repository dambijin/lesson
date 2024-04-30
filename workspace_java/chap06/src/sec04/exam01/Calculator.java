package sec04.exam01;

public class Calculator {

	/*
	 * 전원이 켜졌다는 내용을 출력함
	 * 
	 * 메소드명 : powerOn 전달인자 : 없음 리턴타입 : 없음
	 */
	void powerOn() {
		System.out.println("전원을 킵니다.");
	}

	/**
	 * 두 수를 받아 더한 결과를 돌려줌
	 * 
	 * 메소드명 : plus 전달인자 : int, int 두 정수 리턴타입 : int; 두 수를 더한 결과
	 */

	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double plus(double x, double y) {
		double result = x + y;
		return result;
	}

	// 오버로딩(== 많이 싣는 것/하나의 메소드 이름으로 여러 기능을 담는다)
	// 전달인자 타입의 개수와 순서를 다르게해서
	// 메소드 명을 동일하게 만들 수 있는 것
	int plus(int x) {
		int result = x + x + 1;
		return result;
	}

	void join(String name, int age, int a, int b, int c) {

		System.out.println("이름은 : " + name);
		System.out.println("나이는 : " + age);
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
	}

	void join(int age) {
		// 한줄로 만들어버리기 
		// join("noname", age, -1, -1, -1);
		String name = "noname";
		int a = -1;
		int b = -1;
		int c = -1;

		System.out.println("이름은 : " + name);
		System.out.println("나이는 : " + age);
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
	}

	void join(int age, String name) {

	}

	/*
	 * 두 정수를 받아서 나누기한 결과를 소수점까지 돌려줌
	 * 
	 * 메소드명 : divide 전달인자 : int 두개 리턴타입 : double; 소수점까지 결과를 출력하기 위해
	 */
	double divide(int x, int y) {
		// =을 기준으로 오른쪽게 먼저 실행되므로
		// x/y를 실행
		// (double) : int를 double타입으로 변경
		// 왜? double로 변경했나?; int를 double로 변경됨
		// 계산 결과를 result 변수에 담는다
		double result = (double) x / (double) y;

		// 결과를 돌려줌
		// result의 타입이 double이니 리턴타입도 double
		return result;
	}

	double plus_d(double x, double y) {
		double result = x + y;
		return result;
	}

	void powerOff() {
		System.out.println("전원을 끕니다.");
		// void의 경우 return 생략 가능
		// 하지만 필요한 경우 return을 이용해 메소드 종료
		// return
	}

}
