package DesignPattern;

public class Singleton {

	static Singleton instance;

	private Singleton() {}

	public static Singleton getInstance() {

		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}

	public static void main(String[] args) {

		System.out.println(Singleton.getInstance());

	}
}
