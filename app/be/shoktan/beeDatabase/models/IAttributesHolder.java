package be.shoktan.beeDatabase.models;

import java.util.List;

import be.shoktan.beeDatabase.models.attributs.IAttribute;
import be.shoktan.beeDatabase.models.attributs.EAttribute;

/**
 * Interface to manage the classes that hold information about attributes
 * @author Wisthy
 *
 */
public interface IAttributesHolder {
	/**
	 * @return all the attributes of the holder
	 */
	List<Couple<EAttribute, IAttribute>> getAttributes();
	
	/**
	 * check if the holder has the provided attribute or not
	 * @param searched the attribute to search for
	 * @return true if the holder has the attribute, false otherwise
	 */
	boolean hasAttribute(EAttribute type, IAttribute searched);
}
