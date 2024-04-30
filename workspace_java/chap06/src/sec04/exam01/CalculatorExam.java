package sec04.exam01;

public class CalculatorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calculator calc = new Calculator();
		calc.powerOn();
		// 10+20 으로 결과는 35
		int result1 = calc.plus(10, 25);
		System.out.println("result1 : " + result1);

		// 선언 되어있는 전달인자의 변수명과
		// 사용자가 정한 변수명이 다를 때
		// 변수명은 관계없다

		int x = 35;
		int y = 25;
		// int result_1=calc.plus(calc.plus(10, 25),y);
		// int result_1=calc.plus(result1,y);
		// int result_1=calc.plus(x,y);
		int result_1 = calc.plus(x, y);

		// 전달인자로 함수를 넣을 수도 있다
		// * 함수의 결과는 변수로 담을 수 있고
		// 전달인자는 변수를 사용할 수 있으니까
		// * 함수의 return이 int니까 int자리 아무데나 넣을 수 있다
		int result_2 = calc.plus(calc.plus(x, y), y);

		byte a = 10;
		byte b = 4;
		double result2 = calc.divide(a, b);
		System.out.println("result2 : " + result2);

		double plus_d = 30 / 7;
		double result_3 = calc.plus_d(calc.divide(30, 7), 500);
		System.out.println("result_3 : " + result_3);

		calc.powerOff();

	}

}
