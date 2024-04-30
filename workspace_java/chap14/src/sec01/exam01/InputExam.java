package sec01.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputExam {

	public static void main(String[] args) {

		String path = "c:\\temp\\test.txt";
		InputStream is = null;
		try {
			is = new FileInputStream(path);
			
//			int BUFFER = 1024 * 8;
			int BUFFER = 1;
			byte[] datas = new byte[BUFFER];
			
			int result = 0;
			String read="";
			while(result != -1)
			{
				result = is.read(datas);
				read += new String(datas);
//				System.out.println(read);
			}
			System.out.println(read);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
