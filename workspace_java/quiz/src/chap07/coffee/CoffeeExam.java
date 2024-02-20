package chap07.coffee;

public class CoffeeExam {

	public static void main(String[] a) {

		PaikCoffee paik = new PaikCoffee();
		paik.pay(1500);
		paik.order();
		paik.pay(15000);
		paik.order();

		String str = paik.toString();
		System.out.println(str);
		System.out.println(paik.toString());
		System.out.println(paik);

		MegaCoffee mega = new MegaCoffee();
		mega.pay(1500);
		mega.order();

		paik.buySalad();
//		mega.buySalad();

		testPaik(paik);
		testMega(mega);

//		1단계
		Coffee c = new Coffee(1);
		PaikCoffee p1 = new PaikCoffee();
		c = (Coffee) p1;
		
//		2단계
		Coffee c1= (Coffee)new PaikCoffee();
		
//		3단계
		Coffee c2= new PaikCoffee();
		Coffee c3= new MegaCoffee();

	}

	static void testPaik(PaikCoffee pc) {
		pc.pay(20000);
		pc.order();
	}

	static void testMega(MegaCoffee mc) {
		mc.pay(20000);
		mc.order();
	}
	
	static void testCoffee(Coffee c) {
		c.pay(1800);
		c.order();
	}
	
	
}
