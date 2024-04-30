package proj8.practice;

public class BankClass {
	
	private int result = 0; // 현재잔액
	String bankname= "";
	
//	생성자
	public BankClass(int result, String bankname){
		this.result=result;
		this.bankname=bankname;
		System.out.println("계좌생성 완료");
		System.out.println("처음 잔액 : "+result);
		System.out.println("은행 이름 : "+bankname);
	}
	
//	잔액 값 가져오는 메소드
	int getResult() {
		return result;
	}
	
//	입금
	int deposit(String depstr){	
		int dep=  Integer.parseInt(depstr);
		if(dep>0) {
			int res = result+dep;
			this.result=res;
			System.out.println(result+"원 정상 입금 완료");	
		} else {
			System.out.println("입금할 금액이 없습니다.");
		}
		return result;
	}
	
//	출금
	int payment(String paystr){
		int pay=Integer.parseInt(paystr);
		if(result>pay) {
			int res=result-pay;
			this.result=res;
			System.out.println(result+"출금이 완료되었습니다.");
		} else {
			System.out.println("잔액이 부족합니다.");
		}
		return result;
	}
	
	
	

}
