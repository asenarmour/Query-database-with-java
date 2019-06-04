package college_project.frame1;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Frame3 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel l1,l2;
	JTextField t1;
	JButton b;
	
	String id,name,phno;
	
	public Frame3() throws SQLException {
		main(null);
	}
	public Frame3(String str) {
		super(str);
		l1=new JLabel("ENTER ID FOR QUERY");
		l1.setBounds(100,30,200,50);
		l2=new JLabel("ID");
		l2.setBounds(50,100,100,30);
		t1=new JTextField("");
		t1.setBounds(100,100,100,30);
		b=new JButton("EXECUTE");
		b.setBounds(100,150,100,30);
		add(l1);
		add(l2);
		add(t1);
		add(b);
		
		b.addActionListener(this);
	}
	
	public static void main(String [] args) throws SQLException{
		Connection con=null;
		Frame3 j=new Frame3("College project");
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
	
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false", "root", "password");
			
		}
		catch(ClassNotFoundException p) {}
		catch(SQLException p) {}
		try {
			Statement stmt1=con.createStatement();
			int i=Integer.parseInt(t1.getText());
			PreparedStatement stmt=con.prepareStatement("select * from details where id=?");
			stmt.setInt(1,i);
			try {
			ResultSet rs=stmt.executeQuery();
			rs.absolute(1);
			id=rs.getString(1);
			name=rs.getString(2);
			phno=rs.getString(3);
			repaint();
			JOptionPane.showMessageDialog(null,"id="+rs.getString(1)+"\nname="+rs.getString(2)+"\nphno="+rs.getString(3));
			}
			catch(Exception l) {
				JOptionPane.showMessageDialog(null,"ENTER VALID ID");
			}
			
			
			
			
		} catch (SQLException p) {
			p.printStackTrace();
		}
		
	}
	

}