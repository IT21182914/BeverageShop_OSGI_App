package cashiersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import beverageemployeepublisher.IEmployee;
import beveragepublisher.IBeverage;
import billitempublisher.BillItem;
import billitempublisher.IBillItem;

public class DeleteBillItemUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBillItem;
	JButton buttonAllBillItems;
	JButton buttonUpdateBillItem;
	JButton buttonDeleteBillItem;
	JButton buttonSearchBillItem;
	
	private JFrame fromDeleteBillItem;

	//Declare Interfaces Class
	private IEmployee employeeService;
	private IBeverage beverageService;
	private IBillItem billItemService;
	private JTable table;
	private DefaultTableModel tablemodel;
	
	//Create ArrayLists
	private ArrayList<Object[]> billItemsList = new ArrayList<>();
	private ArrayList<BillItem> billItems = new ArrayList<>();
	
	private int selectedRow;
	
	public DeleteBillItemUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
		//Called Initialize Method
		initialize();
		
	}

	//Initialize Method
	private void initialize() {
		
		//Create Frame
		fromDeleteBillItem = new JFrame();
		fromDeleteBillItem.setTitle("Beverage Cafe");
		fromDeleteBillItem.setBounds(100, 100, 1000, 305);
		fromDeleteBillItem.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		fromDeleteBillItem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 205, 261);
		fromDeleteBillItem.getContentPane().add(panel);
		
		//Create Menu
		//Home Menu Button
		buttonHome = new JButton("Home");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(employeeService, beverageService, billItemService);
				fromDeleteBillItem.setVisible(false);
			}
		});
		buttonHome.setBounds(10, 12, 185, 23);
		panel.add(buttonHome);
		//Add Bill Item Menu Button
		buttonAddBillItem = new JButton("Add Bill Item");
		buttonAddBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBillItemUI(employeeService, beverageService, billItemService);
				fromDeleteBillItem.setVisible(false);
			}
		});
		buttonAddBillItem.setBounds(10, 55, 185, 23);
		panel.add(buttonAddBillItem);
		//Item List Menu Button
		buttonAllBillItems = new JButton("Item List");
		buttonAllBillItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBillItemsUI(employeeService, beverageService, billItemService);
				fromDeleteBillItem.setVisible(false);
			}
		});
		buttonAllBillItems.setBounds(10, 98, 185, 23);
		panel.add(buttonAllBillItems);
		//Update Bill Item Menu Button
		buttonUpdateBillItem = new JButton("Update Bill Item");
		buttonUpdateBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBillItemUI(employeeService, beverageService, billItemService);
				fromDeleteBillItem.setVisible(false);
			}
		});
		buttonUpdateBillItem.setBounds(10, 144, 185, 23);
		panel.add(buttonUpdateBillItem);
		//Delete Bill Item Menu Button
		buttonDeleteBillItem = new JButton("Delete Bill Item");
		buttonDeleteBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBillItemUI(employeeService, beverageService, billItemService);
				fromDeleteBillItem.setVisible(false);
			}
		});
		buttonDeleteBillItem.setBounds(10, 188, 185, 23);
		panel.add(buttonDeleteBillItem);
		//Search Bill Item Menu Button
		buttonSearchBillItem = new JButton("Search Bill Item");
		buttonSearchBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBillItemUI(employeeService, beverageService, billItemService);
				fromDeleteBillItem.setVisible(false);
			}
		});
		buttonSearchBillItem.setBounds(10, 232, 185, 23);
		panel.add(buttonSearchBillItem);
		
		JPanel scrollPane1 = new JPanel();
		scrollPane1.setBounds(215, 0, 759, 25);
		fromDeleteBillItem.getContentPane().add(scrollPane1);
		panel.setLayout(null);
		
		//Delete Section
		//Title
		JLabel lableAllBillItems = new JLabel("Delete Item");
		lableAllBillItems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableAllBillItems.setBounds(215, 5, 759, 17);
		scrollPane1.add(lableAllBillItems);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(217, 31, 757, 136);
		fromDeleteBillItem.getContentPane().add(scrollPane);
		
		//Bill Item Table
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "ID", "Date", "Cashier", "Beverage", "Total" }
		));
		
		scrollPane.setViewportView(table);
		
		//Select Button
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Select a Row
				selectedRow = table.getSelectedRow();
				
				if(selectedRow < 0) {
					JOptionPane.showMessageDialog(fromDeleteBillItem, "Please Select Row", "Data Missing", JOptionPane.ERROR_MESSAGE);
				} else {
					BillItem billItem = billItems.get(selectedRow);
				    int option = JOptionPane.showConfirmDialog(fromDeleteBillItem, "Are You Sure to Delete This", "Delete Bill Item", JOptionPane.YES_NO_OPTION);
				    
				    if(option == 0) {
				    	billItemService.deleteBillItem(billItem.getId());
				    	tablemodel.setRowCount(0);
				    	//Called Load Table Data
				    	loadTableData();
				    }
				}
			
			}
		});
		
		btnDelete.setBounds(541, 201, 89, 23);
		fromDeleteBillItem.getContentPane().add(btnDelete);
		fromDeleteBillItem.setVisible(true);
		
		tablemodel = (DefaultTableModel) table.getModel();
		//Called Load Table Data
		loadTableData();
		
	}
	
	//Load Table Data Method
	private void loadTableData() {
		
		billItems = billItemService.getAllBillItems();
		
		if(billItems != null) {
			//Create an Object
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
			//Create an Object
			Object[] data  = new Object[5];
			tablemodel.addRow(data);
		}
		
	}

}
