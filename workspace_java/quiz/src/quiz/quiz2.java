package quiz;

public class quiz2 {

	public static void main(String[] args) {
		// 1. 15와 20이 주어졌을 때 세번째 값이 그 사이에 있는지 확인
		int a1 = 15;
		int a2 = 20;
		int a3 = 19;
		if (a3 >= 15) {
			System.out.println("일단 15이상임");
			if (a3 <= 20) {
				System.out.println("사이에 있음");
			}
		}

		if (a3 >= 15 && a3 <= 20) {
			System.out.println("사이에 있음");
		}

		// 2 사각형의 좌상단 좌표, 우하단 좌표가 있고 점의 좌표가 있을때 그 점이
		// 사각형에 포함 되는지 확인
		int bx1 = 10;
		int by1 = 20;
		int bx2 = 100;
		int by2 = 200;

		int bx3 = 50;
		int by3 = 50;

		if (bx3 >= bx1 && bx3 <= bx2 && by3 >= by1 && by3 <= by2) {
			System.out.println("사각형 안에 있다");
		}

		// 3 1~100까지의 합 구하기

//		int c = ((((((1 + 2) + 3) + 4) + 5) + 6) + 7);
//		int ii = 0;
//		c = 0;
//		c = 0 + 1;
//		c = c + 2;
//		c = c + 3;
//		c = c + 4;

		int c = 0;
		for (int i = 0; i <= 100; i++) {
			c = c + i;
		}
		System.out.println("1~100까지의 합은 : " + c);

		// 4 1~100까지 짝수의 합계 구하기
		int d = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				continue;
			}
			d = d + 1;
		}
		System.out.println("짝수의 합 : " + d);

		// 5 구구단 2~3단씩 출력

		int dan = 2;
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + "x" + i + "=" + (dan * i) + "\t" + (dan + 1) + "x" + i + "=" + ((dan + 1) * i));
		}
		System.out.println("-------------------------------");

		for (dan = 2; dan <= 9; dan += 2) {
			for (int i = 1; i <= 9; i++) {
				System.out
						.println(dan + "x" + i + "=" + (dan * i) + "\t" + (dan + 1) + "x" + i + "=" + ((dan + 1) * i));
			}
		}
		System.out.println("-------------------------------");

		// 3단씩 옆으로 출력
		int se = 5;
		for (dan = 2; dan <= 9; dan += se) {
			for (int i = 1; i <= 9; i++) {
//				System.out.println((dan+0)+"x"+i+"="+((dan+0)*i)+"\t"
//								+ (dan+1)+"x"+i+"="+((dan+1)*i)+
//								+ (dan+2)+"x"+i+"="+((dan+2)*i)+
//								+ (dan+3)+"x"+i+"="+((dan+3)*i)+);
				for (int j = 1; j < se; j++) {
					if (dan + j <= 9) {
						System.out.println((dan + j) + "x" + i + "=" + ((dan + j) * i));
					}
				}
			}
		}

		// 6 숫자 배열이 있을 때 최대값 구하기 (단,sort쓰지 말고)
		int[] target = { 3, 4, 5, 7, 9 };
		int e = -1;
		for (int i = 0; i < target.length; i++) {
			if (target[i] > e) {
			}
			e = target[i];
		}

		// 7 두번째 최대값 구하기
		int f = -9999;
		for (int i = 0; i < target.length; i++) {

		}

		// 8 내림차순 정렬
		// 내림, 내려감, 높은데에서 내려감
		int[] desc = new int[target.length];

		for (int i = 0; i < target.length; i++) {

		}

		/*
		 * 9. 예약 자리가 10개 있는 소극장 예약 시스템을 만들건데 1~10번 자리까지 있음 예약 가능하면 "예약했습니다" 예약 불가능하면
		 * "이미 예약 되어있습니다" 첫번째 사용자가 2번 자리를 예약 두번째 사용자가 2번 자리를 예약 남은 자리를 출력
		 */
		boolean[] g = new boolean[10];
		int rsv=2;
		g[rsv-1]=true;
		
		rsv=3;
		if(!g[rsv-1]) {
			g[rsv-1]=true;
			System.out.println(rsv+"번 자리 예약이 되었습니다.");
		}else {
			System.out.println(rsv+"번 자리는 예약이 불가능합니다.");
		}                                                                                                                                                        
		
		rsv=2;
		if(!g[rsv-1]) {
			g[rsv-1]=true;
			System.out.println(rsv+"번 자리 예약이 되었습니다.");
		}else {
			System.out.println(rsv+"번 자리는 예약이 불가능합니다.");
		}

	}
}
