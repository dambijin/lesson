package sec01.exam01;

public class dec26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 배열
		int[] intArray = null;
		intArray = new int[5];
		intArray[0] = 10;
		intArray[1] = 20;
		intArray[2] = 30;
		intArray[3] = 40;
		intArray[4] = 50;

		// intArray와 intArray2는 번지는 다르지만 지닌 값은 똑같음
		int[] intArray2 = null;
		intArray2 = new int[] { 10, 20, 30, 40, 50 };

		// int[] intArray3= null; 이렇게 적을 수 없음
		int[] intArray3 = { 10, 20, 30, 40, 50 };

		// length는 읽어오는 역할만 한다. 변수지만 덮어쓸 수 없다.
		System.out.println(intArray3.length);

		// 뜨는 숫자들을 배열로 집어 넣는다
		int rotto[] = new int[6];
		double number = 0;
		for (int i = 0; i < rotto.length; i++) {
			rotto[i] = (((int) (Math.random() * 45)) + 1);
			System.out.println(rotto[i]);
		}

		int[] lotto = new int[6];
		int[] lotto2 = new int[6];
		// 다차원 배열
		int[][] lottos = new int[5][6];
		lottos[0] = lotto;
		lottos[1] = lotto2; // new int[6]

		// lotto2에서 첫번째 것
		// int l21=lotto2[0];
		int l21 = lottos[1][0];

		System.out.println("lottos.length : " + lottos.length);
		System.out.println("lottos[0].length : " + lottos[0].length);

		int[] arr = new int[5];
		System.out.println("arr[1] : " + arr[1]);

		// string은 기본 값이 null
		String[] arr2 = new String[3];
		System.out.println("arr2[0] : " + arr2[0]);

		// boolean은 기본 값이 false
		boolean[] arr3 = new boolean[6];
		System.out.println("arr3[2] : " + arr3[2]);

		int[] arrInt1 = { 1, 2, 3, 4, 5 };
		int[] arrInt2 = arrInt1;

		System.out.println("arrInt2[1] : " + arrInt2[1]);
		arrInt1[1] = 22;
		System.out.println("arrInt2[1] : " + arrInt2[1]);

		System.out.println("arrInt1 : " + arrInt1);

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

		// 처음부터 끝까지 하나씩 꺼내서 콜론(:)앞의 변수에 넣는다.
		for (int item : newArr1) {
			System.out.println("item : " + item);
		}

		int[] child = new int[3];
		int[][] parent = new int[5][3];
		
		// parent크기 만큼 (즉5)반복
		for (int i = 0; i < parent.length; i++) {
			// child 크기만큼(즉3) 반복
			child = new int[3];
			for (int j = 0; j < child.length; j++) {
				// child 초기값 세팅
				// 0, 1, 2
				// 1, 2, 3
				child[j] = i + j;
			}
			// 세팅한 child를 parent에 순서대로 넣기
			parent[i] = child;
		}
		
		for (int i=0; i<parent.length; i++) {
			for (int j=0; j<parent[i].length; j++) {
				System.out.println(parent[i][j]+",");
			}
			
		}

	}

}
