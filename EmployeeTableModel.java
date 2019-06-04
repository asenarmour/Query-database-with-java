package luv2code;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import luv2code.Employee;

class EmployeeTableModel extends AbstractTableModel {

	private static final int LAST_NAME_COL = 0;
	private static final int FIRST_NAME_COL = 1;
	private static final int EMAIL_COL = 2;

	private String[] columnNames = { "id", "Name", "phno"};
	private List<Employee> employees;

	public EmployeeTableModel(List<Employee> theEmployees) {
		employees = theEmployees;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		Employee tempEmployee = employees.get(row);

		switch (col) {
		case LAST_NAME_COL:
			return tempEmployee.getId();
		case FIRST_NAME_COL:
			return tempEmployee.getName();
		case EMAIL_COL:
			return tempEmployee.getPhNo();
		default:
			return tempEmployee.getName();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
