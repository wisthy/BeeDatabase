package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import play.db.*;

/**
 * Abstract model class for the common stuff of all the other models 
 * @author Wisthy
 *
 */
@Entity
public abstract class AbstractModel {
	@Id
	@GeneratedValue(generator="increment")
	//@GenericGenerator(name="increment", strategy = "increment")
	private long id;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	public static AbstractModel findById(Long id) {
		  return JPA.em().find(AbstractModel.class, id);
		}
	
}
