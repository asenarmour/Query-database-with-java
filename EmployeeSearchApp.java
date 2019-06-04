package luv2code;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import college_project.frame1.Frame1;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;

import luv2code.Employee;
import luv2code.EmployeeDAO;
public class EmployeeSearchApp extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JButton btnSearch,btnBack;
	private JScrollPane scrollPane;
	private JTable table;

	private EmployeeDAO employeeDAO;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeSearchApp frame = new EmployeeSearchApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public EmployeeSearchApp(String s) { // this constructer is used by the frame1
		main(null);
	}

	/**
	 * Create the frame.
	 */
	public EmployeeSearchApp() {
		
		try {
			employeeDAO = new EmployeeDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		
		setTitle("Student Search App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterLastName = new JLabel("Enter id");
		panel.add(lblEnterLastName);
		
		idField = new JTextField();
		panel.add(idField);
		idField.setColumns(10);
		
		
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Get last name from the text field

				// Call DAO and get employees for the last name

				// If last name is empty, then get all employees

				// Print out employees				
				
				try {
					String id = idField.getText();

					List<Employee> employees = null;

					if (id != null && id.trim().length() > 0) {
						employees = employeeDAO.searchEmployees(id);
					} else {
						employees = employeeDAO.getAllEmployees();
					}
					
					// create the model and update the "table"
					EmployeeTableModel model = new EmployeeTableModel(employees);
					
					table.setModel(model);
					
					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(EmployeeSearchApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
				}
				
			}
		});
		panel.add(btnSearch);
		
		btnBack=new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
			
				new Frame1();
				dispose();
			}
		});
		panel.add(btnBack);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
