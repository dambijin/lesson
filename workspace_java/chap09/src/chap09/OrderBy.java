package chap09;

import java.util.Comparator;

public class OrderBy implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		MemberDTO m1= (MemberDTO) o1;
		MemberDTO m2= (MemberDTO) o2;
		return 0;
	}

}
