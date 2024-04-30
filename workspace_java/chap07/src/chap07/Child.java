package chap07;

public class Child extends Parent {

	int num;
//	overshadow
//	부모의 name을 덮어쓰게 됨
	String name = "Child의 name";

	Child(){
//		부모의 생성자 호출
		// 항상 제일 처음에 실행되어야 함
//		부모 생성자를 호출하지 않으면
//		맨 위에 super();가 자동 호출 됨
		super("asdf");
//		// 다른 생성자 호출
//		// 항상 제일 처음에 실행되어야 함
//		this(-1);
		System.out.println("Child의 기본 생성자");
	}
	
//	Child(int num){
//		System.out.println("Child의 기본 생성자(int num)");
//		this.num = num;
//	}
	
//	shadow
//	전달인자가 필드를 가리는 현상
	void setNum(int num) {
		this.num = num;
	}

	int getNum() {
		System.out.println("Child의 getNum실행");
		return num;
	}

	void test() {
//		자식에 부모와 같은 필드가 있는 경우 덮어씀
		System.out.println("name : " + name);
		System.out.println("this.name : " + this.name);

//		지역 변수니까 name 적어도 필드와 관계없음
		String name = getName();
//		부모의 name이 출력됨
		System.out.println("name 두번째 : " + name);
		
//		부모 메소드 사용
		name=super.getName();
		System.out.println("super.getName() : "+name);
		
		System.out.println("this.name : "+this.name);
		System.out.println("super.name : "+super.name);

		this.name="1234";
		System.out.println("this.name : "+this.name);
		System.out.println("super.name : "+super.name);
	}
	
	@Override
	String getName() {
		super.getName();
		System.out.println("Child의 getName 실행");
		return this.name;
	}
	
//	@Override
//	String getName(String name) {
//		System.out.println("Child의 getName 실행");
//		return this.name;
//	}
	
	
//	부모의메소드 명과 전달인자의 종류가 같은 경우
//	무조건 리턴타입도 동일해야 함
//	String echo(String i) {
//		System.out.println("echo 실행");
//		return null;
//	}

}
