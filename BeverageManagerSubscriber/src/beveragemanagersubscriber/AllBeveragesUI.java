package beveragemanagersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import beveragepublisher.Beverage;
import beveragepublisher.IBeverage;

public class AllBeveragesUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddBeverage;
	JButton buttonAllBeverages;
	JButton buttonUpdateBeverage;
	JButton buttonDeleteBeverage;
	JButton buttonSearchBeverage;
	JScrollPane scrollPane;
	
	private JFrame frame;
	private JLabel lableAllBeverages;
	private JTable table;
	
	//Declare Beverage Interface Class
	private IBeverage beverageService;
	
	public AllBeveragesUI(IBeverage beverageService) {
		
		this.beverageService = beverageService;
		//Called Initialize Method
		initialize();
		
		//Create Beverages ArrayList
		ArrayList<Beverage> beverages = beverageService.getBeverageList();
		
		if (!beverages.isEmpty()) {
		    List<Object[]> list = new ArrayList<Object[]>();
		    for (int i = 0; i < beverages.size(); i++) {
		        list.add(new Object[] { beverages.get(i).getId(), beverages.get(i).getBeverageName(), beverages.get(i).getPrice(), beverages.get(i).getBeverageType()});
		    }
		    table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), new String[] {"ID","Name", "Price", "Type"}));
		}
	
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
		frame.setBounds(100, 100, 750, 300);
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
		
		//Title
		lableAllBeverages = new JLabel("All Beverages");
		lableAllBeverages.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableAllBeverages.setBounds(375, 16, 124, 17);
		frame.getContentPane().add(lableAllBeverages);
		
		//Beverage List Table
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 500, 184);
		frame.getContentPane().add(scrollPane);

	}

}
