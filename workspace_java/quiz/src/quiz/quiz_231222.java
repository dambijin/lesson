package quiz;

import java.util.Scanner;

public class quiz_231222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * quiz2. 167234원을 현금으로 출금
		 * 
		 * 5만원, 1만원, 5천원, 1천원, 500원, 100원, 50원, 10원, 1원 각각의 통화권은 몇개씩 필요한지
		 * 
		 * 5만원으로 먼저 나눔
		 */

		int jasan = 167234;
		int oman = jasan / 50000;
		jasan = jasan - (oman * 50000);

		int ilman = jasan / 10000;
		jasan = jasan - (ilman * 10000);

		int ocheon = jasan / 5000;
		jasan = jasan - (ocheon * 5000);

		int cheon = jasan / 1000;
		jasan = jasan - (cheon * 1000);

		int oback = jasan / 500;
		jasan = jasan - (oback * 500);

		int back = jasan / 100;
		jasan = jasan - (back * 100);

		int osib = jasan / 50;
		jasan = jasan - (osib * 50);

		int sib = jasan / 10;
		jasan = jasan - (sib * 10);

		int ill = jasan / 1;
		jasan = jasan - (ill * 1);

		System.out.println("5만원 : " + oman);
		System.out.println("1만원 : " + ilman);
		System.out.println("5천원 : " + ocheon);
		System.out.println("1천원 : " + cheon);
		System.out.println("500원 : " + oback);
		System.out.println("100원 : " + back);
		System.out.println("50원 : " + osib);
		System.out.println("10원 : " + sib);
		System.out.println("1원 : " + ill);

		/*
		 * quiz3 n분의 1계산기 비용 : 50,000원 인원 : 7명 단, 내가 조금 더 낸다
		 * 
		 */

		int sum = 50000;
		int n = 7;
		int douchpay = sum / n;
		int douchpay2 = sum / n;
		int namuji = sum % n;
		douchpay2 = douchpay2 + namuji;
		System.out.println("친구들이 낼 돈 : " + douchpay);
		System.out.println("내가 낼 돈 : " + douchpay2);

		String str = "50000";
		int value = Integer.parseInt(str);

		boolean run = true;
		int balace = 0;
		Scanner scan = new Scanner(System.in);

		while (run) {
			System.out.println("1.예금, 2.출금, 3.잔고, 4.종료");
			int menu = scan.nextInt();
			if (menu == 1) {
				System.out.println("예금할 금액은?");
				int money = scan.nextInt();
				if (money < 0) {
					System.out.println("금액을 확인하세요");
				}
				balace += money;
			} else if (menu == 2) {
				System.out.println("출금할 금액은?");		
				int money = scan.nextInt();
				if (balace < money) {
					System.out.println("잔고가 부족합니다.");
				} else {
					balace -= money;
				}
					
			} else if (menu == 3) {
				System.out.println("잔액 : " + balace);
			} else if (menu == 4) {
				System.out.println("종료되었습니다.");
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		System.out.println("프로그램 종료");

	}

}
