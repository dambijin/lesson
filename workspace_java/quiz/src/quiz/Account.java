package quiz;

/*
 * 계좌 개설
 * 
 * 계좌번호, 잔액, 사용여부 (, 은행명, 예금주, 히스토리), 
 * 입금기능, 출금기능, 잔액조회기능(, 이체기능)
 * 
 */
public class Account {
	// 필드, 맴버변수
	String accNo;			// 은행명
	long balance = 0;		// 잔고
	boolean isUse = false;	// 계좌 사용 가능 여부
	
	Account(String accNo){
		this.accNo = accNo;
		this.balance = 1000;
	}
	
	//////////////////////////////////////////
	// 입금 기능				
	//
	// 잔액에 일정 금액을 더해서 저장		//
	//////////////////////////////////////////
	/*
	 * 메소드명 : in
	 * 전달인자 : long 일정 금액
	 * 리턴타입 : 없음
	 */
	void in(long balance) {
		if(balance > 0) {
			this.balance = this.balance + balance;
			System.out.println(balance +"원이 입금되었습니다");
		} else {
			System.out.println("입금액을 확인해주세요. 입금액:"+ balance);
		}
	}
	
	/**
	 *  출금 기능
	 *   - 출금이란? 잔액에서 일정 금액을 빼고 저장하기
	 *  메소드명 : out
	 *  전달인자 : long 출금할 금액
	 *  리턴타입 : 없음
	 */
	void out(long balance) {
		
		// 출금액이 잔액보다 클때 
		// 그리고 출금액이 양수일때
		if(this.balance >= balance && balance > 0) {
			
			this.balance = this.balance - balance;
			System.out.println(balance +"원이 출금되었습니다.");
			
		} else {
			System.out.println("출금액을 확인해주세요. 출금액:"+ balance);
		}
		
	}
	
	/**
	 * 잔액 조회
	 * 
	 * 메소드명 : print
	 * 전달인자 : 없음
	 * 리턴타입 : int 잔액
	 */
	long print() {
		System.out.println("잔액 : "+ this.balance);
		return this.balance;
	}
	
	void printAccInfo() {
		System.out.println("accNo : "+ this.accNo);
	}
	
}
