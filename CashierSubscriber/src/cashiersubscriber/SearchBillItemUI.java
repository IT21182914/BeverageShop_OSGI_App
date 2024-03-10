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

import beverageemployeepublisher.IEmployee;
import beveragepublisher.IBeverage;
import billitempublisher.BillItem;
import billitempublisher.IBillItem;

public class SearchBillItemUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBillItem;
	JButton buttonAllBillItems;
	JButton buttonUpdateBillItem;
	JButton buttonDeleteBillItem;
	JButton buttonSearchBillItem;
	
	private JFrame frame;
	private JLabel labelSearchBillItem;
	private JLabel labelEnterBillItemId;
	private JTextField textFieldSearch;
	private JButton buttonSearch;
	private JTextArea textAreaSearchResult;
	
	//Declare Interface Classes
	private IBillItem billItemService;
	private IBeverage beverageService;
	private IEmployee employeeService;
	
	public SearchBillItemUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
		//Called Initialize Method
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
		//Add Bill Item Menu Button
		buttonAddBillItem = new JButton("Add Bill Item");
		buttonAddBillItem.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddBillItem);
		//Bill Item List Menu Button
		buttonAllBillItems = new JButton("Bill Item List");
		buttonAllBillItems.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllBillItems);
		//Update Bill Item Menu Button
		buttonUpdateBillItem = new JButton("Update Bill Item");
		buttonUpdateBillItem.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateBillItem);
		//Delete Bill Item Menu Button
		buttonDeleteBillItem = new JButton("Delete Bill Item");
		buttonDeleteBillItem.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteBillItem);
		//Search Bill Item Menu Button
		buttonSearchBillItem = new JButton("Search Bill Item");
		buttonSearchBillItem.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchBillItem);
		
		//Search Bill Item Section
		//Title
		labelSearchBillItem = new JLabel("Find Bill Item");
		labelSearchBillItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSearchBillItem.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelSearchBillItem);
		
		labelEnterBillItemId = new JLabel("Bill Item ID");
		labelEnterBillItemId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(labelEnterBillItemId);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(258, 43, 96, 19);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		//Search Button
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID for Search
				String id = textFieldSearch.getText().trim();
				
				//Validation
				if(id.isEmpty()) {

					JOptionPane.showMessageDialog( frame, "Please Enter Bill Item ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						BillItem billItem = billItemService.billItemGetById(id);
							if(billItem != null) {
								//Bill Item Details
								textAreaSearchResult.setText("Bill Item ID : " + billItem.getId()  +
										"\nCashier : " + billItem.getEmployee().getEmpName() +
										"\nDate : " + billItem.getDate() +
										"\nBeverage : " + billItem.getBeverage().getBeverageName() +
										"\nTotal : " + billItem.getTotal() + "\n");
							} else {
								textAreaSearchResult.setText("\n\nSorry, But Nothing Matched Your Search \nBill Item. Please Try Again With Different \nBill ID.");
								JOptionPane.showMessageDialog( frame, "Cannot Find Beverage","Error",JOptionPane.WARNING_MESSAGE);
							}
					} catch (Exception ex) {
						textAreaSearchResult.setText("Something Went Wrong");
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
			
			}
		});
		
		buttonSearch.setBounds(366, 41, 100, 21);
		frame.getContentPane().add(buttonSearch);
		
		textAreaSearchResult = new JTextArea();
		textAreaSearchResult.setBounds(186, 83, 280, 170);
		frame.getContentPane().add(textAreaSearchResult);
		
	}

}
