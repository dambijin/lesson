package login;

public class LoginGoogle extends Login{

	LoginGoogle(String id, String password){
		super(id,password);
	}

	@Override
	void doLogin() {
		System.out.println("구글에 로그인 중입니다...");
	}
	
}
