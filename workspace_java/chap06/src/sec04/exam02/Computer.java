package sec04.exam02;

public class Computer {

	// int[] values
	// "..." : 가변인자, 가변 길이 파라메터
	// 전달인자의 개수에 관계없이 전달 받겠다.
	// 모든 전달인자를 배열로 처리한다.
	// int sum2(int[] values) {
	int sum2(int... values) {
		int[] v = new int[0];
		System.out.println("values : " + values);

		int sum = 0;

		// 향상된 for문
		// for(int val : values){
		for (int i = 0; i < values.length; i++) {
			int val = values[i];
			sum += val;
		}
		return sum;
		
		// Unreachable code
		// System.out.println(sum);
		
		
		
		
		

	}

}
