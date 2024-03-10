package beverageemployeepublisher;

public class Employee {
	
	//Declare Variables
	private String id;
	private String empName;
	private String address;
	private String telephone;
	private String empType;
	
	/**
	 * @param id
	 * @param empName
	 * @param address
	 * @param telephone
	 * @param empType
	 */
	public Employee(String id, String empName, String address, String telephone, String empType) {
		this.id = id;
		this.empName = empName;
		this.address = address;
		this.telephone = telephone;
		this.empType = empType;
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
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}


	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	/**
	 * @return the empType
	 */
	public String getEmpType() {
		return empType;
	}


	/**
	 * @param empType the empType to set
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

}
