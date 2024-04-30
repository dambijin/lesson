package quiz;

public class quiz4_231226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		5. [1,2,3,4,5]가 들어있는 배열이 있을때
//		2가 있으면 있다.없으면 없다.라고 띄워주기
//		6을 넣었을땐 없다가 떠야한다
		int arr111[] = { 1, 2, 3, 4, 5 };
		int chkNum = 2; // 2나 6은 여기를 바꾼다는 뜻입니다
		boolean chk = false;

		for (int i = 0; i < arr111.length; i++) {
			if (arr111[i] == chkNum) {
				chk = true;
			}
		}

		if (chk == true) {
			System.out.println("있음");
		} else {
			System.out.println("없음");
		}

		// arr112배열안에 chkarr배열요소가 몇 개 있는지 알려주는 프로그램
		int arr112[] = { 1, 2, 3, 4, 5 };
		int chkarr[] = { 2, 3, 6 }; //
		int chkAddNum = 0; // 최종적으로 몇개인지 저장할 변수
		for (int i = 0; i < arr112.length; i++) {
			for (int j = 0; j < chkarr.length; j++) {
				if (arr112[i] == chkarr[j]) {
					chkAddNum++;
				}
			}
		}
		System.out.println(chkAddNum + "개 있음");

		int arr113[] = { 1, 2, 3, 4, 5, 7, 8, 9 };
		int chkarr2[] = { 2, 3, 6 };
		int chkAddNum2 = 0;
		boolean chkBool = false;// arr113체크할때마다 있는지 없는지 체크용~

		for (int i = 0; i < arr113.length; i++) {
			chkBool = false;
			for (int j = 0; j < chkarr.length; j++) {
				if (arr113[i] == chkarr2[j]) {
					chkBool = true;
				}
			}
			if (chkBool == false) {
				chkAddNum2++;
			}
		}

		System.out.println(chkAddNum2 + "개 없음");

//		1. 50부터 555까지 저장하는 배열 만들어서 출력
		int number[] = new int[506];
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 50;
			System.out.println(number[i]);
		}

//		2. 로또 6개 저장 (중복 가능)
		int lotto[] = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = ((int) (Math.random() * 45) + 1);

			System.out.println(lotto[i]);
		}

//		3. LoL대회 팀 명은 1번부터 5번까지인 5팀이 참가했음.
//		꼴지팀부터 순서대로 나열했더니 다음과 같았다.
//		[2, 4, 5, 1]
//		그렇다면 승리한 팀은?
//		lol과 lol_loser을 비교해서 값이 안나오는 것이 있음
//		나오는건 lol_winner에 두면됨
		int lol[] = { 1, 2, 3, 4, 5 };
		int lol_loser[] = { 2, 4, 5, 1 };
		boolean lol_winner = false;

		for (int i = 0; i < lol.length; i++) {
			lol_winner = false;
			for (int j = 0; j < lol_loser.length; j++) {
				
				if (lol[i] == lol_loser[j]) {
					lol_winner = true;
				}
			}
			if (lol_winner == false) {
				System.out.println(lol[i]);
			}
		}

//		4. 로또 6개 저장 (중복 불가능)

	}

}
