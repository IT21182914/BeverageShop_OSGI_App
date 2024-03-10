package stockmanagersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import stockpublisher.IStock;
import stockpublisher.Stock;

public class AddStockUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddStock;
	JButton buttonAllStocks;
	JButton buttonUpdateStock;
	JButton buttonDeleteStock;
	JButton buttonSearchStock;
	
	private JFrame frame;
	private JLabel labelAddStock;
	private JLabel labelStockId;
	private JTextField textFieldStockId;
	private JLabel labelStockName;
	private JTextField textFieldStockName;
	private JLabel labelQuantity;
	private JTextField textFieldQuantity;
	private JButton buttonAdd;

	//Declare Stock Interface Class
	private IStock stockService;
	
	public AddStockUI(IStock stockService) {
		
		this.stockService = stockService;
		//Called Initialize Method
		initialize();
	
		buttonHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockManagerMainUI(stockService);
				frame.setVisible(false);
			}
		});
		
		buttonAddStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStockUI(stockService);
				frame.setVisible(false);
			}
		});
		
		buttonAllStocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllStocksUI(stockService);
				frame.setVisible(false);
			}
		});
		
		buttonUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateStockUI(stockService);
				frame.setVisible(false);
			}
		});
		
		buttonDeleteStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteStockUI(stockService);
				frame.setVisible(false);
			}
		});
		
		buttonSearchStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchStockUI(stockService);
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
		//Add Stock Menu Button
		buttonAddStock = new JButton("Add Stock");
		buttonAddStock.setBounds(10, 55, 140, 21);
		frame.getContentPane().add(buttonAddStock);
		//Stock List Menu Button
		buttonAllStocks = new JButton("Stock List");
		buttonAllStocks.setBounds(10, 98, 140, 21);
		frame.getContentPane().add(buttonAllStocks);
		//Update Stock Menu Button
		buttonUpdateStock = new JButton("Update Stock");
		buttonUpdateStock.setBounds(10, 144, 140, 21);
		frame.getContentPane().add(buttonUpdateStock);
		//Delete Stock Menu Button
		buttonDeleteStock = new JButton("Delete Stock");
		buttonDeleteStock.setBounds(10, 188, 140, 21);
		frame.getContentPane().add(buttonDeleteStock);
		//Search Stock Menu Button
		buttonSearchStock = new JButton("Search Stock");
		buttonSearchStock.setBounds(10, 232, 140, 21);
		frame.getContentPane().add(buttonSearchStock);
		
		//Add Stock Form
		//Title
		labelAddStock = new JLabel("Add Stock");
		labelAddStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelAddStock.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelAddStock);
		
		//Stock ID Label
		labelStockId = new JLabel("Stock ID");
		labelStockId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelStockId);
		//Stock ID Text
		textFieldStockId = new JTextField();
		textFieldStockId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldStockId);
		textFieldStockId.setColumns(10);
		
		//Stock Name Label
		labelStockName = new JLabel("Stock Name");
		labelStockName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelStockName);
		//Stock Name Text
		textFieldStockName = new JTextField();
		textFieldStockName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldStockName);
		textFieldStockName.setColumns(10);
		
		//Quantity Label
		labelQuantity = new JLabel("Quantity");
		labelQuantity.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labelQuantity);
		//Quantity Text
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldQuantity);
		textFieldQuantity.setColumns(10);
		
		//Add Stock Submit Button
		buttonAdd = new JButton("Add Stock");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, stockName, quantity;
				
				//Get Values from Text Fields
				id = textFieldStockId.getText().trim();
				stockName = textFieldStockName.getText().trim();
				quantity = textFieldQuantity.getText().trim();
				
				//Validations
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock ID","Error",JOptionPane.WARNING_MESSAGE);
				} else if(stockName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock Name","Error",JOptionPane.WARNING_MESSAGE);
				} else if(quantity.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Quantity","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						Stock stock = new Stock(id, stockName, quantity);
						boolean isStock = stockService.addStock(stock);
						if(isStock) {
							//Set Text Fields to Null for Next Addition
							textFieldStockId.setText("");
							textFieldStockName.setText("");
							textFieldQuantity.setText("");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Stock Add Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
							} else {
								JOptionPane.showMessageDialog( frame, "Cannot Add Stock","Error",JOptionPane.WARNING_MESSAGE);
								}
						} catch (Exception ex) {
							JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
						}	
				}
				
			}	
		});
		
		buttonAdd.setBounds(266, 175, 150, 21);
		frame.getContentPane().add(buttonAdd);
		
	}

}
