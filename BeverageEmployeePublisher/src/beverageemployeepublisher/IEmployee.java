package beverageemployeepublisher;

import java.util.ArrayList;

public interface IEmployee {
	
	//Basic Implementation
	public boolean addEmployee(Employee employee);
	public boolean updateEmloyee(String id, Employee employee);
	public boolean deleteEmployee(String id);
	public Employee employeeGetById(String id);
	public ArrayList<Employee> getAllEmployees();

}
