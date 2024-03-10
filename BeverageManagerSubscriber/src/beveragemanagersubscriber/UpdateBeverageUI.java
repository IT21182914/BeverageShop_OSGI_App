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

public class UpdateBeverageUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBeverage;
	JButton buttonAllBeverages;
	JButton buttonUpdateBeverage;
	JButton buttonDeleteBeverage;
	JButton buttonSearchBeverage;
	
	private JFrame frame;
	private JLabel labelUpdateBeverage;
	private JLabel labelUpdateBeverageId;
	private JTextField textFieldUpdateBeverageId;
	private JLabel labelUpdateBeverageName;
	private JTextField textFieldUpdateBeverageName;
	private JLabel labeUpdatelPrice;
	private JTextField textFieldUpdatePrice;
	private JLabel labelUpdateBeverageType;
	private JTextField textFieldUpdateBeverageType;
	private JButton buttonUpdate;

	//Declare Beverage Interface Class
	private IBeverage beverageService;
	
	public UpdateBeverageUI(IBeverage beverageService) {
		
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
		
		//Update Beverage Form
		//Title
		labelUpdateBeverage = new JLabel("Update Beverage");
		labelUpdateBeverage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUpdateBeverage.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelUpdateBeverage);
		
		//Beverage ID Label
		labelUpdateBeverageId = new JLabel("Beverage ID");
		labelUpdateBeverageId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelUpdateBeverageId);
		//Beverage ID Text
		textFieldUpdateBeverageId = new JTextField();
		textFieldUpdateBeverageId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldUpdateBeverageId);
		textFieldUpdateBeverageId.setColumns(10);
		
		//Beverage Name Label
		labelUpdateBeverageName = new JLabel("Beverage Name");
		labelUpdateBeverageName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelUpdateBeverageName);
		//Beverage Name Text
		textFieldUpdateBeverageName = new JTextField();
		textFieldUpdateBeverageName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldUpdateBeverageName);
		textFieldUpdateBeverageName.setColumns(10);
		
		//Price Label
		labeUpdatelPrice = new JLabel("Price");
		labeUpdatelPrice.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labeUpdatelPrice);
		//Price Text
		textFieldUpdatePrice = new JTextField();
		textFieldUpdatePrice.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldUpdatePrice);
		textFieldUpdatePrice.setColumns(10);
		
		//Beverage Type Label
		labelUpdateBeverageType = new JLabel("Beverage Type");
		labelUpdateBeverageType.setBounds(198, 192, 81, 13);
		frame.getContentPane().add(labelUpdateBeverageType);
		//Beverage Type Text
		textFieldUpdateBeverageType = new JTextField();
		textFieldUpdateBeverageType.setBounds(304, 189, 117, 19);
		frame.getContentPane().add(textFieldUpdateBeverageType);
		textFieldUpdateBeverageType.setColumns(10);
		
		//Update Beverage Submit Button
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, beverageName, price, beverageType;
				
				//Get Values from Text Fields
				id = textFieldUpdateBeverageId.getText().trim();
				beverageName = textFieldUpdateBeverageName.getText().trim();
				price = textFieldUpdatePrice.getText().trim();
				beverageType = textFieldUpdateBeverageType.getText().trim();
				
				//Validations
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage ID","Error",JOptionPane.WARNING_MESSAGE);
				} else if(beverageName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage Name","Error",JOptionPane.WARNING_MESSAGE);
				} else if(price.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Price","Error",JOptionPane.WARNING_MESSAGE);
				} else if(beverageType.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage Type","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Beverage beverage = new Beverage(id, beverageName, price, beverageType);
						boolean isBeverage = beverageService.updateBeverage(id, beverage);
						if(isBeverage) {
							//Set Text Fields to Null for Next Addition
							textFieldUpdateBeverageId.setText("");
							textFieldUpdateBeverageName.setText("");
							textFieldUpdatePrice.setText("");
							textFieldUpdateBeverageType.setText("");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Bverage Update Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog( frame, "Cannot Update Beverage","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}	
		});
		
		buttonUpdate.setBounds(266, 232, 85, 21);
		frame.getContentPane().add(buttonUpdate);
		
		//Find Button
		JButton buttonUpdateFind = new JButton("Find");
		buttonUpdateFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID from Search Bar
				String id = textFieldUpdateBeverageId.getText().trim();
				
				//Validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Beverage ID Number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Beverage beverage = beverageService.beverageGetById(id);
						if(beverage != null) {
							//Set Values
							textFieldUpdateBeverageName.setText(beverage.getBeverageName());
							textFieldUpdatePrice.setText(beverage.getPrice());
							textFieldUpdateBeverageType.setText(beverage.getBeverageType());	
						}else {
							JOptionPane.showMessageDialog( frame, "Cannot Find Beverage","Error",JOptionPane.WARNING_MESSAGE);
						}
					} 
					catch(Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		buttonUpdateFind.setBounds(430, 55, 64, 21);
		frame.getContentPane().add(buttonUpdateFind);
		
	}

}
