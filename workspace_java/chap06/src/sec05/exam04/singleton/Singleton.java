package sec05.exam04.singleton;

public class Singleton {

	// static Singleton s =null;
	static Singleton s = new Singleton();
	
	private Singleton() {

	}

	static Singleton getInstance() {
		Singleton.s = new Singleton();
		return Singleton.s;
	}

}
