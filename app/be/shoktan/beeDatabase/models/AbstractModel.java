package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

/**
 * Abstract model class for the common stuff of all the other models 
 * @author Wisthy
 *
 */
@Entity
public class AbstractModel extends Model{
	@Id
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
	
	
}
