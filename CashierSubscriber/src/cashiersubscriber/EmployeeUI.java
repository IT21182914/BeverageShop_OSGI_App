package cashiersubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import beverageemployeepublisher.IEmployee;

public class EmployeeUI {
	
	JButton buttonHome;
	JButton buttonAddEmployee;
	JButton buttonAllEmployees;
	JButton buttonUpdateEmployee;
	JButton buttonDeleteEmployee;
	JButton buttonSearchEmployee;
	
	private JFrame frame;

	private IEmployee employeeService;
	
	public EmployeeUI(IEmployee employeeService) {
		this.employeeService = employeeService;
		initialize();
	
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(employeeService);
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
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Beverage Cafe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		buttonHome = new JButton("Home");
		buttonHome.setBounds(10, 12, 140, 21);
		frame.getContentPane().add(buttonHome);
		
		buttonAddEmployee = new JButton("Add Employee");
		buttonAddEmployee.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddEmployee);
		
		buttonAllEmployees = new JButton("All Employees");
		buttonAllEmployees.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllEmployees);
		
		buttonUpdateEmployee = new JButton("Update Employee");
		buttonUpdateEmployee.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateEmployee);
		
		buttonDeleteEmployee = new JButton("Delete Employee");
		buttonDeleteEmployee.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteEmployee);
		
		buttonSearchEmployee = new JButton("Search Employee");
		buttonSearchEmployee.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchEmployee);
	}

}
