package quiz;

public class Quiz6_2 {

	@SuppressWarnings("null")
	public static void main(String[] args) {

//		임의의 숫자 배열에서
//		0-2 배열 shuffle
//		0-3 주어진 숫자보다 큰 수가 몇개인지
//		0-4 주어진 숫자가 몇번 반복되었는지
//		0-5 두번 이상 출현한 숫자가 몇개인지
//		0-6 중복을 제거한 배열 만들기
//		[1,2,3,4,1,2,3] => [1,2,3,4]

		int[] array1 = { 1, 2, 3, 4, 1, 2, 3 };
		int[] array2 = new int[array1.length];

		
		
//		0-1 배열 뒤집기
		for (int i = 0; i < array1.length; i++) {
			// array2[0]=array1[6];
			// array2[1]=array1[5];
			// array2[2]=array1[4];
			// 처음에 실수로 array1.length가 배열의 길이인걸 까먹음
			// 그래서 array2[i]=array1[6-i];
			// 
			array2[i]=array1[array1.length-1-i];
			System.out.println(array2[i]);
			
		}
		
		
	}
}
