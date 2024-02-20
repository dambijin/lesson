package arraylist;

import java.util.ArrayList;

public class ListExam {

	public static void main(String[] args) {

		// 추가된 순서를 0부터 시작하는 index로 관리
		ArrayList list = new ArrayList();

		// 추가
		list.add("담비");
		list.add(1);

		// list.add("담비") <--이게 그냥 맨 뒤에
		// list.add(0,"담비")<--이러면 맨 앞에
		// list.add(1,"담비")<--이러면 두번재에 들어감
		
		// 가져오기
		String name = (String) list.get(0);
		int num = (int) list.get(1);

		// 크기 계산
		int length = list.size();
	}

}
