package cashiersubscriber;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beverageemployeepublisher.IEmployee;
import beveragepublisher.IBeverage;
import billitempublisher.IBillItem;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierMainUI extends JFrame {

	private JPanel contentPane;
	private JButton buttonEmployee;
	private JButton buttonBeverage;
	private JButton buttonBillItem;

	private IEmployee employeeService;
	private IBeverage beverageService;
	private IBillItem billItemService;
	
	public CashierMainUI(IEmployee employeeService) {
		this.employeeService = employeeService;
		Initial();
	}
	
	public CashierMainUI(IBeverage beverageService) {
		this.beverageService = beverageService;
		Initial();
	}
	
	public CashierMainUI(IBillItem billItemService) {
		this.billItemService = billItemService;
		Initial();
	}
	
	public CashierMainUI(IEmployee employeeService, IBeverage beverageService, IBillItem billItemService) {
		this.employeeService = employeeService;
		this.beverageService = beverageService;
		this.billItemService = billItemService;
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
		
		buttonEmployee = new JButton("Employee");
		buttonEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EmployeeUI(employeeService);
			}
		});
		buttonEmployee.setBounds(221, 53, 89, 23);
		menuPanel.add(buttonEmployee);
		
		buttonBeverage = new JButton("Beverage");
		buttonBeverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BeverageUI(beverageService);
			}
		});
		buttonBeverage.setBounds(221, 125, 89, 23);
		menuPanel.add(buttonBeverage);
		
		buttonBillItem = new JButton("Bill Item");
		buttonBillItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillItemUI(employeeService, beverageService, billItemService);
			}
		});
		buttonBillItem.setBounds(221, 197, 89, 23);
		menuPanel.add(buttonBillItem);
	}

}

