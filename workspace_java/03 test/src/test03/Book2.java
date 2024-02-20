package test03;

public class Book2 {

	public static void main(String[] args) {

		Book1 book1 = new Book1("신데렐라", "셰익", "출판2", "", "456786");
		Book1 book2 = new Book1("인어공주", "스피어", "출판1", "2015", "4756");

		book1.bor();		
		book1.bor();
		book1.ret();
		book1.ret();
		book1.bor();
		book1.ret();
		book1.bor();
		
		

	}

}
