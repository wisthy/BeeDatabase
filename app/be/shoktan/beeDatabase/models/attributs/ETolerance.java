package be.shoktan.beeDatabase.models.attributs;

/**
 * Enumeration to represent the range of tolerance 
 * of a bee to environment value for temperature or humidity
 * @author Wisthy
 */
public enum ETolerance implements IAttribute {
	none(EToleranceType.both, 0),
	down_1(EToleranceType.down, 1),
	down_2(EToleranceType.down, 2),
	up_1(EToleranceType.up, 1),
	up_2(EToleranceType.up, 2),
	both_1(EToleranceType.both, 1),
	both_2(EToleranceType.both, 2);
	

	private int value;
	private EToleranceType type;
	
	/**
	 * @param value
	 * @param type
	 */
	private ETolerance(EToleranceType type, int value) {
		this.value = value;
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the type
	 */
	public EToleranceType getType() {
		return type;
	}
}
