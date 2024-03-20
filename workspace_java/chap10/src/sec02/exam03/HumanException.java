package sec02.exam03;

public class HumanException extends Exception{

	HumanException(){
		System.out.println("HumanException 생성자 실행");
	}
	
	HumanException(String message){
		super(message);
		System.out.println("String 생성자 실행");
	}
	
}