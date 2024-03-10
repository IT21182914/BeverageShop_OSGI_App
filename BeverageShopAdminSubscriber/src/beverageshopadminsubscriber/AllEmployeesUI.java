package beverageshopadminsubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import beverageemployeepublisher.Employee;
import beverageemployeepublisher.IEmployee;

public class AllEmployeesUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddEmployee;
	JButton buttonAllEmployees;
	JButton buttonUpdateEmployee;
	JButton buttonDeleteEmployee;
	JButton buttonSearchEmployee;
	JScrollPane scrollPane;
	
	private JFrame frame;
	private JLabel lableAllEmployees;
	private JTable table;
	
	//Declare Employee Interface Class
	private IEmployee employeeService;
	
	public AllEmployeesUI(IEmployee employeeService) {
		
		this.employeeService = employeeService;
		//Called Initialize Method
		initialize();
		
		//Create Employees ArrayList
		ArrayList<Employee> employees = employeeService.getAllEmployees();
		
		if (!employees.isEmpty()) {
		    List<Object[]> list = new ArrayList<Object[]>();
		    for (int i = 0; i < employees.size(); i++) {
		        list.add(new Object[] { employees.get(i).getId(), employees.get(i).getEmpName(), employees.get(i).getAddress(), employees.get(i).getTelephone(), employees.get(i).getEmpType() });
		    }
		    table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), new String[] {"ID","Name", "Address", "Telephone", "Type"}));
		}
	
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminMainUI(employeeService);
				frame.setVisible(false);
			}
		});
		
		buttonAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEmployeeUI(employeeService);
				frame.setVisible(false);
			}
		});
		
		buttonAllEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllEmployeesUI(employeeService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateEmployeeUI(employeeService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteEmployeeUI(employeeService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchEmployeeUI(employeeService);
				frame.setVisible(false);
			}
		});
		
	}
	
	//Initialize Method
	private void initialize() {
		
		//Create Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 300);
		frame.setTitle("Beverage Cafe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		//Create Menu
		//Home Menu Button
		buttonHome = new JButton("Home");
		buttonHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(buttonHome);
		//Add Employee Menu Button
		buttonAddEmployee = new JButton("Add Employee");
		buttonAddEmployee.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddEmployee);
		//All Employees Menu Button
		buttonAllEmployees = new JButton("All Employees");
		buttonAllEmployees.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllEmployees);
		//Update Employee Menu Button
		buttonUpdateEmployee = new JButton("Update Employee");
		buttonUpdateEmployee.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateEmployee);
		//Delete Employee Menu Button
		buttonDeleteEmployee = new JButton("Delete Employee");
		buttonDeleteEmployee.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteEmployee);
		//Search Employee Menu Button
		buttonSearchEmployee = new JButton("Search Employee");
		buttonSearchEmployee.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchEmployee);
		
		//Title
		lableAllEmployees = new JLabel("All Employees");
		lableAllEmployees.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableAllEmployees.setBounds(375, 16, 124, 17);
		frame.getContentPane().add(lableAllEmployees);
		
		//Employee List Table
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 500, 184);
		frame.getContentPane().add(scrollPane);

	}

}
