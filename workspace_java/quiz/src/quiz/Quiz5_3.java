package quiz;

public class Quiz5_3 {

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

	Quiz5_3(String gun, String name, int poi) {
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

}
