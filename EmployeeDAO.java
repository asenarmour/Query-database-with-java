package luv2code;
import java.util.*;

import javax.swing.JFrame;

import java.sql.*;
import java.io.*;
import luv2code.Employee;

public class EmployeeDAO {
	private Connection myConn;
	public EmployeeDAO() throws Exception {
		 myConn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false", "root", "password");
			
		}
		catch(ClassNotFoundException e) {}
		catch(SQLException e) {}


	}
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from details");
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Employee> searchEmployees(String id) throws Exception {
		List<Employee> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
//			id = "%";
			myStmt = myConn.prepareStatement("select * from details where id like ?");
			
			myStmt.setString(1, id);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		
		String id = myRs.getString("id");
		String Name = myRs.getString("name");
		String phno= myRs.getString("phno");
		
		Employee tempEmployee = new Employee(id, Name, phno);
		
		return tempEmployee;
	}

	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	public static void main(String[] args) throws Exception {
		
		EmployeeDAO dao = new EmployeeDAO();
//		System.out.println(dao.searchEmployees("1"));

//		System.out.println(dao.getAllEmployees());
	}
}

