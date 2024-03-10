package beveragemanagersubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beveragepublisher.IBeverage;

public class BeverageManagerMainUI extends JFrame {
	
	//Declare Objects / Elements
	private JPanel contentPane;
	private JButton buttonEmployee;
	
	//Declare Beverage Interface Class
	private IBeverage beverageService;
	
	public BeverageManagerMainUI(IBeverage beverageService) {
		this.beverageService = beverageService;
		//Called Initialize Method
		Initial();
	}
	
	//Initialize Method
	public void Initial() {
		
		//Create Frame
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
		
		//Beverage Button
		buttonEmployee = new JButton("Beverage");
		buttonEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BeverageUI(beverageService);
			}
		});
		
		buttonEmployee.setBounds(221, 53, 89, 23);
		menuPanel.add(buttonEmployee);
		
	}
	
}
