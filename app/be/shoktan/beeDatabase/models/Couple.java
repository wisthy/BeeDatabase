package be.shoktan.beeDatabase.models;

/**
 * Utility model class to store to objects in one
 * @author Wisthy
 *
 */
public class Couple<A, B> {
	private A a;
	private B b;
	
	/**
	 * @param a
	 * @param b
	 */
	public Couple(A a, B b) {
		super();
		this.a = a;
		this.b = b;
	}

	/**
	 * @return the a
	 */
	public A getA() {
		return a;
	}

	/**
	 * @return the b
	 */
	public B getB() {
		return b;
	}
	
	
}
