package cashiersubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import beverageemployeepublisher.IEmployee;
import beveragepublisher.IBeverage;
import billitempublisher.IBillItem;

public class BillItemUI {
	
	JButton buttonHome;
	JButton buttonAddBillItem;
	JButton buttonAllBillItems;
	JButton buttonUpdateBillItem;
	JButton buttonDeleteBillItem;
	JButton buttonSearchBillItem;
	
	private JFrame frame;

	private IBeverage beverageService;
	private IEmployee employeeService;
	private IBillItem billItemService;
	
	public BillItemUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
		initialize();
	
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(billItemService);
				frame.setVisible(false);
			}
		});
		
		buttonAddBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBillItemUI(employeeService, beverageService, billItemService);
				frame.setVisible(false);
			}
		});
		
		buttonAllBillItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBillItemsUI(employeeService, beverageService, billItemService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBillItemUI(employeeService, beverageService, billItemService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBillItemUI(employeeService, beverageService, billItemService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBillItemUI(employeeService, beverageService, billItemService);
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
		
		buttonAddBillItem = new JButton("Add Bill Item");
		buttonAddBillItem.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddBillItem);
		
		buttonAllBillItems = new JButton("Item List");
		buttonAllBillItems.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllBillItems);
		
		buttonUpdateBillItem = new JButton("Update Bill Item");
		buttonUpdateBillItem.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateBillItem);
		
		buttonDeleteBillItem = new JButton("Delete Bill Item");
		buttonDeleteBillItem.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteBillItem);
		
		buttonSearchBillItem = new JButton("Search Bill Item");
		buttonSearchBillItem.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchBillItem);
	}

}
