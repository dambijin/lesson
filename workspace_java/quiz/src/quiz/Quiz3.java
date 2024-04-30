package quiz;

public class Quiz3 {
	public static final int LETTER_TYPE_NUMBER = 0; // 비번 종류 : 숫자
	public static final int LETTER_TYPE_UPPERCASE = 1; // 비번 종류 : 대문자
	public static final int LETTER_TYPE_LOWERCASE = 2; // 비번 종류 : 소문자

	public static void main(String[] args) {

		// 1. 임시 비번 만들기 8자리

		// 변수 타입 설정에 대한 테스트
		int temp = 12345678;
		int temp4 = 123456;
		String temp2 = "12345678";
		String temp3 = "00000000";

		String pw = "";

		// 1-1 숫자로
		int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// int index = ((int) (Math.random() * 100)) % 10;
//		int index = (int) (Math.random() * (9 + 1));
		// (numbers.length + 1)
		// 이렇게 쓰면 나중에 배열 내용물을 바꾸거나 양이 줄거나 늘어도
		// 오류가 나지 않는다.
//		int index = (int) (Math.random() * (numbers.length + 1));
//		pw = pw + index;
//
//		// index 변수 재활용
//		index = (int) (Math.random() * (9 + 1));
//		pw = pw + index;
		for (int i = 1; i <= 8; i++) {
			int index = (int) (Math.random() * (numbers.length));
			pw = pw + index;
		}
		System.out.println("1-1 숫자로 : " + pw);

		// 1-2 소문자만
		pw = "";
		pw = new String();
		String[] alpha1 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };
		for (int i = 1; i <= 8; i++) {
			int index = (int) (Math.random() * (alpha1.length));
			// System.out.println("index : "+index);
			pw = pw + alpha1[index];
		}
		System.out.println("1-2 소문자만 : " + pw);

		// 두번째 방법
		// 아스키코드(숫자)를 이용해 문자로 만드는 방법

		pw = "";
		// char 타입은 '' 홑따옴표 사용해야함
		// char alpha2 = 97;
		// System.out.println("alpah2 : " + alpha2);
		for (int i = 1; i <= 8; i++) {
			// 97~122
			// 122-97+1

			// 0~25 까지 만들어줌
			// 둘다 97을 더함
			// 97~122
			// int index = (int) (Math.random() * 26) + 97;
			// 위 내용을 보편적으로 쓸 수 있는 방법
//			int start = 97;
//			int end = 122;
//			int index = (int) (Math.random() * (end-start+1)) + start;

			int index = getRandomRange(97, 122);
			char alpha3 = (char) index;
			pw = pw + alpha3;

		}

		System.out.println("1-2 소문자만(2): " + pw);

		// 1-3 숫자2개, 대소문자 하나 이상 조합
		// 숫자 2개
		pw += getRandomRange(0, 9);
		pw += getRandomRange(0, 9);

		// 대문자 1개

		// 65~90 범위의 랜던 값 뽑기
		// math.random(); 0.0<=랜덤값 <1.0
		// 65~90 => (0~25)+65

		// 배열에 필수 요소 먼저 채우기
		String[] letters = new String[8];

		// 랜덤 위치
		int idx = getRandomRange(0, 7);

		// 첫번째 숫자
		int num = getRandomRange(0, 9);

		// 넣기
		letters[idx] = "" + num;

		// 랜덤 위치
		idx = getRandomRange(0, 7);

		/*
		 * 몇번을 반복할지 모르기 때문에 사용 못함 0.000000000000001의 확률도 0이 아니기 때문에
		 */
		// 그 위치에 넣었던 값이 없다면
//		if (letters[idx] != null) {
//
//			// 두번째 숫자
//			num = getRandomRange(0, 9);
//
//			// 넣기
//			letters[idx] = "" + num;
//		} else {
//			// 그 위치에 이미 넣은 값이 있다면
//			idx = getRandomRange(0, 7); // 랜덤위치
//		}

		// 위치를 뽑는데 언제까지? 그자리가 null일때까지 계속 뽑기
		// 반복문으로 만들건데 몇번인지 모르기 때문에
		// while로 선택
//		idx = getRandomRange(0,7);
//		while(letters[idx] != null) {
//			idx = getRandomRange(0,7); //랜덤위치
//		} 
		do {
			idx = getRandomRange(0, 7); // fosejadnlcl
		} while (letters[idx] != null);
		// while문 이후의 letters[idx]는 비어있는 자리

		// 두번째 숫자
		num = getRandomRange(0, 9);

		// 넣기
		letters[idx] = "" + num;

		// 빈자리 찾기
		do {
			idx = getRandomRange(0, 7); // fosejadnlcl
		} while (letters[idx] != null);

		// 대문자 뽑기
		char upper = (char) getRandomRange(65, 90);
		letters[idx] = "" + upper;

		// 빈자리 찾기
		do {
			idx = getRandomRange(0, 7); // fosejadnlcl
		} while (letters[idx] != null);

		// 소문자 뽑기
		char lower = (char) getRandomRange(97, 122);
		letters[idx] = "" + lower;

		// 2. 로또 6개 저장
		// 2-1 중복 가능
		// 2-2 중복 불가

		// 3. 이름의 두번째 글자를 *로 가리기 : 최*수

		// 4. 전화번호의 -와 -사이를 *로 가리기
		// 010-2046-7051
		// 010-204-7051

		// 5. blog.naver.com에서 naver만 추출하기

		// 6. 응원 전광판 효과
		// hello world
		// 4글자씩만 보이기
		// hell
		// ello
		// llo
		// lo w
		// o wo

	}

	static int getRandomRange(int start, int end) {
		int index = (int) (Math.random() * (end - start + 1)) + start;
		return index;
	}
}
