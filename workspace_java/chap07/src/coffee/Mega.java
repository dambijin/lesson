package coffee;

public class Mega extends Coffee{

	
	Mega(int price) {
		super(price);
		System.out.println("어서오세요. 메가커피입니다.");
	}

	@Override	
	void pay(int money) {
		this.money=money;
		if (price>money) {
			System.out.println("메가커피 : 커피제공이 어렵습니다.");
		}else {
			System.out.println("메가커피 : 커피가 제공되었습니다.");
		}
	}
	
	@Override	
	public String toString() {
		String result="메가커피가격 : "+price+", 메가커피 입금액 : "+money;
		return result;		
	}
	
	
}
