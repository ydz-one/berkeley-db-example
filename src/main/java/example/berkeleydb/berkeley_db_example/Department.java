package example.berkeleydb.berkeley_db_example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {
	private int id;
	private String name;
	private List<Integer> employees;
	
	public Department(int id, String name) {
		this.id = id;
		this.name = name;
		employees = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void addEmployee(int empId) {
		employees.add(empId);
	}
	
	public List<Integer> getEmployees() {
		return employees;
	}
}
