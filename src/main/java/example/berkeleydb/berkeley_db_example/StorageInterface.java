package example.berkeleydb.berkeley_db_example;

import java.util.List;
import java.util.Map.Entry;

public interface StorageInterface extends AutoCloseable {

	/**
	 * Shuts down / flushes / closes the storage system
	 */
	public void close();

	void addEmployee(int id, String name, String title);

	Employee getEmployee(int id);

	void addDept(int id, String name);

	Department getDept(int id);

	void assignEmployeeToDept(int empId, int deptId);
}
