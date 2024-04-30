package quiz;

public class AccountExam {

	public static void main(String[] args) {
		Account acc1 = new Account("기업통장");
		acc1.print();
		
		acc1.in(5000);
		acc1.print();
		acc1.in(-500);
		
		acc1.out(4000);
		acc1.print();
		
		acc1.out(4000);
		acc1.out(-4000);
		
		acc1.printAccInfo();
		
		
		Account acc2 = new Account("농협통장");
		acc2.in(1000000);
		
		acc1.print();
		acc2.print();
		
		acc2.balance = 5000;
		acc2.print();
		
	}

}
