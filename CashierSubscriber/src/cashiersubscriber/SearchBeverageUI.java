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

import beveragepublisher.Beverage;
import beveragepublisher.IBeverage;

public class SearchBeverageUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBeverage;
	JButton buttonAllBeverages;
	JButton buttonUpdateBeverage;
	JButton buttonDeleteBeverage;
	JButton buttonSearchBeverage;
	
	private JFrame frame;
	private JLabel labelSearchBeverage;
	private JLabel labelEnterBeverageId;
	private JTextField textFieldSearch;
	private JButton buttonSearch;
	private JTextArea textAreaSearchResult;
	
	//Declare Beverage Interface Class
	private IBeverage beverageService;
	
	public SearchBeverageUI(IBeverage beverageService) {
		
		this.beverageService = beverageService;
		//Called Initialize Method
		initialize();
	
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CashierMainUI(beverageService);
				frame.setVisible(false);
			}
		});
		
		buttonAddBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddBeverageIUI(beverageService);
				frame.setVisible(false);
			}
		});
		
		buttonAllBeverages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllBeveragesUI(beverageService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateBeverageUI(beverageService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteBeverageUI(beverageService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchBeverageUI(beverageService);
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
		//Add Beverage Menu Button
		buttonAddBeverage = new JButton("Add Beverage");
		buttonAddBeverage.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddBeverage);
		//Beverages List Menu Button
		buttonAllBeverages = new JButton("Beverages List");
		buttonAllBeverages.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllBeverages);
		//Update Beverage Menu Button
		buttonUpdateBeverage = new JButton("Update Beverage");
		buttonUpdateBeverage.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateBeverage);
		//Delete Beverage Menu Button
		buttonDeleteBeverage = new JButton("Delete Beverage");
		buttonDeleteBeverage.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteBeverage);
		//Search Beverage Menu Button
		buttonSearchBeverage = new JButton("Search Beverage");
		buttonSearchBeverage.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchBeverage);
		
		//Search Beverage Section
		//Title
		labelSearchBeverage = new JLabel("Find Beverage");
		labelSearchBeverage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSearchBeverage.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelSearchBeverage);
		
		labelEnterBeverageId = new JLabel("Beverage ID");
		labelEnterBeverageId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(labelEnterBeverageId);
		
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
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Beverage beverage = beverageService.beverageGetById(id);
						if(beverage != null) {
							//Beverage Details
							textAreaSearchResult.setText("Beverage ID : " + beverage.getId()  +
									"\nBeverage Name : " + beverage.getBeverageName() +
									"\nPrice : " + beverage.getPrice() +
									"\nBeverage Type : " + beverage.getBeverageType() + "\n");
						} else {
							textAreaSearchResult.setText("\n\nSorry, But Nothing Matched Your Search \nBeverage. Please Try Again With Different \nBeverage ID");
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
