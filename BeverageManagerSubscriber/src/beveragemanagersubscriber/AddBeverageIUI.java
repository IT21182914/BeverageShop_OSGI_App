package beveragemanagersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import beveragepublisher.Beverage;
import beveragepublisher.IBeverage;

public class AddBeverageIUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBeverage;
	JButton buttonAllBeverages;
	JButton buttonUpdateBeverage;
	JButton buttonDeleteBeverage;
	JButton buttonSearchBeverage;
	
	private JFrame frame;
	private JLabel labelAddBeverage;
	private JLabel labelBeverageId;
	private JTextField textFieldBeverageId;
	private JLabel labelBeverageName;
	private JTextField textFieldBeverageName;
	private JLabel labelPrice;
	private JTextField textFieldPrice;
	private JLabel labelBeverageType;
	private JTextField textFieldBeverageType;
	private JButton buttonAdd;

	//Declare Beverage Interface Class
	private IBeverage beverageService;
	
	public AddBeverageIUI(IBeverage beverageService) {
		
		this.beverageService = beverageService;
		//Called Initialize Method
		initialize();
	
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BeverageManagerMainUI(beverageService);
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
		
		//Add Beverage Form
		//Title
		labelAddBeverage = new JLabel("Add Beverage");
		labelAddBeverage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAddBeverage.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelAddBeverage);
		
		//Beverage ID Label
		labelBeverageId = new JLabel("Beverage ID");
		labelBeverageId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelBeverageId);
		//Beverage ID Text
		textFieldBeverageId = new JTextField();
		textFieldBeverageId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldBeverageId);
		textFieldBeverageId.setColumns(10);
		
		//Beverage Name Label
		labelBeverageName = new JLabel("Beverage Name");
		labelBeverageName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelBeverageName);
		//Beverage Name Text
		textFieldBeverageName = new JTextField();
		textFieldBeverageName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldBeverageName);
		textFieldBeverageName.setColumns(10);
		
		//Price Label
		labelPrice = new JLabel("Price");
		labelPrice.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labelPrice);
		//Price Text
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldPrice);
		textFieldPrice.setColumns(10);
				
		//Beverage Type Label
		labelBeverageType = new JLabel("Beverage Type");
		labelBeverageType.setBounds(198, 192, 96, 13);
		frame.getContentPane().add(labelBeverageType);
		//Beverage Type Text
		textFieldBeverageType = new JTextField();
		textFieldBeverageType.setBounds(304, 189, 122, 19);
		frame.getContentPane().add(textFieldBeverageType);
		textFieldBeverageType.setColumns(10);
		
		//Add Beverage Submit Button
		buttonAdd = new JButton("Add Beverage");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, beverageName, price, beverageType;
				
				//Get Values from Text Fields
				id = textFieldBeverageId.getText().trim();
				beverageName = textFieldBeverageName.getText().trim();
				price = textFieldPrice.getText().trim();
				beverageType = textFieldBeverageType.getText().trim();
				
				//Validations
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage ID","Error",JOptionPane.WARNING_MESSAGE);
				} else if(beverageName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage Name","Error",JOptionPane.WARNING_MESSAGE);
				} else if(price.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Price","Error",JOptionPane.WARNING_MESSAGE);
				} else if(beverageType.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage Type","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Beverage beverage = new Beverage(id, beverageName, price, beverageType);
						boolean isBeverage = beverageService.addBeverage(beverage);
						if(isBeverage) {
							//Set Text Fields to Null for Next Addition
							textFieldBeverageId.setText("");
							textFieldBeverageName.setText("");
							textFieldPrice.setText("");
							textFieldBeverageType.setText("");
								
							//Success Message
							JOptionPane.showMessageDialog( frame, "Bverage Add Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
								JOptionPane.showMessageDialog( frame, "Cannot Add Beverage","Error",JOptionPane.WARNING_MESSAGE);
								}
					} catch (Exception ex) {
							JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);		
					}
				}	
			}
			
		});
		
		buttonAdd.setBounds(266, 232, 150, 21);
		frame.getContentPane().add(buttonAdd);
		
	}
	
}
