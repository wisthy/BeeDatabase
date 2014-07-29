package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class User extends Model{
	private static final long serialVersionUID = -5000399410103490477L;

	@Id
	private Long id;
	
	@Required
	private String login;
	
	@Required
	private String password;

	/**
	 * @param login
	 * @param password
	 */
	private User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);
}
