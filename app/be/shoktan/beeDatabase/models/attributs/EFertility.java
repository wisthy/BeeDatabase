package be.shoktan.beeDatabase.models.attributs;

/**
 * @author Wisthy
 * Enumeration to represent the fertility rate of a bee
 */
public enum EFertility {
	

	low(1),
	normal(2),
	high(3),
	max(4);
	
	private int value;
	
	/**
	 * @param value
	 */
	private EFertility(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	
	
}
