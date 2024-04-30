package sec01.exam07;

public class StringExam {

	public static void main(String[] args) {
		String s1 = "영일이삼사오영일이삼사오";
		char c = s1.charAt(3);
		System.out.println("c : " + c);

		int idx = s1.indexOf("사오");
		System.out.println("이삼 idx : " + idx);

		// 정확히 일치하는게 없으면 -1
		int idx2 = s1.indexOf("이사");
		System.out.println("이사 idx2 : " + idx2);

		String blog = "blog.naver.com";
		String cafe = "cafe.naver.com";

		if (blog.indexOf("blog") != -1) {
			System.out.println("블로그 주소");
		} else {
			System.out.println("블로그가 아니네요");
		}

		if (cafe.indexOf("cafe") != -1) {
			System.out.println("카페 주소");
		} else {
			System.out.println("카페가 아니네요");
		}
		
		if(blog.endsWith(".com")) {
			System.out.println("[.com]으로 끝납니다");
		}

//		이메일 점검
//		"@"하나만 있는지
//		"."하나 이상 있는지
		
//		첫번째 전달인자를 "모두" 두번째 전달인자로 바꿈
		String s2 = s1.replace("삼사", "34");
		System.out.println("replace결과 s2 : " + s2);
		
//		첫번째 인덱스부터 두번째 바로 전까지
		String s3 = s1.substring(1, 4);
		System.out.println("substring결과 s3 : " + s3);
		
		String s4="콩비,순대,제육,선지";
		String[] menus = s4.split(",");
		for(int i=0; i<menus.length; i++) {
			System.out.println(menus[i]);
		}
		
//		blog.naver.com
//		String[] urls=blog.split("[.]");
		String[] urls=blog.split("\\.");
		for(int i=0; i<urls.length; i++) {
			System.out.println(urls[i]);
		}
		
//		indexOf, substring 사용해서
//		"cafe.naver.com"에서 naver만 추출
//		"blog.daum.net"에서 daum만 추출
		String si1 = "cafe.naver.com";
		String si2 = "blog.daum.net";		
		int index1=si1.indexOf(".");
		int index2=si1.indexOf(".com");
		System.out.println("index1 : "+index1);
		System.out.println("index2 : "+index2);
		String sub1=si1.substring(index1+1,index2);
		System.out.println("sub1 : "+sub1);
		
		
		
		
		
	}

}
