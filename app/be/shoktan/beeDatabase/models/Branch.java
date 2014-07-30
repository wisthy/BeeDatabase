package be.shoktan.beeDatabase.models;

import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Class to regroup bees in branches
 * @author Wisthy
 *
 */
@Entity
public class Branch extends AbstractModel {
	@Required 
	private String name; // use a new AbstractNamedModel?
	
	//@OneToMany // don't know the import and don't have access to it now, to enable later when not running behind a proxy
	private List<Specie> members;
	
	// TODO: 2014/07/30 @Wisthy - store the mod owning this branch?

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
	 * @return the members
	 */
	public List<Specie> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Specie> members) {
		this.members = members;
	}

	/**
	 * @param name
	 */
	public Branch(String name) {
		super();
		this.name = name;
	}
}
