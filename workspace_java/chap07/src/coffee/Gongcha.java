package coffee;

public class Gongcha extends Coffee{

	Gongcha(int price) {
		super(price);
		System.out.println("어서오세요. 공차입니다.");
	}
	
	@Override	
	void pay(int money) {
		this.money=money;
		if (price>money) {
			System.out.println("공차 : 커피제공이 어렵습니다.");
		}else {
			System.out.println("공차 : 커피가 제공되었습니다.");
		}
	}
	
	@Override	
	public String toString() {
		String result="공차 가격 : "+price+", 공차 입금액 : "+money;
		return result;		
	}

	
	
}
