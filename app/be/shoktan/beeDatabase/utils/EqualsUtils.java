package be.shoktan.beeDatabase.utils;


/**
 * Utility class to facilitate "equals" calls
 * @author Wisthy
 *
 */
public class EqualsUtils {

	/**
	 * compare to objects with null-safe management 
	 * @param a
	 * @param b
	 * @return true if the two objects are equals (including both null), false otherwise
	 */
	public static boolean equalsNullSafe(Object a, Object b) {
		if(a == null && b == null){
			return true;
		}
		
		if(a == null || b == null){
			return false;
		}
		
		return a.equals(b);
	}
	
}
