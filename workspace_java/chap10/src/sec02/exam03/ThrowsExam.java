package sec02.exam03;

import java.io.IOException;

public class ThrowsExam {

	public int getAge() throws ClassNotFoundException, IOException{
		String strAge = "20a";
		
		int age = Integer.parseInt(strAge);
		
		System.out.println(age);
		return age;

	}
	
	
	void test() {
		System.out.println(1);
		throw new NumberFormatException();
//		System.out.println(2);
	}
	
	void test2(int i) throws HumanException {
		System.out.println("test2 실행 i: "+ i);
		
		if(i < 5) {
			throw new HumanException("E05");
		} else if(i > 10) {
			throw new HumanException("E10");
		} else {
			System.out.println("5이상 10미만으로 정상임");
		}
	}

}