package beverageshopadminsubscriber;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beverageemployeepublisher.IEmployee;

public class AdminMainUI extends JFrame {
	
	private JPanel contentPane;
	private JButton buttonEmployee;
	
	private IEmployee employeeService;
	
	public AdminMainUI(IEmployee employeeService) {
		this.employeeService = employeeService;
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
	}

}
