package stockmanagersubscriber;

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

import stockpublisher.IStock;
import stockpublisher.Stock;

public class AllStocksUI {
	
	//Declare Objects / Elements
	JButton buttonHome;
	JButton buttonAddStock;
	JButton buttonAllStocks;
	JButton buttonUpdateStock;
	JButton buttonDeleteStock;
	JButton buttonSearchStock;
	JScrollPane scrollPane;
	
	private JFrame frame;
	private JLabel lableAllStocks;
	private JTable table;
	
	//Declare Stock Interface Class
	private IStock stockService;
	
	public AllStocksUI(IStock stockService) {
		
		this.stockService = stockService;
		//Called Initialize Method
		initialize();
		
		//Create Stocks ArrayList
		ArrayList<Stock> stocks = stockService.getStockList();
		
		if (!stocks.isEmpty()) {
		    List<Object[]> list = new ArrayList<Object[]>();
		    for (int i = 0; i < stocks.size(); i++) {
		        list.add(new Object[] { stocks.get(i).getId(), stocks.get(i).getStockName(), stocks.get(i).getStockQty() });
		    }
		    table.setModel(new DefaultTableModel(list.toArray(new Object[][] {}), new String[] {"ID","Name", "Quantity"}));
		}
	
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
		
		//Title
		lableAllStocks = new JLabel("Stock List");
		lableAllStocks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lableAllStocks.setBounds(375, 16, 124, 17);
		frame.getContentPane().add(lableAllStocks);
		
		//Stock List Table
		table = new JTable();
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(172, 58, 500, 184);
		frame.getContentPane().add(scrollPane);

	}

}
