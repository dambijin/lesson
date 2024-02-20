package sec01.exam01;

import java.io.IOException;
import java.util.Scanner;

public class VarExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score; // 선언부
		score = 90; // 할당

//		int value = 30; // 선언과 동시에 초기화
//		int value;
//		value = 30;
//		int result = value + 10;

		int var1 = 10;

		{
			int var2 = 20;
			System.out.println("var1 : " + var1);
			System.out.println("var2 : " + var2);
		}
//		System.out.println("var2 : "+var2);
//		byte b=128; byte 는 -128~127만 저장되기 때문에 128은 오류

		char c1 = 'A';
		System.out.println(c1);

		c1 += 2;
		System.out.println(c1);

		c1 = 97;
		System.out.println(c1);

		String s1 = "문\n자";

		float f = 0.1234567890123456789f;
		double d = 0.1234567890123456789;

		System.out.println(f);
		System.out.println(d);

		boolean stop = true;
		boolean state = false;

		long balance = 3000000000L;

		int a = 10;
		// long b = (long) a; 이 중간과정이 필요없이 아래처럼 작성하면됨
		long b = a;
		System.out.println("b: " + b);

		b = 3000000000L;
		a = (int) b;
		System.out.println("a: " + a);

		double d2 = 3.14;
		int i2 = (int) d2;
		System.out.println("i2 : " + i2);

		int result = 10;
		int count = 4;
		
		// int는 실수를 표현할 수 없어서 (소수점 표현 불가)
		// 결과값이 2를 반환한다
		System.out.println(result / count);

		double n = 10 / 4;
		System.out.println("n : " + n);

		double r2 = 10;
		double c2 = 4;
		n = r2 / c2;
		System.out.println(n);

		String str = "15";
		int val = Integer.parseInt(str);
		System.out.println(val + 1);

		int ii = 123;
		String s = "" + ii;
		System.out.println(s);

		System.out.println("a");
		System.out.println("b");

//		try {
//			System.out.println("아무키나입력하세요");
//			int read = System.in.read();
//			System.out.println("read : " + read);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		System.out.println("또 아무값이나 넣어주세요.");
		Scanner scan = new Scanner(System.in);
		String inputData = scan.nextLine();
		System.out.println("inputData: " + inputData);

		boolean bb = inputData.equals("abc");
		System.out.println(bb);

		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;

		double area = (double) ((lengthTop + lengthBottom) * height) / 2;
		System.out.println(area);
		
		
		
		
		
	}
	
}
