package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;

/**
 * Model class to represent a possible mutation
 * @author Wisthy
 *
 */
@Entity
public class Mutation extends AbstractModel{
	private Specification[] parents;
	private String remark;
	
	/**
	 * @param parents
	 * @param remark
	 */
	public Mutation(Specification[] parents, String remark) {
		super();
		//assert(parents.length == 2)
		this.parents = parents;
		this.remark = remark;
	}

	/**
	 * @param parents
	 */
	public Mutation(Specification[] parents) {
		this(parents, null);
	}
	
	
	/**
	 * @param firstParent
	 * @param SecondParent
	 * @param remark
	 */
	public Mutation(Specification firstParent, Specification secondParent, String remark) {
		this(new Specification[]{firstParent, secondParent}, remark);
	}
	
	
	/**
	 * @param firstParent
	 * @param SecondParent
	 */
	public Mutation(Specification firstParent, Specification secondParent) {
		this(firstParent, secondParent, null);
	}

	/**
	 * @return the parents
	 */
	public Specification[] getParents() {
		return parents;
	}

	/**
	 * @param parents the parents to set
	 */
	public void setParents(Specification[] parents) {
		this.parents = parents;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
