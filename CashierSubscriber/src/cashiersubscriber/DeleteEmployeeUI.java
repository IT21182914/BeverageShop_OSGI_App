package cashiersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import beverageemployeepublisher.Employee;
import beverageemployeepublisher.IEmployee;

public class DeleteEmployeeUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddEmployee;
	JButton buttonAllEmployees;
	JButton buttonUpdateEmployee;
	JButton buttonDeleteEmployee;
	JButton buttonSearchEmployee;
	
	private JFrame frame;
	private JLabel labelDeleteEmployee;
	private JLabel labelDelete;
	private JTextField textFieldDelete;
	private JButton buttonSearch;
	private JTextArea textAreaDelete;
	private JButton buttonDelete;
	
	//Declare Employee Interface Class
	private IEmployee employeeService;
	
	public DeleteEmployeeUI(IEmployee employeeService) {
		
		this.employeeService = employeeService;
		//Called Initialize Method
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

	//Initialize Method
	private void initialize() {
		
		//Create Frame
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
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
		
		//Delete Section
		//Title
		labelDeleteEmployee = new JLabel("Delete Employee");
		labelDeleteEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDeleteEmployee.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelDeleteEmployee);
		
		buttonDelete = new JButton("Delete");
		frame.getContentPane().add(buttonDelete);
		
		labelDelete = new JLabel("Employee ID");
		labelDelete.setBounds(180, 45, 100, 13);
		frame.getContentPane().add(labelDelete);
		
		textFieldDelete = new JTextField();
		textFieldDelete.setBounds(278, 43, 96, 19);
		frame.getContentPane().add(textFieldDelete);
		textFieldDelete.setColumns(10);
		
		//Search Employee Button
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID Value
				String id = textFieldDelete.getText().trim();
				
				//Validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {	
						Employee employee = employeeService.employeeGetById(id);
						if(employee != null) {
							//Employee Details
							textAreaDelete.setText("Employee ID : " + employee.getId()  +
									"\nEmployee Name : " + employee.getEmpName() +
									"\nAddress : " + employee.getAddress() +
									"\nPhone Number : " + employee.getTelephone() +
									"\nEmployee Type : " + employee.getEmpType() + "\n");
						} else {
							textAreaDelete.setText("\n\nSorry, But Nothing Matched Your Search \nEmployee. Please Try Again With Different \nEmployee ID.");
							JOptionPane.showMessageDialog( frame, "Cannot Find Employee","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						textAreaDelete.setText("Something Went Wrong");
						JOptionPane.showMessageDialog( frame, "Something went wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
			
			}
		});
		
		buttonSearch.setBounds(384, 43, 75, 21);
		frame.getContentPane().add(buttonSearch);
		
		textAreaDelete = new JTextArea();
		textAreaDelete.setBounds(180, 70, 279, 126);
		frame.getContentPane().add(textAreaDelete);
		
		//Delete Button
		buttonDelete = new JButton("Delete Employee");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID Number
				String id = textFieldDelete.getText().trim();
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						boolean isEmployee = employeeService.deleteEmployee(id);
						if(isEmployee) {
							textFieldDelete.setText("");
							//Success Message
							textAreaDelete.setText("\n\nEmployee Deleted Sucessfully");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Employee Deleted Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							textAreaDelete.setText("\n\nCannot Delete Employee");
							JOptionPane.showMessageDialog( frame, "Cannot Delete Employee","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						textAreaDelete.setText("\n\nSomething Went Wrong..!");
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		
		buttonDelete.setBounds(274, 219, 152, 21);
		frame.getContentPane().add(buttonDelete);
	}
	
}
