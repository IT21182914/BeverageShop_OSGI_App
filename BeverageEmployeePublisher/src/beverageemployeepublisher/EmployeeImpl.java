package beverageemployeepublisher;

import java.util.ArrayList;

public class EmployeeImpl implements IEmployee {
	
	//Create an Employee List
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	//Add Employee Method
	@Override
	public boolean addEmployee(Employee employee) {
		employeeList.add(employee);
		return true;
	}

	//Update Employee Method
	@Override
	public boolean updateEmloyee(String id, Employee employee) {
		if (employeeList.isEmpty()) {
			return false;
		} else {
			int i = -1;
			for (Employee object : employeeList) {
				i = i + 1;
				if (object.getId().equals(id)) {
					employeeList.set(i, new Employee(employee.getId(), employee.getEmpName(), employee.getAddress(), employee.getTelephone(), employee.getEmpType()));
					return true;
				}
			}
			return false;
		}
	}

	//Delete Employee Method
	@Override
	public boolean deleteEmployee(String id) {
		if(employeeList.isEmpty()) {
			return false;
		}
		else {
			for(Employee employee : employeeList ) {
				if(employee.getId().equals(id)) {
					employeeList.remove(employee);
					return true;
				}
			}
			return false;
		}
	}

	//Employee Get By ID Method
	@Override
	public Employee employeeGetById(String id) {
		if(employeeList.isEmpty()) {
			return null;
		}
		else {
			for(Employee employee : employeeList) {
				if(employee.getId().equals(id)) {
					return employee;
				}
			}
			return null;
		}
	}

	//Get All Employees Method
	@Override
	public ArrayList<Employee> getAllEmployees() {
		return employeeList;
	}

}
