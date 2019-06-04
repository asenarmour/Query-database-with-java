package luv2code;
public class Employee {
	private String id;

	private String Name;

	private String phno;
public Employee(String id, String Name, String phno) {

		super();

		this.id = id;
		this.Name=Name;
		this.phno=phno;
	}


	public String getId()
	{
		return id;

	}
	public void setId(String id) {

		this.id = id;
	}
	public String getName() {

		return Name;

	}
	public void setName(String Name) {

		this.Name = Name;
	}

	public String getPhNo() {
		return phno;
	}
	public void setPhNo(String phno) {
		this.phno=phno;
	}
	@Override

	public String toString() {
return String.format("Employee [id=%s, Name=%s, phno=%s]",

id, Name,phno);

	}


	
}

