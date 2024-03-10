package billitempublisher;

import beverageemployeepublisher.Employee;
import beveragepublisher.Beverage;

public class BillItem {
	
	//Declare Variables
	private String id;
	private String date;
	private Beverage beverage;
	private Employee employee;
	private String total;
	
	/**
	 * @param id
	 * @param date
	 * @param beverage
	 * @param employee
	 * @param total
	 */
	public BillItem(String id, String date, Beverage beverage, Employee employee, String total) {
		this.id = id;
		this.date = date;
		this.beverage = beverage;
		this.employee = employee;
		this.total = total;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the beverage
	 */
	public Beverage getBeverage() {
		return beverage;
	}

	/**
	 * @param beverage the beverage to set
	 */
	public void setBeverage(Beverage beverage) {
		this.beverage = beverage;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

}
