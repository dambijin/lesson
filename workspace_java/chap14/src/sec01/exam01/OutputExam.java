package sec01.exam01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExam {

	public static void main(String[] args) {
		String path = "c:\\temp";
		String filename = "test.txt";
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(path+"\\"+filename);
			
			String data = "abc\n한글\n123";
			byte[] datas = data.getBytes();
			
			os.write(datas);
			os.flush();
			
			os.close();
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(os != null)
			{
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}


	}

}
