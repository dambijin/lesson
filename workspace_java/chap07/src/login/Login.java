package login;

public class Login {
	
	String id;
	String password;

	Login(String id, String password){
		System.out.println("Login 생성자 실행");
		this.id=id;
		this.password=password;
	}
	
	void doLogin() {
		System.out.println("로그인 중입니다...");
	}
	
}
