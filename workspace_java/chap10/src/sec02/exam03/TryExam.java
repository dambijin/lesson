package sec02.exam03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TryExam {

	public static void main(String[] args) {

		String strAge = "20a";

		int age = 0;

		try {

			age = Integer.parseInt(strAge);

		} catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();
			System.out.println(e.getMessage());

			age = 1;
		}

		System.out.println(age - 1);

		ThrowsExam te = new ThrowsExam();
		try {
			te.getAge();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		te.test();

		try {
			te.test2(3);
		} catch (HumanException e) {
//			e.printStackTrace();

			// 예외 메시지를 통해서 if처럼 사용하는 방법
			String msg = e.getMessage();
			if (msg.equals("E05")) {
				System.out.println("5 이상을 입력하세요");
			} else if (msg.equals("E10")) {
				System.out.println("10 미만을 입력하세요");
			}
		}

		FileInputStream fis = null;
		try {
			fis = new FileInputStream("c:\\text.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

//		try-with-resources
//		close를 자동 실행해줌
//		단, 부모중에 한번은 interface Closeable이 필요함
//		즉, Closeable이 있는 경우에 사용가능
		try (FileInputStream fis2 = new FileInputStream("c:\\text.txt");) {
			System.out.println(fis2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}