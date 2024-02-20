package chap07.coffee;

public class Coffee extends Object{

	int price;
	int money;
	
	Coffee(int price){
		this.price = price;
	}
	
	public void pay(int money) {
		this.money = money;
	}
	
	void order() {
		if(this.money < this.price) {
			System.out.println("돈이 모자랍니다");
		} else {
			System.out.println("커피를 제공합니다");
		}
	}
	
//	public String toString(){
//		return "price : "+ price +", money : "+ money;
//	}
}
