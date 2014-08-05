package be.shoktan.beeDatabase.models;

import javax.persistence.Entity;

import be.shoktan.beeDatabase.models.attributs.EFertility;
import be.shoktan.beeDatabase.models.attributs.EHumidity;
import be.shoktan.beeDatabase.models.attributs.ETemperature;
import be.shoktan.beeDatabase.models.attributs.ETolerance;
import play.data.validation.Constraints.Required;

/**
 * model representif a specie of a bee
 * @author Wisthy
 *
 */
@Entity
public class Specie extends AbstractModel {
	@Required
	private String name;
	
	private boolean natural = false;
	
	@Required
	private Branch branch;
	
	private EFertility fertility = EFertility.normal;
	
	private ETemperature temperature = ETemperature.normal;
	private ETolerance temperatureTolerance = ETolerance.none;
	
	private EHumidity humidity = EHumidity.normal;
	private ETolerance humidityTolerance = ETolerance.none;
	
	private Group group;

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
	 * @return the natural
	 */
	public boolean isNatural() {
		return natural;
	}

	/**
	 * @param natural the natural to set
	 */
	public void setNatural(boolean natural) {
		this.natural = natural;
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
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
	 * @return the fertility
	 */
	public EFertility getFertility() {
		return fertility;
	}

	/**
	 * @param fertility the fertility to set
	 */
	public void setFertility(EFertility fertility) {
		this.fertility = fertility;
	}

	/**
	 * @return the temperature
	 */
	public ETemperature getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(ETemperature temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the temperatureTolerance
	 */
	public ETolerance getTemperatureTolerance() {
		return temperatureTolerance;
	}

	/**
	 * @param temperatureTolerance the temperatureTolerance to set
	 */
	public void setTemperatureTolerance(ETolerance temperatureTolerance) {
		this.temperatureTolerance = temperatureTolerance;
	}

	/**
	 * @return the humidity
	 */
	public EHumidity getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(EHumidity humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the humidityTolerance
	 */
	public ETolerance getHumidityTolerance() {
		return humidityTolerance;
	}

	/**
	 * @param humidityTolerance the humidityTolerance to set
	 */
	public void setHumidityTolerance(ETolerance humidityTolerance) {
		this.humidityTolerance = humidityTolerance;
	}

	/**
	 * @param name
	 * @param natural
	 * @param branch
	 * @param fertility
	 * @param temperature
	 * @param temperatureTolerance
	 * @param humidity
	 * @param humidityTolerance
	 */
	public Specie(String name, boolean natural, Branch branch,
			EFertility fertility, ETemperature temperature,
			ETolerance temperatureTolerance, EHumidity humidity,
			ETolerance humidityTolerance) {
		super();
		this.name = name;
		this.natural = natural;
		this.branch = branch;
		this.fertility = fertility;
		this.temperature = temperature;
		this.temperatureTolerance = temperatureTolerance;
		this.humidity = humidity;
		this.humidityTolerance = humidityTolerance;
	}

	/**
	 * @param name
	 * @param natural
	 * @param branch
	 * @param fertility
	 * @param temperature
	 * @param temperatureTolerance
	 * @param humidity
	 * @param humidityTolerance
	 * @param group
	 */
	public Specie(String name, boolean natural, Branch branch,
			EFertility fertility, ETemperature temperature,
			ETolerance temperatureTolerance, EHumidity humidity,
			ETolerance humidityTolerance, Group group) {
		super();
		this.name = name;
		this.natural = natural;
		this.branch = branch;
		this.fertility = fertility;
		this.temperature = temperature;
		this.temperatureTolerance = temperatureTolerance;
		this.humidity = humidity;
		this.humidityTolerance = humidityTolerance;
		this.group = group;
	}



	public static Finder<Long, Specie> find = new Finder<Long, Specie>(Long.class, Specie.class);
}
