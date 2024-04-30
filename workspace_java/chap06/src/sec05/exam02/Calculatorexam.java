package sec05.exam02;

// 모든 클래스
// 단, 하위 패키지는 포함하지 않음
import sec05.exam04.singleton.Singleton;
import sec05.exam04.singleton.Singletonexam;

public class Calculatorexam {

	public static void main(String[] args) {

		Singleton s = null;
		Singletonexam se = null;

		System.out.println("Calculator.pi : " + Calculator.pi);
		Calculator.pi = 3.1;

		int aa = Calculator.plus(10, 15);
		System.out.println("aa : " + aa);

		Calculator c1 = new Calculator();
		c1.a = 20;

		Calculator c2 = new Calculator();
		c2.a = 40;

		System.out.println("c1.a : " + c1.a);
		System.out.println("c2.a : " + c2.a);

		double p = Math.PI;

	}

	static void test() {
		System.out.println("테스트 중....");
	}

}
