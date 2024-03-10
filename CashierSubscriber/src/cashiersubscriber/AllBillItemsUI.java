package cashiersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import beverageemployeepublisher.IEmployee;
import beveragepublisher.IBeverage;
import billitempublisher.BillItem;
import billitempublisher.IBillItem;

public class AllBillItemsUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBillItem;
	JButton buttonAllBillItems;
	JButton buttonUpdateBillItem;
	JButton buttonDeleteBillItem;
	JButton buttonSearchBillItem;
	
	private JFrame fromAllBillItems;

	//Declare Interface Classes
	private IEmployee employeeService;
	private IBeverage beverageService;
	private IBillItem billItemService;
	private JTable table;
	
	//Create ArrayLists
	private ArrayList<Object[]> billItemsList = new ArrayList<>();
	private ArrayList<BillItem> billItems = new ArrayList<>();
	
	public AllBillItemsUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
		//Called Initialize Method
		initialize();
		
	}

	//Initialize Method
	private void initialize() {
		
		billItems = billItemService.getAllBillItems();
		
		if(billItems != null) {
			for(BillItem obj : billItems) {
				billItemsList.add(new Object[] { obj.getId(), obj.getDate(), obj.getEmployee().getEmpName(), obj.getBeverage().getBeverageName(), obj.getTotal() });
			}
		}
		
		//Create Frame
		fromAllBillItems = new JFrame();
		fromAllBillItems.setTitle("Beverage Cafe");
		fromAllBillItems.setBounds(100, 100, 1000, 305);
		fromAllBillItems.getContentPane().setLayout(null);
		fromAllBillItems.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 205, 261);
		fromAllBillItems.getContentPane().add(panel);
		
		//Create Menu
		//Home Menu Button
		buttonHome = new JButton("Home");
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(employeeService, beverageService, billItemService);
				fromAllBillItems.setVisible(false);
			}
		});
		buttonHome.setBounds(10, 12, 185, 23);
		panel.add(buttonHome);
		//Add Bill Item Menu Button
		buttonAddBillItem = new JButton("Add Bill Item");
		buttonAddBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBillItemUI(employeeService, beverageService, billItemService);
				fromAllBillItems.setVisible(false);
			}
		});
		buttonAddBillItem.setBounds(10, 55, 185, 23);
		panel.add(buttonAddBillItem);
		//Item List Menu Button
		buttonAllBillItems = new JButton("Item List");
		buttonAllBillItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBillItemsUI(employeeService, beverageService, billItemService);
				fromAllBillItems.setVisible(false);
			}
		});
		buttonAllBillItems.setBounds(10, 98, 185, 23);
		panel.add(buttonAllBillItems);
		//Update Bill Item Button
		buttonUpdateBillItem = new JButton("Update Bill Item");
		buttonUpdateBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBillItemUI(employeeService, beverageService, billItemService);
				fromAllBillItems.setVisible(false);
			}
		});
		buttonUpdateBillItem.setBounds(10, 144, 185, 23);
		panel.add(buttonUpdateBillItem);
		//Delete Bill Item Button
		buttonDeleteBillItem = new JButton("Delete Bill Item");
		buttonDeleteBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBillItemUI(employeeService, beverageService, billItemService);
				fromAllBillItems.setVisible(false);
			}
		});
		buttonDeleteBillItem.setBounds(10, 188, 185, 23);
		panel.add(buttonDeleteBillItem);
		//Search Bill Item Button
		buttonSearchBillItem = new JButton("Search Bill Item");
		buttonSearchBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBillItemUI(employeeService, beverageService, billItemService);
				fromAllBillItems.setVisible(false);
			}
		});
		buttonSearchBillItem.setBounds(10, 232, 185, 23);
		panel.add(buttonSearchBillItem);
		
		JPanel scrollPane1 = new JPanel();
		scrollPane1.setBounds(215, 0, 759, 25);
		fromAllBillItems.getContentPane().add(scrollPane1);
		panel.setLayout(null);
		
		//Title
		JLabel lableAllBillItems = new JLabel("Item List");
		lableAllBillItems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableAllBillItems.setBounds(215, 5, 759, 17);
		scrollPane1.add(lableAllBillItems);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(215, 29, 759, 197);
		fromAllBillItems.getContentPane().add(scrollPane);
		
		//Bill Item Table
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			billItemsList.toArray(new Object[][] {}),
			new String[] { "ID", "Date", "Cashier", "Beverage", "Total" }
		));
		
	}

}
