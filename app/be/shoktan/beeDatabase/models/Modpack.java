package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * the goal of this class is to represent the version of the modpack for which the data are inserted
 * @author Wisthy
 *
 */
@Entity
public class Modpack extends AbstractModel {
	private static final long serialVersionUID = 377548008816086879L;
	
	@Required
	private String name;
	
	@Required
	private String version;

	/**
	 * @param name
	 */
	public Modpack(String name, String version) {
		super();
		this.name = name;
		this.version = version;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}	
	
	public static Finder<Long, Modpack> find = new Finder<Long, Modpack>(Long.class, Modpack.class);
}
