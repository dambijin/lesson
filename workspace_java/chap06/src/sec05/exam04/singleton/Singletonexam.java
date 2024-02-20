package sec05.exam04.singleton;

public class Singletonexam {

	public static void main(String[] args) {

//		Singleton singleton = Singleton.test();
//		Singleton singleton2 = Singleton.test();

		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();

		System.out.println(singleton1 == singleton2);

	}

}
