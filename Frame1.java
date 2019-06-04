package college_project.frame1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

import luv2code.EmployeeSearchApp;
public class Frame1 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel l1;
	JRadioButton rb1,rb2;
	JButton b1;
	
	public Frame1() {
		try {
			main(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Frame1(String str) {
		super(str);
		b1=new JButton("Submit");
		rb1=new JRadioButton("Insertion");
		rb2=new JRadioButton("Query");
		rb1.setBounds(50,150,150,30);
		l1=new JLabel("Select Your Choice");
		l1.setBounds(50,50,250,50);
		rb2.setBounds(50,200,150,30);
		b1.setBounds(50,250,100,30);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		add(b1);
		add(l1);
		add(rb1);
		add(rb2);
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(rb1.isSelected()) {
					try {
						new Frame2();
						dispose();
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
				}
				
				if(rb2.isSelected()) {
					new EmployeeSearchApp("hi");
					dispose();
				}	
				
			}
		});
		
	}
	
	public static void main(String [] args) throws SQLException{
		Connection con=null;
		Frame1 j=new Frame1("College project");
		j.setSize(500,500);
		j.setLayout(null);
		j.setVisible(true);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false", "root", "password");
			
		}
		catch(ClassNotFoundException e) {}
		catch(SQLException e) {}
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		con.close();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
