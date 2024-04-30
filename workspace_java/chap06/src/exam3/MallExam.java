package exam3;

import java.io.InputStream;
import java.util.Scanner;

public class MallExam {

	public static void main(String[] args) {

		Goods g1 =new Goods();
		Goods g2 =new Goods();
		
		g1.setName("소주");
		g1.setPrice(4000);
		
		g2.setName("족발");
		g2.setPrice(20000);
		
		Member m1 = new Member();
		m1.add(g1);
		m1.add(g2);
		m1.add(g1);
		m1.print();
		
	}

}
