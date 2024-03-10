package cashiersubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import beveragepublisher.IBeverage;

public class BeverageUI {
	
	JButton buttonHome;
	JButton buttonAddBeverage;
	JButton buttonAllBeverages;
	JButton buttonUpdateBeverage;
	JButton buttonDeleteBeverage;
	JButton buttonSearchBeverage;
	
	private JFrame frame;

	private IBeverage beverageService;
	
	public BeverageUI(IBeverage beverageService) {
		this.beverageService = beverageService;
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
		
		buttonAddBeverage = new JButton("Add Beverage");
		buttonAddBeverage.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddBeverage);
		
		buttonAllBeverages = new JButton("Beverages List");
		buttonAllBeverages.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllBeverages);
		
		buttonUpdateBeverage = new JButton("Update Beverage");
		buttonUpdateBeverage.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateBeverage);
		
		buttonDeleteBeverage = new JButton("Delete Beverage");
		buttonDeleteBeverage.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteBeverage);
		
		buttonSearchBeverage = new JButton("Search Beverage");
		buttonSearchBeverage.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchBeverage);
	
	}

}
