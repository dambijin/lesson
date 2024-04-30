package sec06.exam03.package2;

// import sec06.exam03.package1.A;
import sec06.exam03.package1.B;

public class C {
	// A는 defalt 접근제한자를 가져서 (=public이 없어서)
	// C에선 이용 불가
	// A a = null;
	B b = null;

//	piblic, defalt 접근제한자
//	클래스, 필드, 생성자, 메소드에서 사용가능
//	privat 접근제한자
//	필드, 생성자, 메소드에서 사용가능(클래스에서는 사용 못함)

	// B()는 defalt 접근제한자를 가져서
	// B b1 = new B();
	// B(int)는 public 접근 제한자를 가지므로
	B b2 = new B(2);

	C() {
		// defalt 접근제한자여서 못씀
//		b2.a1=3;
		b2.a2 = 3;
		// private 접근제한자여서 못씀
//		b2.a3=3;

	}

}
