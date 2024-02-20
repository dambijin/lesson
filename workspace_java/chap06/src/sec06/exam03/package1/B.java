package sec06.exam03.package1;

// 클래스의 public은 파일명과 동일한 클래스만 허용된다
// 이렇게 하면 같은 파일이지만
// 클래스는 자바에서 알아서 새로운 파일을 생성하게 됨
// 보이는 것만 같은 파일로 보이는 것
class D {

}

public class B {

	// 필드
	A a = null;
	int a1 = 0;
	public int a2 = 10;
	private int a3 = 10;

	// 생성자
	B() {
		this.a1 = 1;
		this.a2 = 10;
		this.a3 = 100;
	}

	public B(int a1) {

	}

	private B(String s1) {

	}

	// 메소드
	void test1() {

	}

	public void test2() {

	}

}
