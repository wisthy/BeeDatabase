package be.shoktan.beeDatabase.models;

import java.util.List;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Class to regroup bees or other group of bees to simplify mutation description
 * @author Wisthy
 *
 */
@Entity
public class Group extends AbstractModel{
	@Required
	private String name;
	
	private List<Specie> members; 
	/* TODO: @Wisthy 2014/07/30 - replace Specie by the higher level "Specification" 
	 * that will regroup both Species and Groups once it is created */

	/**
	 * @param name
	 */
	public Group(String name) {
		super();
		this.name = name;
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
}
