package chap07.coffee;

public class MegaCoffee extends Coffee {

	MegaCoffee() {
		super(1500);
	}

	@Override
	public void pay(int money) {
		System.out.println(money + "원을 받았습니다");
		this.money = money;
	}
}
