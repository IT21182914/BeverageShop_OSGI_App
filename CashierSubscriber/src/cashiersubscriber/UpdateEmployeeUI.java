package cashiersubscriber;

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

public class UpdateEmployeeUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddEmployee;
	JButton buttonAllEmployees;
	JButton buttonUpdateEmployee;
	JButton buttonDeleteEmployee;
	JButton buttonSearchEmployee;
	
	private JFrame frame;
	private JLabel labelUpdateEmployee;
	private JLabel labelUpdateEmployeeId;
	private JTextField textFieldUpdateEmployeeId;
	private JLabel labelUpdateEmployeeName;
	private JTextField textFieldUpdateEmployeeName;
	private JLabel labeUpdatelAddress;
	private JTextField textFieldUpdateAddress;
	private JLabel labelUpdateTelephone;
	private JTextField textFieldUpdateTelephone;
	private JLabel labelUpdateEmployeeType;
	private JTextField textFieldUpdateEmployeeType;
	private JButton buttonUpdate;

	//Declare Employee Interface Class
	private IEmployee employeeService;
	
	public UpdateEmployeeUI(IEmployee employeeService) {
		
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
		frame.setBounds(100, 100, 550, 450);
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
		
		//Update Employee Form
		//Title
		labelUpdateEmployee = new JLabel("Update Employee");
		labelUpdateEmployee.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUpdateEmployee.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelUpdateEmployee);
		
		//Employee ID Label
		labelUpdateEmployeeId = new JLabel("Employee ID");
		labelUpdateEmployeeId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelUpdateEmployeeId);
		//Employee ID Text
		textFieldUpdateEmployeeId = new JTextField();
		textFieldUpdateEmployeeId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldUpdateEmployeeId);
		textFieldUpdateEmployeeId.setColumns(10);
		
		//Employee Name Label
		labelUpdateEmployeeName = new JLabel("Employee Name");
		labelUpdateEmployeeName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelUpdateEmployeeName);
		//Employee Name Text
		textFieldUpdateEmployeeName = new JTextField();
		textFieldUpdateEmployeeName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldUpdateEmployeeName);
		textFieldUpdateEmployeeName.setColumns(10);
		
		//Address Label
		labeUpdatelAddress = new JLabel("Address");
		labeUpdatelAddress.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labeUpdatelAddress);
		//Address Text
		textFieldUpdateAddress = new JTextField();
		textFieldUpdateAddress.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldUpdateAddress);
		textFieldUpdateAddress.setColumns(10);
		
		//Telephone Label
		labelUpdateTelephone = new JLabel("Telephone");
		labelUpdateTelephone.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(labelUpdateTelephone);
		//Telephone Text
		textFieldUpdateTelephone = new JTextField();
		textFieldUpdateTelephone.setBounds(304, 189, 117, 19);
		frame.getContentPane().add(textFieldUpdateTelephone);
		textFieldUpdateTelephone.setColumns(10);
		
		//Employee Type Label
		labelUpdateEmployeeType = new JLabel("Employee Type");
		labelUpdateEmployeeType.setBounds(198, 236, 96, 13);
		frame.getContentPane().add(labelUpdateEmployeeType);
		//Employee Type Text
		textFieldUpdateEmployeeType = new JTextField();
		textFieldUpdateEmployeeType.setBounds(304, 233, 117, 19);
		frame.getContentPane().add(textFieldUpdateEmployeeType);
		textFieldUpdateEmployeeType.setColumns(10);
		
		//Update Employee Button
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, empName, address, telephone, empType;
				
				//Get Values from Text Fields
				id = textFieldUpdateEmployeeId.getText().trim();
				empName = textFieldUpdateEmployeeName.getText().trim();
				address = textFieldUpdateAddress.getText().trim();
				telephone = textFieldUpdateTelephone.getText().trim();
				empType = textFieldUpdateEmployeeType.getText().trim();
				
				//Validations
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else if(empName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee Name","Error",JOptionPane.WARNING_MESSAGE);
				} else if(address.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Address","Error",JOptionPane.WARNING_MESSAGE);
				} else if(telephone.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Address","Error",JOptionPane.WARNING_MESSAGE);
				} else if(empType.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee Type","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Employee employee = new Employee(id, empName, address, telephone, empType);
						boolean isEmployee =employeeService.updateEmloyee(id, employee);
						if(isEmployee) {
							//Set Text Fields to Null for Next Addition
							textFieldUpdateEmployeeId.setText("");
							textFieldUpdateEmployeeName.setText("");
							textFieldUpdateAddress.setText("");
							textFieldUpdateTelephone.setText("");
							textFieldUpdateEmployeeType.setText("");
								
							//Success Message
							JOptionPane.showMessageDialog( frame, "Employee Update Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog( frame, "Cannot Update Employee","Error",JOptionPane.WARNING_MESSAGE);
							}
					} catch (Exception ex) {
							JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}	
				
			}
		});
		
		buttonUpdate.setBounds(266, 266, 85, 21);
		frame.getContentPane().add(buttonUpdate);
		
		//Find Button
		JButton buttonUpdateFind = new JButton("Find");
		buttonUpdateFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID from Search Bar
				String id = textFieldUpdateEmployeeId.getText().trim();
				
				//Validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Employee ID Number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Employee employee = employeeService.employeeGetById(id);
						if(employee != null) {
							//Set Values
							textFieldUpdateEmployeeName.setText(employee.getEmpName());
							textFieldUpdateAddress.setText(employee.getAddress());
							textFieldUpdateTelephone.setText(employee.getTelephone());
							textFieldUpdateEmployeeType.setText(employee.getEmpType());	
						} else {
							JOptionPane.showMessageDialog( frame, "Cannot Find Employee","Error",JOptionPane.WARNING_MESSAGE);
						}
					} 
					catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		buttonUpdateFind.setBounds(430, 55, 64, 21);
		frame.getContentPane().add(buttonUpdateFind);
		
	}

}
