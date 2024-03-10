package cashiersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import beverageemployeepublisher.Employee;
import beverageemployeepublisher.IEmployee;
import beveragepublisher.Beverage;
import beveragepublisher.IBeverage;
import billitempublisher.BillItem;
import billitempublisher.IBillItem;

public class AddBillItemUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBillItem;
	JButton buttonAllBillItems;
	JButton buttonUpdateBillItem;
	JButton buttonDeleteBillItem;
	JButton buttonSearchBillItem;
	
	private JFrame fromeAddEmployeeTo;
	private JComboBox comboEmployee;
	private JComboBox comboBeverage;
	private JLabel labelItemId;
	private JTextField textFieldItemId;
	private JLabel labelDate;
	private JTextField textFieldDate;
	private JLabel labelQty;
	private JTextField textFieldQty;

	//Declare Interface Classes
	private IBeverage beverageService;
	private IEmployee employeeService;
	private IBillItem billItemService;
	
	//Create ArrayLists
	private ArrayList<Employee> employeeList = new ArrayList<>();
	private ArrayList<Beverage> beverageList = new ArrayList<>();
	
	public AddBillItemUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
		//Called Initialize Method
		initialize();
	}

	//Initialize Method
	private void initialize() {
		
		//Create Frame
		fromeAddEmployeeTo = new JFrame();
		fromeAddEmployeeTo.setTitle("Beverage Cafe");
		fromeAddEmployeeTo.setBounds(100, 100, 560, 500);
		fromeAddEmployeeTo.getContentPane().setLayout(null);
		fromeAddEmployeeTo.setVisible(true);
		
		//Create Panel
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 205, 261);
		fromeAddEmployeeTo.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Create Menu
		//Home Menu Button
		buttonHome = new JButton("Home");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(employeeService, beverageService, billItemService);
				fromeAddEmployeeTo.setVisible(false);
			}
		});
		buttonHome.setBounds(10, 12, 185, 23);
		panel.add(buttonHome);
		//Add Bill Item Menu Button
		buttonAddBillItem = new JButton("Add Bill Item");
		buttonAddBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBillItemUI(employeeService, beverageService, billItemService);
				fromeAddEmployeeTo.setVisible(false);
			}
		});
		buttonAddBillItem.setBounds(10, 55, 185, 23);
		panel.add(buttonAddBillItem);
		//Item List Menu Button
		buttonAllBillItems = new JButton("Item List");
		buttonAllBillItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBillItemsUI(employeeService, beverageService, billItemService);
				fromeAddEmployeeTo.setVisible(false);
			}
		});
		buttonAllBillItems.setBounds(10, 98, 185, 23);
		panel.add(buttonAllBillItems);
		//Update Bill Item Menu Button
		buttonUpdateBillItem = new JButton("Update Bill Item");
		buttonUpdateBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBillItemUI(employeeService, beverageService, billItemService);
				fromeAddEmployeeTo.setVisible(false);
			}
		});
		buttonUpdateBillItem.setBounds(10, 144, 185, 23);
		panel.add(buttonUpdateBillItem);
		//Delete Bill Item Menu Button
		buttonDeleteBillItem = new JButton("Delete Bill Item");
		buttonDeleteBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBillItemUI(employeeService, beverageService, billItemService);
				fromeAddEmployeeTo.setVisible(false);
			}
		});
		buttonDeleteBillItem.setBounds(10, 188, 185, 23);
		panel.add(buttonDeleteBillItem);
		//Search Bill Item Menu Button
		buttonSearchBillItem = new JButton("Search Bill Item");
		buttonSearchBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBillItemUI(employeeService, beverageService, billItemService);
				fromeAddEmployeeTo.setVisible(false);
			}
		});
		buttonSearchBillItem.setBounds(10, 232, 185, 23);
		panel.add(buttonSearchBillItem);
		
		//Create Panel for Add Bill Item Form
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(215, 0, 329, 500);
		fromeAddEmployeeTo.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		comboEmployee = new JComboBox();
		comboEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {	
			}
			@Override
			public void mousePressed(MouseEvent e) {
				String employee = comboEmployee.getSelectedItem().toString().trim();
				
				Employee empObj = null;
				
				for(Employee obj : employeeList) {
					if(obj.getEmpName().contentEquals(employee)) {
						empObj = obj;
						break;
					}
				}
			}
		});
		
		comboBeverage = new JComboBox();
		comboBeverage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
				String beverage = comboBeverage.getSelectedItem().toString().trim();
				
				Beverage bevObj = null;
				
				for(Beverage obj : beverageList) {
					if(obj.getBeverageName().contentEquals(beverage)) {
						bevObj = obj;
						break;
					}
				}
			}
		});

		//Add Bill Item Form
		//Title
		JLabel labelAddBillItem = new JLabel("Add Bill Item");
		labelAddBillItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAddBillItem.setBounds(130, 16, 124, 17);
		panel_1.add(labelAddBillItem);
		
		//Cashier Label
		JLabel lblNewLabel = new JLabel("Cashier");
		lblNewLabel.setBounds(10, 59, 70, 14);
		panel_1.add(lblNewLabel);
		//Cashier Dropdown
		comboEmployee.setBounds(90, 54, 179, 28);
		panel_1.add(comboEmployee);
		
		//Date Label
		labelDate = new JLabel("Date");
		labelDate.setBounds(10, 112, 46, 14);
		panel_1.add(labelDate);
		//Date Text
		textFieldDate = new JTextField();
		textFieldDate.setBounds(90, 105, 179, 28);
		panel_1.add(textFieldDate);
		
		//Bill Item ID Label
		labelItemId = new JLabel("Item ID");
		labelItemId.setBounds(10, 163, 96, 13);
		panel_1.add(labelItemId);
		//Bill Item ID Text
		textFieldItemId = new JTextField();
		textFieldItemId.setBounds(90, 156, 179, 28);
		panel_1.add(textFieldItemId);
		
		//Beverage Label
		JLabel lblNewLabel_1 = new JLabel("Beverage");
		lblNewLabel_1.setBounds(10, 214, 75, 14);
		panel_1.add(lblNewLabel_1);
		//Beverage Dropdown
		comboBeverage = new JComboBox();
		comboBeverage.setBounds(90, 207, 179, 28);
		panel_1.add(comboBeverage);
		
		//Quantity Label
		labelQty = new JLabel("Qty");
		labelQty.setBounds(10, 255, 96, 13);
		panel_1.add(labelQty);
		//Quantity Text
		textFieldQty = new JTextField();
		textFieldQty.setBounds(90, 248, 179, 28);
		panel_1.add(textFieldQty);
		
		//Add Bill Item Submit Button
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Get Values from Text Fields
				String id = textFieldItemId.getText().trim();
				String date = textFieldDate.getText().trim();
				String employee = comboEmployee.getSelectedItem().toString().trim();
				String beverage = comboBeverage.getSelectedItem().toString().trim();
				int total = 0;
				
				//Validations
				if(comboEmployee.getSelectedIndex() == 0 || comboBeverage.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(fromeAddEmployeeTo, "Please Select Cashier and Beverage", "Error", JOptionPane.WARNING_MESSAGE);
				} else if(id.isEmpty()) {
					JOptionPane.showMessageDialog( fromeAddEmployeeTo, "Please Enter Bill Item ID","Error",JOptionPane.WARNING_MESSAGE);
				} else if(date.isEmpty()) {
					JOptionPane.showMessageDialog( fromeAddEmployeeTo, "Please Enter Date","Error",JOptionPane.WARNING_MESSAGE);
				} else if(textFieldQty.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog( fromeAddEmployeeTo, "Please Enter Quantity","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					//Declare and Initialization null value
					Employee employeeObj = null;
					Beverage beverageObj = null;
					
					for(Employee obj : employeeList) {
						if(obj.getEmpName().contentEquals(employee)) {
							employeeObj = obj;
							break;
						}
					}
					
					for(Beverage obj : beverageList) {
						if(obj.getBeverageName().contentEquals(beverage)) {
							beverageObj = obj;
							//Total Calculation
							total = Integer.valueOf(obj.getPrice()) * Integer.valueOf(textFieldQty.getText().trim());
							break;
						}
					}
					
					BillItem billItem = new BillItem(id, date, beverageObj, employeeObj, Integer.toString(total));
					
					billItemService.addBillItem(billItem);
					//Set Text Fields to Null for Next Addition
					textFieldItemId.setText("");
					textFieldDate.setText("");
					loadData();
					textFieldQty.setText("");
					
					//Success Message
					JOptionPane.showMessageDialog(fromeAddEmployeeTo, "Bill Item Add Sucessfully", "Success", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		btnSave.setBounds(129, 300, 89, 23);
		panel_1.add(btnSave);
		fromeAddEmployeeTo.setVisible(true);
		
		loadData();
	}
	
	//Load Employee List and Beverage List for Dropdowns
	private void loadData() {
		
		comboEmployee.removeAllItems();
		comboBeverage.removeAllItems();
		
		employeeList = new ArrayList<>();
		beverageList = new ArrayList<>();
		
		employeeList = employeeService.getAllEmployees();
		beverageList = beverageService.getBeverageList();
		
		comboEmployee.addItem("Select Cashier");
		if(employeeList != null) {
			for(Employee obj : employeeList) {
				comboEmployee.addItem(obj.getEmpName());
			}
		}
		
		comboBeverage.addItem("Select Beverage");
		if(beverageList != null) {
			for(Beverage obj : beverageList) {
				comboBeverage.addItem(obj.getBeverageName());
			}
		}
		
	}

}
