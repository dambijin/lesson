package hello;
//중괄호는 지역선언
public class Hello { 

	//함수선언
	/** 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello world 한글");

		int a = 10;
		int b = 20;
		int temp = a;
		a = b;
		b = temp;

		System.out.println(a);
		System.out.println(b);

	}

}
