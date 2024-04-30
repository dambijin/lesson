package quiz;

public class Silro_quiz5_1 {

//	문제 1.
//	체력 hp, 방어력 dp
//	체력을 출력하는 기능
//	공격받기 (attack)
//	 - 전달인자: 체력 - (공격받은 수치 - 방어력)
//	회복하기 (heel)
//	 - 전달인자: 회복수치 또는 회복방법
//	확인 : 공격받고 회복하고 공격받고 회복하고

	int hhp = 500; // 최대체력
	int hp = 500; // 체력
	int dp = 30; // 방어력
	int att = 0; // 공격받은 수치

	Silro_quiz5_1() {

	};

	// 공격 받기의 타입은 무엇으로 설정할지 모르겠음. int 일듯
	int attack(int att) {
		if (att > hp) {
			hp = 0;
			System.out.println("HP가 0이 되어 캐릭터가 사망했습니다");
		} else {
			hp = hp - (att - dp);
		}
		return hp;
	}

	// 최종(현재) hp값
	int result() {
		System.out.println("현재체력 : " + hp);
		return hp;
	}

	// 회복방법
	int heel(int heel) {
		hp = hp + heel;
		// 만약 hp가 최대체력을 넘는다면 최대체력까지만 회복될 수 있게 설정
		if (hp > hhp) {
			hp = hhp;
		}
		return hp;
	}

//	문제 2.
//	총 이름이나 종류
//	명중률
//	발사(명중률 사용) 명중여부를 알려줌
//	연사(발사의 반복횟수) 명중된 내용을 확인할 수 있게
//	확인 : 총을 쏘고 평균 내기

	String gun; // 종류
	String name; // 이름
	int poi; // 명중률 설정
	double point;

	Silro_quiz5_1(String gun, String name, int poi) {
		// this 빼먹어서 명중률 값이 이상해짐
		// 그래서 발사했을때 결과값 자꾸 이상하게 나옴 꼭 this 쓰기
		this.gun = gun;
		this.name = name;
		this.poi = poi;
		System.out.println("종류 : " + gun);
		System.out.println("이름 : " + name);
		System.out.println("명중률 : " + poi + "%");
	}

	// 발사
	boolean shot1() {
		point = Math.random() * 100;// 명중률
		if (point > poi) {
			return false;
		} else {
			return true;
		}
	}

	// 연사

	void shot2(int n) {
		int number1 = 0;
		for (int i = 0; i <= n; i++) {
			shot1();
			if (shot1() == false) {
				number1 = number1 + 1; // number1 = 1; 명중하지 못했다.
			}
		}
		int number2 = n - number1;

		System.out.println(n + "발을 쏘고, " + number2 + "발 명중 했습니다.");
		System.out.println(n + "발을 쏘고, " + number1 + "발 명중하지 못했습니다.");
	}

//	문제 3. 가위 바위 보
//	내는 기능
//	두개의 결과를 판단해서 승패를 정하는 기능

	String scissors = "가위";
	String rock = "바위";
	String paper = "보";
	String name1 = "";
	String person1 = "";
	String name2 = "";
	String person2 = "";

	Silro_quiz5_1(String name1, String person1, String name2, String person2) {
		this.name1 = name1;
		this.name2 = name2;
		this.person1 = person1;
		this.person2 = person2;
	};

	void rsp() {
		// 이걸 조금 간단하게 할 수 있는 방법은 없을까?
		if (person1 == scissors && person2 == scissors) {
			System.out.println("비겼습니다.");
		} else if (person1 == scissors && person2 == rock) {
			System.out.println(name2 + "가(이) 이겼습니다.");
		} else if (person1 == scissors && person2 == paper) {
			System.out.println(name1 + "가(이) 이겼습니다.");
		} else if (person1 == rock && person2 == scissors) {
			System.out.println(name1 + "가(이) 이겼습니다.");
		} else if (person1 == rock && person2 == rock) {
			System.out.println("비겼습니다.");
		} else if (person1 == rock && person2 == paper) {
			System.out.println(name2 + "가(이) 이겼습니다.");
		} else if (person1 == paper && person2 == scissors) {
			System.out.println(name2 + "가(이) 이겼습니다.");
		} else if (person1 == paper && person2 == rock) {
			System.out.println(name1 + "가(이) 이겼습니다.");
		} else {
			System.out.println("비겼습니다.");
		}
	}

}
