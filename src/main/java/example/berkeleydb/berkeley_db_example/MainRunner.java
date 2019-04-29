package example.berkeleydb.berkeley_db_example;

import java.io.FileNotFoundException;

import com.sleepycat.je.DatabaseException;

/**
 * Hello world!
 *
 */
public class MainRunner {
	public static void main(String[] args) {
		try {
			StorageInterface database = StorageFactory.getDatabaseInstance("./store");
			database.addDept(1, "Finance");
			database.addDept(2, "Human Resources");
			
			database.addEmployee(1, "Ben", "Janitor");
			database.addEmployee(2, "Jane", "Janitor");
			
			database.assignEmployeeToDept(1, 1);
			database.assignEmployeeToDept(2, 1);
			
			Department dept1 = database.getDept(1);
			
			System.out.println(dept1.getName()); // prints out "Finance"
			System.out.println(dept1.getEmployees()); // prints out "[1, 2]"
			
			database.close();
		} catch (DatabaseException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
