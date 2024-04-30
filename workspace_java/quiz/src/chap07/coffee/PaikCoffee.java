package chap07.coffee;

public class PaikCoffee extends Coffee{

	PaikCoffee(){
		super(2000);
	}
	
	String buySalad() {
		System.out.println("사라다빵을 제공합니다");
		return "사라다빵";
	}
}
