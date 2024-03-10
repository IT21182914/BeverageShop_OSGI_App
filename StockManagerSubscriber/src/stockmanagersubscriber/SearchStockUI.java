package stockmanagersubscriber;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import stockpublisher.IStock;
import stockpublisher.Stock;

public class SearchStockUI {

	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddStock;
	JButton buttonAllStocks;
	JButton buttonUpdateStock;
	JButton buttonDeleteStock;
	JButton buttonSearchStock;
	
	private JFrame frame;
	private JLabel labelSearchStock;
	private JLabel labelEnterStockId;
	private JTextField textFieldSearch;
	private JButton buttonSearch;
	private JTextArea textAreaSearchResult;
	
	//Declare Stock Interface Class
	private IStock stockService;
	
	public SearchStockUI(IStock stockService) {
		
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
		
		//Search Stock Section
		//Title
		labelSearchStock = new JLabel("Find Stock");
		labelSearchStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSearchStock.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelSearchStock);
		
		labelEnterStockId = new JLabel("Stock ID");
		labelEnterStockId.setBounds(186, 46, 113, 13);
		frame.getContentPane().add(labelEnterStockId);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(258, 43, 96, 19);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		//Search Button
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID for SearchS
				String id = textFieldSearch.getText().trim();
				
				//Validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {	
						Stock stock = stockService.stockGetById(id);
							if(stock != null) {
								//Stock Details
								textAreaSearchResult.setText("Stock ID : " + stock.getId()  +
										"\nStock Name : " + stock.getStockName() +
										"\nQuantity : " + stock.getStockQty() + "\n");
							} else {
								textAreaSearchResult.setText("\n\nSorry, But Nothing Matched Your Search \nStock. Please Try Again With Different \nStock ID.");
								JOptionPane.showMessageDialog( frame, "Can not find Stock","Error",JOptionPane.WARNING_MESSAGE);
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
