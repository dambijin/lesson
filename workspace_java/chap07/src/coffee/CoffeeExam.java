package coffee;

public class CoffeeExam {

	public static void main(String[] args) {

		Mega mega=new Mega(2000);
		mega.pay(1000);
		System.out.println(mega);
		mega.pay(3000);		
		System.out.println(mega);
		
		Gongcha goncha=new Gongcha(3000);
		goncha.pay(1500);
		System.out.println(goncha.toString());
		goncha.pay(3000);		
		System.out.println(goncha.toString());
		
		
		PaikCoffee palk= new PaikCoffee(1500);
		palk.pay(1000);
		System.out.println(palk);
		palk.pay(1500);		
		System.out.println(palk);
		
		
		
		
	}
	

	
}
