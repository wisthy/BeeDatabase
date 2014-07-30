package be.shoktan.beeDatabase.models;

import java.util.List;

import javax.persistence.Entity;

import be.shoktan.beeDatabase.models.Specification.ESpecification;
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
	
	private Specification specification;
	
	private List<Specification> members; 

	/**
	 * @param name
	 */
	public Group(String name) {
		super();
		this.name = name;
		this.specification = new Specification(ESpecification.GROUP);
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
	public List<Specification> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Specification> members) {
		this.members = members;
	}
	
	/**
	 * add a new member to the group
	 * @param member the new member to add
	 * @return true if the member has been successfully added, false otherwise
	 */
	public boolean addMember(Specification member){
		if(this.members != null){
			return this.members.add(member);
		}else{
			return false;
		}
	}
	
	/**
	 * remove a member to the group
	 * @param member the member to remove
	 * @return true if the member has been successfully removed, false otherwise
	 */
	public boolean removeMember(Specification member){
		if(this.members != null){
			return this.members.remove(member);
		}else{
			return false;
		}
	}	
	
	public static Finder<Long, Group> find = new Finder<Long, Group>(Long.class, Group.class);
	
	public boolean isMemberOf(Specification member){
		if(member == null || this.members == null) {
			return false;
		}
		// TODO: 2014/07/30 Wisthy - add a sort for optimization
		for(Specification s : this.members){
			switch(s.getType()){
			case GROUP:
				Group group = Group.findFromSpecification(s);
				if(group != null){
					if(group.isMemberOf(member)){
						return true;
					}
				}
				break;
			case SPECIE:
				if(member.equals(s)) {
					return true;
				}
				break;
			default:
				// TODO: 2014/07/30 Wisthy - shouldn't happen, throw an error
			}
		}
		
		return false;
	}
	
	public static Group findFromSpecification(Specification specification){
		if(specification == null || specification.getType() != ESpecification.GROUP){
			return null;
		}
		
		return findFromSpecification(specification.getId()); // TODO: 2014/07/30 Wisthy - replace by correct call to find
	}
	
	public static Group findFromSpecification(long specification){		
		return null; // TODO: 2014/07/30 Wisthy - replace by correct call to find
	}
}
