package cashiersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import beverageemployeepublisher.Employee;
import beverageemployeepublisher.IEmployee;
import beveragepublisher.Beverage;
import beveragepublisher.IBeverage;
import billitempublisher.BillItem;
import billitempublisher.IBillItem;

public class UpdateBillItemUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBillItem;
	JButton buttonAllBillItems;
	JButton buttonUpdateBillItem;
	JButton buttonDeleteBillItem;
	JButton buttonSearchBillItem;
	
	private JFrame fromUpdateBillItem;
	private JLabel labelQty;
	private JTextField textFieldQty;
	private JComboBox comboEmployee;
	private JComboBox comboBeverage;
	private DefaultTableModel tablemodel;
	private JTable table;

	//Declare Interface Classes
	private IEmployee employeeService;
	private IBeverage beverageService;
	private IBillItem billItemService;
	
	//Create ArrayLists
	private ArrayList<Object[]> billItemsList = new ArrayList<>();
	private ArrayList<BillItem> billItems = new ArrayList<>();
	private ArrayList<Employee> employeeList = new ArrayList<>();
	private ArrayList<Beverage> beverageList = new ArrayList<>();
	
	private int selectedRow;
	
	public UpdateBillItemUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
		//Called Initialize Method
		initialize();
	}

	//Initialize Method
	private void initialize() {
		
		//Create Frame
		fromUpdateBillItem = new JFrame();
		fromUpdateBillItem.setTitle("Beverage Cafe");
		fromUpdateBillItem.setBounds(100, 100, 1000, 500);
		fromUpdateBillItem.getContentPane().setLayout(null);
		fromUpdateBillItem.setVisible(true);
		
		//Create Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 205, 434);
		fromUpdateBillItem.getContentPane().add(panel);
		
		//Create Menu
		//Home Menu Button
		buttonHome = new JButton("Home");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(employeeService, beverageService, billItemService);
				fromUpdateBillItem.setVisible(false);
			}
		});
		buttonHome.setBounds(10, 12, 185, 23);
		panel.add(buttonHome);
		//Add Bill Item Menu Button
		buttonAddBillItem = new JButton("Add Bill Item");
		buttonAddBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBillItemUI(employeeService, beverageService, billItemService);
				fromUpdateBillItem.setVisible(false);
			}
		});
		buttonAddBillItem.setBounds(10, 55, 185, 23);
		panel.add(buttonAddBillItem);
		//Item List Menu Button
		buttonAllBillItems = new JButton("Item List");
		buttonAllBillItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBillItemsUI(employeeService, beverageService, billItemService);
				fromUpdateBillItem.setVisible(false);
			}
		});
		buttonAllBillItems.setBounds(10, 98, 185, 23);
		panel.add(buttonAllBillItems);
		//Update Bill Item Menu Button
		buttonUpdateBillItem = new JButton("Update Bill Item");
		buttonUpdateBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBillItemUI(employeeService, beverageService, billItemService);
				fromUpdateBillItem.setVisible(false);
			}
		});
		buttonUpdateBillItem.setBounds(10, 144, 185, 23);
		panel.add(buttonUpdateBillItem);
		//Delete Bill Item Menu Button
		buttonDeleteBillItem = new JButton("Delete Bill Item");
		buttonDeleteBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBillItemUI(employeeService, beverageService, billItemService);
				fromUpdateBillItem.setVisible(false);
			}
		});
		buttonDeleteBillItem.setBounds(10, 188, 185, 23);
		panel.add(buttonDeleteBillItem);
		//Search Bill Item Menu Button
		buttonSearchBillItem = new JButton("Search Bill Item");
		buttonSearchBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBillItemUI(employeeService, beverageService, billItemService);
				fromUpdateBillItem.setVisible(false);
			}
		});
		buttonSearchBillItem.setBounds(10, 232, 185, 23);
		panel.add(buttonSearchBillItem);
		
		//Create Panel for Update Bill Item Form and Table
		JPanel scrollPane1 = new JPanel();
		scrollPane1.setBounds(215, 0, 759, 25);
		fromUpdateBillItem.getContentPane().add(scrollPane1);
		panel.setLayout(null);
		
		//Update Bill Item Form and Table
		//Title
		JLabel lableAllBillItems = new JLabel("Update Item");
		lableAllBillItems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableAllBillItems.setBounds(215, 5, 759, 17);
		scrollPane1.add(lableAllBillItems);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 29, 759, 113);
		fromUpdateBillItem.getContentPane().add(scrollPane);
		
		//Bill Item Table
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] {"ID", "Date", "Cashier", "Beverage", "Total"}
		));
		
		scrollPane.setViewportView(table);
		
		//Select Button
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Select a Row
				selectedRow = table.getSelectedRow();
				
				//Validation
				if(selectedRow < 0) {
					JOptionPane.showMessageDialog(fromUpdateBillItem, "Please Select Row", "Data Missing", JOptionPane.ERROR_MESSAGE);
				} else {
					BillItem billItem = billItems.get(selectedRow);
					comboEmployee.setSelectedItem(billItem.getEmployee().getEmpName());
				}
			
			}
		});
		
		btnSelect.setBounds(538, 150, 89, 23);
		fromUpdateBillItem.getContentPane().add(btnSelect);
		
		//Cashier Dropdown
		comboEmployee = new JComboBox();
		comboEmployee.setEditable(true);
		comboEmployee.setEnabled(false);
		comboEmployee.setBounds(515, 185, 179, 28);
		fromUpdateBillItem.getContentPane().add(comboEmployee);
		
		//Beverage Dropdown
		comboBeverage = new JComboBox();
		comboBeverage.setBounds(515, 236, 179, 28);
		fromUpdateBillItem.getContentPane().add(comboBeverage);
		
		//Beverage Label
		JLabel lblNewLabel_1 = new JLabel("Beverage");
		lblNewLabel_1.setBounds(435, 243, 60, 14);
		fromUpdateBillItem.getContentPane().add(lblNewLabel_1);
		
		//Cashier Label
		JLabel lblNewLabel = new JLabel("Cashier");
		lblNewLabel.setBounds(435, 192, 70, 14);
		fromUpdateBillItem.getContentPane().add(lblNewLabel);
		
		//Quantity Label
		labelQty = new JLabel("Qty");
		labelQty.setBounds(435, 284, 70, 14);
		fromUpdateBillItem.getContentPane().add(labelQty);
		//Quantity Text
		textFieldQty = new JTextField();
		textFieldQty.setBounds(515, 277, 179, 28);
		fromUpdateBillItem.getContentPane().add(textFieldQty);
		
		//Update Bill Item Button
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BillItem billItem = billItems.get(selectedRow);
				Beverage bevObj = null;
				int total = 0;
				
				String selectedBev = comboBeverage.getSelectedItem().toString().trim();
				
				for(Beverage obj : beverageList) {
					if(obj.getBeverageName().contentEquals(selectedBev)) {
						bevObj = obj;
						//Total Calculation
						total = Integer.valueOf(obj.getPrice()) * Integer.valueOf(textFieldQty.getText().trim());
						break;
					}
				}
				
				billItem.setBeverage(bevObj);
				billItem.setTotal(Integer.toString(total));
				
				if(billItemService.updateBillItem(billItem.getId(), billItem)) {
					//Success Message
					JOptionPane.showMessageDialog(fromUpdateBillItem, "Bill Item Update Sucessfully","Success", JOptionPane.PLAIN_MESSAGE);
					
					tablemodel.setRowCount(0);
					loadTableData();
					loadData();
					textFieldQty.setText("");
				} else {
					JOptionPane.showMessageDialog(fromUpdateBillItem, "Something Went Wrong","Error", JOptionPane.ERROR_MESSAGE);
				}
		
			}	
		});
		
		btnUpdate.setBounds(538, 320, 89, 23);
		fromUpdateBillItem.getContentPane().add(btnUpdate);
		
		tablemodel = (DefaultTableModel) table.getModel();
		
		//Called Methods
		loadData();
		loadTableData();
		
	}
	
	//Load Employee List and Beverage List for Dropdowns
	private void loadData() {
		
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
	
	//Load Data to Table
	private void loadTableData() {
		
		billItems = billItemService.getAllBillItems();
		
		if(billItems != null) {
			Object[] data  = new Object[5];
			
			for(BillItem obj : billItems) {
				data[0] = obj.getId();
				data[1] = obj.getDate();
				data[2] = obj.getEmployee().getEmpName();
				data[3] = obj.getBeverage().getBeverageName();
				data[4] = obj.getTotal();
						
				tablemodel.addRow(data);
			}
		} else {
			Object[] data  = new Object[3];
			tablemodel.addRow(data);
		}
		
	}

}
