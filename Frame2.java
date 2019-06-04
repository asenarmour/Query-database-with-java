package college_project.frame1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class Frame2 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3;
	JButton b1,b2;
	int id;
	String name;
	String phno;
	public Frame2() throws SQLException {
		main(null);
	}
	public Frame2(String str) {
		super(str);
		l1=new JLabel("ENTER VALUES");
		l1.setBounds(100,20,200,30);
		l2=new JLabel("ID");
		l2.setBounds(50,50,50,50);
		l3=new JLabel("NAME");
		l3.setBounds(50,100,50,50);
		l4=new JLabel("PH_NO.");
		l4.setBounds(50,150,50,50);
		t1=new JTextField("");
		t2=new JTextField("");
		t3=new JTextField("");
		t1.setBounds(100,60,200,30);
		t2.setBounds(100,110,200,30);
		t3.setBounds(100,160,200,30);
		b1=new JButton("Execute");
		b1.setBounds(100,230,100,30);
		b2=new JButton("Back");
		b2.setBounds(250,230,70,30);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(t1);
		add(t2);
		add(t3);
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Frame1();
				dispose();
			}
		});
	}
	public static void main(String [] args) throws SQLException{
		Connection con=null;
		Frame2 j=new Frame2("College project");
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
	public void actionPerformed(ActionEvent e) {
	
		id=Integer.parseInt(t1.getText());
		name=t2.getText();
		phno=t3.getText();
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false", "root", "password");
			
		}
		catch(ClassNotFoundException p) {}
		catch(SQLException p) {}
		try {
			PreparedStatement stmt=con.prepareStatement("insert into details values(?,?,?)");
			
			stmt.setInt(1, id);
			stmt.setString(2, t2.getText());
			stmt.setString(3, t3.getText());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(this,"INFORMATION UPDATED SUCCESSFULLY");
		}
		catch(Exception l) {
			JOptionPane.showMessageDialog(this,"ID ALREADY EXITS");
		}
		
	}

}
