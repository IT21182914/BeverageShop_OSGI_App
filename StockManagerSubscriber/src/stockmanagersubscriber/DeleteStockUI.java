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

public class DeleteStockUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddStock;
	JButton buttonAllStocks;
	JButton buttonUpdateStock;
	JButton buttonDeleteStock;
	JButton buttonSearchStock;
	
	private JFrame frame;
	private JLabel labelDeleteStock;
	private JLabel labelDelete;
	private JTextField textFieldDelete;
	private JButton buttonSearch;
	private JTextArea textAreaDelete;
	private JButton buttonDelete;
	
	//Declare Stock Interface Class
	private IStock stockService;
	
	public DeleteStockUI(IStock stockService) {
		
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
		
		//Delete Section
		//Title
		labelDeleteStock = new JLabel("Delete Stock");
		labelDeleteStock.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDeleteStock.setBounds(248, 16, 124, 17);
		frame.getContentPane().add(labelDeleteStock);
		
		buttonDelete = new JButton("Delete");
		frame.getContentPane().add(buttonDelete);
		
		labelDelete = new JLabel("Stock ID");
		labelDelete.setBounds(180, 45, 100, 13);
		frame.getContentPane().add(labelDelete);
		
		textFieldDelete = new JTextField();
		textFieldDelete.setBounds(278, 43, 96, 19);
		frame.getContentPane().add(textFieldDelete);
		textFieldDelete.setColumns(10);
		
		//Search Stock Button
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID Value
				String id = textFieldDelete.getText().trim();
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {	
						Stock stock = stockService.stockGetById(id);
						if(stock != null) {
							//Stock Details
							textAreaDelete.setText("Stock ID : " + stock.getId()  +
									"\nStock Name : " + stock.getStockName() +
									"\nQuantity : " + stock.getStockQty() + "\n");
						} else {
							textAreaDelete.setText("\n\nSorry, But Nothing Matched Your Search \nStock. Please Try Again With Different \nStock ID.");
							JOptionPane.showMessageDialog( frame, "Cannot Find Stock","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						textAreaDelete.setText("Something Went Wrong");
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}
			
			}
		});
		
		buttonSearch.setBounds(384, 43, 75, 21);
		frame.getContentPane().add(buttonSearch);
		
		textAreaDelete = new JTextArea();
		textAreaDelete.setBounds(180, 70, 279, 126);
		frame.getContentPane().add(textAreaDelete);
		
		//Search Stock Button
		buttonDelete = new JButton("Delete Stock");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get ID Value
				String id = textFieldDelete.getText().trim();
				
				//Validation
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog( frame, "Please Enter Stock ID Number","Error",JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						boolean isStock = stockService.deleteStock(id);
						if(isStock) {
							textFieldDelete.setText("");
							//Success Message
							textAreaDelete.setText("\n\nStock Deleted Sucessfully");
							
							//Success Message
							JOptionPane.showMessageDialog( frame, "Stock Deleted Sucessfully","Success",JOptionPane.PLAIN_MESSAGE);
						} else {
							textAreaDelete.setText("\n\nCannot Delete Stock");
							JOptionPane.showMessageDialog( frame, "Can not delete Stock","Error",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception ex) {
						textAreaDelete.setText("\n\nSomething Went Wrong..!");
						JOptionPane.showMessageDialog( frame, "Something Went Wrong","Error",JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});
		
		buttonDelete.setBounds(274, 219, 152, 21);
		frame.getContentPane().add(buttonDelete);
	}

}
