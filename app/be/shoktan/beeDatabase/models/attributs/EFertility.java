package be.shoktan.beeDatabase.models.attributs;

/**
 * Enumeration to represent the fertility rate of a bee
 * @author Wisthy
 */
public enum EFertility implements IAttribute{
	

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
