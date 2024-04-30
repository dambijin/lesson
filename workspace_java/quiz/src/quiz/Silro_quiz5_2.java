package quiz;

public class Silro_quiz5_2 {

	public static void main(String[] args) {

		Silro_quiz5_1 game = new Silro_quiz5_1();
		game.attack(30);
		game.heel(10);
		game.result();
		
		System.out.println();
		
		
		Quiz5_3 gun1 = new Quiz5_3("라이플", "ak", 95);
		gun1.shot2(120);
		
		
		System.out.println();
		
		Silro_quiz5_1 rsp = new Silro_quiz5_1("민수", "가위", "실로", "보");
		rsp.rsp();

	}

}
