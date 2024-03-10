package stockmanagersubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stockpublisher.IStock;

public class StockManagerMainUI extends JFrame {
	
	private JPanel contentPane;
	private JButton buttonStock;
	
	private IStock stockService;
	
	public StockManagerMainUI(IStock stockService) {
		this.stockService = stockService;
		Initial();
	}
	
	public void Initial() {
		setTitle("Beverage Cafe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 524, 340);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);
		
		buttonStock = new JButton("Stock");
		buttonStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StockUI(stockService);
			}
		});
		
		buttonStock.setBounds(221, 53, 89, 23);
		menuPanel.add(buttonStock);
	}
	
}
