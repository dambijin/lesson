package login;

public class LoginExam {

	public static void main(String[] args) {
		

		String id = "admin";
		String pw = "1234";
		
		Login user1= new Login(id ,pw);
		
		user1.doLogin();
		
		LoginNaver naver=new LoginNaver(id,pw);
		naver.doLogin();
		naver.goBlog();
		
		LoginGoogle google=new LoginGoogle(id,pw);
		google.doLogin();
		
		
	}

}
