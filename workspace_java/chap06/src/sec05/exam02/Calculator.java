package sec05.exam02;

public class Calculator {
	static double pi = 3.14159;
	int a = 10;

	Calculator() {
		this.a = 20;
	}

	static int plus(int x, int y) {
		// static안에서 this는 사용 불가
		// this는 new를 해야지만 생성됨.
		// new는 아직 없기 때문에 사용 불가
		return x + y;
	}

	static int minus(int x, int y) {
		return x - y;
	}

	// 원의 둘레 : 2*파이*반지름
	double circle(int r) {
		plus(r,r);
		return 2 * r * pi;
	}
}
