package beveragepublisher;

public class Beverage {
	
	//Declare Variables
	private String id;
	private String beverageName;
	private String price;
	private String beverageType;
	
	/**
	 * @param id
	 * @param beverageName
	 * @param price
	 * @param beverageType
	 */
	public Beverage(String id, String beverageName, String price, String beverageType) {
		this.id = id;
		this.beverageName = beverageName;
		this.price = price;
		this.beverageType = beverageType;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the beverageName
	 */
	public String getBeverageName() {
		return beverageName;
	}

	/**
	 * @param beverageName the beverageName to set
	 */
	public void setBeverageName(String beverageName) {
		this.beverageName = beverageName;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the beverageType
	 */
	public String getBeverageType() {
		return beverageType;
	}

	/**
	 * @param beverageType the beverageType to set
	 */
	public void setBeverageType(String beverageType) {
		this.beverageType = beverageType;
	}
	
}
