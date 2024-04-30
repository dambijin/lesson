package chap09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderExam {

	public static void main(String[] args) {
		MemberDTO m1= new MemberDTO();
		MemberDTO m2= new MemberDTO();
		MemberDTO m3= new MemberDTO();
		
		m1.setName("민수");
		m1.setAge(20);
		
		m2.setName("춘보");
		m2.setAge(22);
		
		m3.setName("병만");
		m3.setAge(21);
		
		System.out.println(compareMemberDTO(m1, m2));
		
		List list = new ArrayList();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
//		OrderBy ob=new OrderBy();
//		이름이 없는 클래스를 new하고
//		클래스명을 적어야 하는 곳에
//		Comparator ob= new (){
//		인터페이스명을 적용
//		단 하나의 인터페이스만 익명구현객체에 사용할 수 있다
		Comparator ob= new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				MemberDTO m1= (MemberDTO) o1;
				MemberDTO m2= (MemberDTO) o2;
				return m1.getAge() - m2.getAge();
			}
		};
		// 파괴함수 : 원본을 바꾼다
		Collections.sort(list, ob);
		
		System.out.println(list);
	}
	/*
	 * 전달인자 : MemberDTO 2개
	 * 리턴타입 : MemberDTO
	 * 기능 : 둘중에 나이가 큰 MemberDTO를 돌려줌
	 * 이름 : compareMemberDTO
	 */

	static MemberDTO compareMemberDTO(MemberDTO m1, MemberDTO m2) {
		MemberDTO result = m1;
		if(m2.getAge()>m1.getAge()) {
			result = m2;
		}
		return result;
	}
}
