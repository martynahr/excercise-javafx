package app.model;

public class TableModel {
	private int id;
	private String firstName;
	private String lastName;
	private String salary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public TableModel(){}
	public TableModel(int id, String firstName, String lastName, String salary){
		this.id=id;
		this.firstName= firstName;
		this.lastName=lastName;
		this.salary=salary;
	}

}
