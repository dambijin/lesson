package sec01.exam07;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeExam {

	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		System.out.println(time);
		
//		for(int i =0; i<1000000;i++)
//		{
//			System.out.print(".");
//		}
//		long t2 = System.currentTimeMillis();
//		System.out.println(t2-time);
		
		Date date = new Date();
		System.out.println(date);
		
		String format = "yyyy년 MM월 dd일 HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String strDate = sdf.format(date);
		System.out.println(strDate);
	}

}
