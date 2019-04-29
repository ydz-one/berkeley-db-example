package example.berkeleydb.berkeley_db_example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;

import com.sleepycat.collections.StoredEntrySet;
import com.sleepycat.je.DatabaseException;

public class DatabaseManager implements StorageInterface {
	private static DatabaseManager instance;
	private AppDatabase adb;
	private AppViews views;
	private ConcurrentMap employeeMap;
	private ConcurrentMap deptMap;

	private DatabaseManager(String directory) throws DatabaseException, FileNotFoundException {
		adb = new AppDatabase(directory);
		views = new AppViews(adb);
		employeeMap = views.getEmployeeMap();
		deptMap = views.getDeptMap();
	};

	public static DatabaseManager getInstance(String directory) throws DatabaseException, FileNotFoundException {
		if (instance == null) {
			instance = new DatabaseManager(directory);
		}

		return instance;
	}

	@Override
	public void addEmployee(int id, String name, String title) {
		employeeMap.put(id, new Employee(id, name, title));
	}

	@Override
	public Employee getEmployee(int id) {
		return (Employee) employeeMap.get(id);
	}

	@Override
	public void addDept(int id, String name) {
		deptMap.put(id, new Department(id, name));
	}

	@Override
	public Department getDept(int id) {
		return (Department) deptMap.get(id);
	}

	@Override
	public void assignEmployeeToDept(int empId, int deptId) {
		Department dept = getDept(deptId);
		
		if (dept != null) {
			dept.addEmployee(empId);
			deptMap.put(dept.getId(), dept);
		}
	}

	@Override
	public void close() {
		adb.close();
	}
}
