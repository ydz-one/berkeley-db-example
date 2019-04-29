package example.berkeleydb.berkeley_db_example;

import java.io.Serializable;

public class Employee implements Serializable {
	private int id;
	private String name;
	private String title;
	
	public Employee(int id, String name, String title) {
		this.id = id;
		this.name = name;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTitle() {
		return title;
	}
}
