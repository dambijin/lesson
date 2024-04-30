package chap05;

public class RefExam {

	public static void main(String[] args) {

		int a;
//		int b = 10 + a;
//		System.out.println(a);

		String c = "최민수";
		System.out.println(c.indexOf("민"));
		c = null;
		System.out.println("c : " + c);
		if (c != null) {
			System.out.println(c.indexOf("민"));
		}

		String strVar1 = "최민수";
		String strVar2 = "최민수";

		strVar1 = "최민수1";
		System.out.println("strVar2 : " + strVar2);

		boolean isEqual = (strVar1 == strVar2);
		System.out.println("isEqual : " + isEqual);

		boolean isEqual2 = strVar1.equals(strVar2);
		System.out.println("isEqual2 : " + isEqual2);

		// 배열
		int[] intArray = null;
		intArray = new int[5];
		intArray[0] = 10;
		intArray[1] = 20;
		intArray[2] = 30;
		intArray[3] = 40;
		intArray[4] = 50;

		int[] intArray2 = null;
		intArray2 = new int[] { 10, 20, 30, 40, 50 };
		intArray2 = new int[] { 10, 20, 30, 40, 50, 60 };

		int[] intArray4 = new int[] { 10, 20, 30, 40, 50 };
		int[] intArray3 = { 10, 20, 30, 40, 50 };

		System.out.println(intArray3.length);
//		intArray3.length = 10;

		int number1 = ((int) (Math.random() * 45)) + 1;
		int num2 = ((int) (Math.random() * 45)) + 1;
		int n3 = ((int) (Math.random() * 45)) + 1;

		int[] lotto = new int[6];
		lotto[0] = ((int) (Math.random() * 45)) + 1;
		lotto[1] = ((int) (Math.random() * 45)) + 1;
		lotto[2] = ((int) (Math.random() * 45)) + 1;
		int m = 3;
		lotto[m] = ((int) (Math.random() * 45)) + 1;
		m = 4;
		lotto[m] = ((int) (Math.random() * 45)) + 1;

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = ((int) (Math.random() * 45)) + 1;
		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.println(lotto[i]);
		}

		int[] lotto2 = new int[6];
		for (int i = 0; i < lotto2.length; i++) {
			lotto2[i] = ((int) (Math.random() * 45)) + 1;
		}

		for (int i = 0; i < lotto2.length; i++) {
			System.out.println(lotto2[i]);
		}

		// 다차원 배월
		int[][] lottos = new int[31][6];
		lottos[0] = lotto;
		lottos[1] = lotto2; // new int[6]

		// lotto2에서 첫번째 것
//		int l21 = lotto2[0];
		int l21 = lottos[1][0];

		System.out.println("lottos.length : " + lottos.length);
		System.out.println("lottos[0].length : " + lottos[0].length);

		int[] arr = new int[5];
		System.out.println("arr[1] : " + arr[1]);

		String[] arr2 = new String[3];
		System.out.println("arr2[0] : " + arr2[0]);

		boolean[] arr3 = new boolean[6];
		System.out.println("arr3[2] : " + arr3[2]);

		int[] arrInt1 = { 1, 2, 3, 4, 5 };
		int[] arrInt2 = arrInt1;

		System.out.println("arrInt2[1] : " + arrInt2[1]);
		arrInt1[1] = 22;
		System.out.println("arrInt2[1] : " + arrInt2[1]);

		System.out.println("arrInt1 : " + arrInt1);
		System.out.println("arrInt2 : " + arrInt2);

		String[] arrStr = { "a", "b" };
		System.out.println("arrStr : " + arrStr);

		int[] newArr1 = new int[3];
		newArr1[0] = 1;
		newArr1[1] = 2;
		newArr1[2] = 3;

		int[] newArr2 = new int[3];
//		newArr2[0] = 1;
		newArr2[0] = newArr1[0];

		newArr1[0] = 10;
		System.out.println("newArr2[0] : " + newArr2[0]);

		// 처음부터 끝까지 하나씩 꺼내서 :앞의 변수에 넣는다
		for (int item : newArr1) {
			System.out.println("item : " + item);
		}

//		int[] child = new int[3];
		int[] child = null;
		int[][] parent = new int[5][3];

		// parent크기만큼(즉 5) 반복
		for (int i = 0; i < parent.length; i++) {

			// child크기만큼(즉 3) 반복
			child = new int[3];
			for (int j = 0; j < child.length; j++) {
				// child 초기값 세팅
				// 0,1,2
				// 1,2,3
				child[j] = i + j;
			}

			// 세팅한 child를 parent에 순서대로 넣기
			parent[i] = child;
			System.out.println("****");
			System.out.println("child[0] : "+ child[0]);

		}

		for (int i = 0; i < parent.length; i++) {
			for (int j = 0; j < parent[i].length; j++) {
				System.out.print( parent[i][j] +",");
			}
			System.out.println();
		}
		
		
		int[][] dim2 = {
							{1, 2},
							{1, 3, 4}
						};
	}

}
