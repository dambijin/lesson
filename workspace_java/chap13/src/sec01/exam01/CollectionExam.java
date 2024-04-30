package sec01.exam01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionExam {

	public static void main(String[] args) {
		List list = new ArrayList();

		System.out.println(list.isEmpty());
		list.add(1);
		System.out.println(list.isEmpty());
		
		int a = (int)list.get(0);
		System.out.println(a);
		
//		System.out.println(list.get(10));
		list = new ArrayList();
		
		Map map = new HashMap();
		map.put("key","value");
		map.put("key2","value2");
		
		String key = (String)map.get("key");
		//null이면 진짜 null값을 넣었던가 키를 put하지 않음
		System.out.println(map.get("key3"));
		
		String title;
		String artist;
		String pt;
		String content;
		
		map.put("title", 1);
		map.put("artist", 1);
		map.put("pt", 1);
		map.put("content", 1);
		list.add(map);
		
	}

}
