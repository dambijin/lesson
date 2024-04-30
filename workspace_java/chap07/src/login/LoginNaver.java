package login;

public class LoginNaver extends Login{

	LoginNaver(String id, String pw) {
		super(id, pw);
		
	}
	
	@Override
	void doLogin() {
		System.out.println("네이버에 로그인 중입니다...");
	}
	
	void goBlog() {
		System.out.println("네이버 블로그로 이동 중입니다...");
	}

}
