package beverageshopadminsubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import beverageemployeepublisher.Employee;
import beverageemployeepublisher.IEmployee;

public class AddEmployeeUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddEmployee;
	JButton buttonAllEmployees;
	JButton buttonUpdateEmployee;
	JButton buttonDeleteEmployee;
	JButton buttonSearchEmployee;
	
	private JFrame frame;
	private JLabel labelAddEmployee;
	private JLabel labelEmployeeId;
	private JTextField textFieldEmployeeId;
	private JLabel labelEmployeeName;
	private JTextField textFieldEmployeeName;
	private JLabel labelAddress;
	private JTextField textFieldAddress;
	private JLabel labelTelephone;
	private JTextField textFieldTelephone;
	private JLabel labelEmployeeType;
	private JTextField textFieldEmployeeType;
	private JButton buttonAdd;

	//Declare Employee Interface Class
	private IEmployee employeeService;
	
	public AddEmployeeUI(IEmployee employeeService) {
		
		this.employeeService = employeeService;
		//Called Initialize Method
		initialize();
	
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
		frame.setBounds(100, 100, 450, 450);
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
		
		//Add Employee Form
		//Title
		labelAddEmployee = new JLabel("Add Employee");
		labelAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAddEmployee.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelAddEmployee);
		
		//Employee ID Label
		labelEmployeeId = new JLabel("Employee ID");
		labelEmployeeId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelEmployeeId);
		//Employee ID Text
		textFieldEmployeeId = new JTextField();
		textFieldEmployeeId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldEmployeeId);
		textFieldEmployeeId.setColumns(10);
		
		//Employee Name Label
		labelEmployeeName = new JLabel("Employee Name");
		labelEmployeeName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelEmployeeName);
		//Employee Name Text
		textFieldEmployeeName = new JTextField();
		textFieldEmployeeName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldEmployeeName);
		textFieldEmployeeName.setColumns(10);
		
		//Address Label
		labelAddress = new JLabel("Address");
		labelAddress.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labelAddress);
		//Address Text
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		//Telephone Label
		labelTelephone = new JLabel("Telephone");
		labelTelephone.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(labelTelephone);
		//Telephone Text
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(304, 189, 122, 19);
		frame.getContentPane().add(textFieldTelephone);
		textFieldTelephone.setColumns(10);
		
		//Employee Type Label
		labelEmployeeType = new JLabel("Employee Type");
		labelEmployeeType.setBounds(198, 236, 96, 13);
		frame.getContentPane().add(labelEmployeeType);
		//Employee Type Text
		textFieldEmployeeType = new JTextField();
		textFieldEmployeeType.setBounds(304, 233, 122, 19);
		frame.getContentPane().add(textFieldEmployeeType);
		textFieldEmployeeType.setColumns(10);
		
		//Add Employee Submit Button
		buttonAdd = new JButton("Add Employee");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, empName, address, telephone, empType;
				
				//Get Values from Text Fields
				id = textFieldEmployeeId.getText().trim();
				empName = textFieldEmployeeName.getText().trim();
				address = textFieldAddress.getText().trim();
				telephone = textFieldTelephone.getText().trim();
				empType = textFieldEmployeeType.getText().trim();
				
				//Validations
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID","Error",JOptionPane.WARNING_MESSAGE);
				} else if(empName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee Name","Error",JOptionPane.WARNING_MESSAGE);
				} else if(address.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Address","Error",JOptionPane.WARNING_MESSAGE);
				} else if(telephone.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Phone No","Error",JOptionPane.WARNING_MESSAGE);
				} else if(empType.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee Type","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Employee employee = new Employee(id, empName, address, telephone, empType);
						boolean isEmployee = employeeService.addEmployee(employee);
						if(isEmployee) {
							//Set Text Fields to Null for Next Addition
							textFieldEmployeeId.setText("");
							textFieldEmployeeName.setText("");
							textFieldAddress.setText("");
							textFieldTelephone.setText("");
							textFieldEmployeeType.setText("");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Employee Add Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog( frame, "Cannot Add Employee","Error",JOptionPane.WARNING_MESSAGE);
							}
					} 
					catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
						}
				}	
			}	
		});
		
		buttonAdd.setBounds(266, 266, 150, 21);
		frame.getContentPane().add(buttonAdd);
		
	}

}
