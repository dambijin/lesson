package coffee;

public class PaikCoffee extends Coffee{

	PaikCoffee(int price) {
		super(price);
		System.out.println("빽다방입니다.");
	}
	
	
	@Override	
	void pay(int money) {
		this.money=money;
		if (price>money) {
			System.out.println("빽다방 : 커피제공이 어렵습니다.");
		}else {
			System.out.println("빽다방 : 커피가 제공되었습니다.");
		}
	}
	
	@Override	
	public String toString() {
		String result="빽다방 가격 : "+price+", 빽다방 입금액 : "+money;
		return result;		
	}
	
	

	
}
