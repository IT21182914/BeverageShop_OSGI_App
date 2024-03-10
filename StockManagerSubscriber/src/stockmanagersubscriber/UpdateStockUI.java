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

public class UpdateStockUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddStock;
	JButton buttonAllStocks;
	JButton buttonUpdateStock;
	JButton buttonDeleteStock;
	JButton buttonSearchStock;
	
	private JFrame frame;
	private JLabel labelUpdateStock;
	private JLabel labelUpdateStockId;
	private JTextField textFieldUpdateStockId;
	private JLabel labelUpdateStockName;
	private JTextField textFieldUpdateStockName;
	private JLabel labeUpdateQuantity;
	private JTextField textFieldUpdateQuantity;
	private JButton buttonUpdate;

	//Declare Stock Interface Class
	private IStock stockService;
	
	public UpdateStockUI(IStock stockService) {
		
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
		
		//Update Stock Form
		//Title
		labelUpdateStock = new JLabel("Update Stock");
		labelUpdateStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelUpdateStock.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelUpdateStock);
		
		//Stock ID Label
		labelUpdateStockId = new JLabel("Stock ID");
		labelUpdateStockId.setBounds(198, 59, 96, 13);
		frame.getContentPane().add(labelUpdateStockId);
		//Stock ID Text
		textFieldUpdateStockId = new JTextField();
		textFieldUpdateStockId.setBounds(304, 56, 122, 19);
		frame.getContentPane().add(textFieldUpdateStockId);
		textFieldUpdateStockId.setColumns(10);
		
		//Stock Name Label
		labelUpdateStockName = new JLabel("Stock Name");
		labelUpdateStockName.setBounds(198, 102, 96, 13);
		frame.getContentPane().add(labelUpdateStockName);
		//Stock Name Text
		textFieldUpdateStockName = new JTextField();
		textFieldUpdateStockName.setBounds(304, 99, 122, 19);
		frame.getContentPane().add(textFieldUpdateStockName);
		textFieldUpdateStockName.setColumns(10);
		
		//Quantity Label
		labeUpdateQuantity = new JLabel("Quantity");
		labeUpdateQuantity.setBounds(198, 148, 81, 13);
		frame.getContentPane().add(labeUpdateQuantity);
		//Quantity Text
		textFieldUpdateQuantity = new JTextField();
		textFieldUpdateQuantity.setBounds(304, 145, 122, 19);
		frame.getContentPane().add(textFieldUpdateQuantity);
		textFieldUpdateQuantity.setColumns(10);
		
		//Update Stock Button
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Declare Variables
				String id, stockName, quantity;
				
				//Get Values from Text Fields
				id = textFieldUpdateStockId.getText().trim();
				stockName = textFieldUpdateStockName.getText().trim();
				quantity = textFieldUpdateQuantity.getText().trim();
				
				//Validations
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock ID","Error",JOptionPane.WARNING_MESSAGE);
				} else if(stockName.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock Name","Error",JOptionPane.WARNING_MESSAGE);
				} else if(quantity.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Quantity","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Stock stock = new Stock(id, stockName, quantity);
						boolean isStock = stockService.updateStock(id, stock);
						if(isStock) {
							//Set Text Fields to Null for Next Addition
							textFieldUpdateStockId.setText("");
							textFieldUpdateStockName.setText("");
							textFieldUpdateQuantity.setText("");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Stock Update Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog( frame, "Cannot Update Stock","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
				
			}
		});
		
		buttonUpdate.setBounds(266, 175, 85, 21);
		frame.getContentPane().add(buttonUpdate);
		
		//Find Button
		JButton buttonUpdateFind = new JButton("Find");
		buttonUpdateFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID from Search Bar
				String id = textFieldUpdateStockId.getText().trim();
				
				//Validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock ID Number","Error",JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Stock stock = stockService.stockGetById(id);
						if(stock != null) {
							//Set Values
							textFieldUpdateStockName.setText(stock.getStockName());
							textFieldUpdateQuantity.setText(stock.getStockQty());
						}else {
							JOptionPane.showMessageDialog( frame, "Cannot Find Stock","Error",JOptionPane.WARNING_MESSAGE);
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
			
			}
		});
		
		buttonUpdateFind.setBounds(430, 55, 64, 21);
		frame.getContentPane().add(buttonUpdateFind);
		
	}

}
