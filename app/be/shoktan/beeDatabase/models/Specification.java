package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;

import play.data.validation.Constraints.Required;

/**
 * Class used to represent of bee or a group of bees
 * usefull for mutation representation
 * @author Wisthy
 *
 */
@Entity
public class Specification extends AbstractModel implements Comparable<Specification>{
	private Group group;
	
	@Required
	private ESpecification type;

	/**
	 * 
	 * @param group
	 * @param type
	 */
	public Specification(Group group, ESpecification type) {
		super();
		this.group = group;
		this.type = type;
	}

	/**
	 * 
	 * @param type
	 */
	public Specification(ESpecification type) {
		super();
		this.type = type;
	}
	
	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(Group group) {
		this.group = group;
	}

	/**
	 * @return the type
	 */
	public ESpecification getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(ESpecification type) {
		this.type = type;
	}





	public static Finder<Long, Specification> find = new Finder<Long, Specification>(Long.class, Specification.class);
	
	public enum ESpecification{
		SPECIE, GROUP;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Specification o) {
		int i = this.type.compareTo(o.type);
		if(i == 0) return new Long(getId()).compareTo(o.getId());
		return 0;
	}
}
