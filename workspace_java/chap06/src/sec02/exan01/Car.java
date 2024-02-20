package sec02.exan01;

import sec01.exan01.Student;

public class Car {
	// 필드
	String model = "그렌저";
	// 초기화를 안해 놓아도
	// 0, false, null로 자동 초기화 됨
	int speed;
	// int speed, s = 20;
	Student s1 = new Student();

	char c;

	int gas = 0;

	// speed 변수의 값을 60으로 바꾸는 행동으로 하는것
	// 여기는 행동을 못함 그래서 에러
	// speed=60;

	// gas의 값이 0이면 false
	// 그렇지 않으면 true

//	boolean isLeftGas() {
//	boolean result = false;
//	if (gas == 0) {
//		result = true;
//	} else {
//		result = false;
//	}
//	return result;
//}

	boolean isLeftGas() {
		boolean result = false;
		if (gas == 0) {
			return true;
		} else {
			return false;
		}
	}

//	boolean isLeftGas() {
//		return gas==0;
//	}

	// 필드 speed의 값을 10 증가
	void speedUp() {
		// speedUp()이 선언 되면 a가 메모리에 딱 등장!!
		int a= 1;
		speed = speed + 10;
	}
	// 필드 speed의 값을 10 감소
	void speedDown() {
		speed = speed - 10;
	}

}
