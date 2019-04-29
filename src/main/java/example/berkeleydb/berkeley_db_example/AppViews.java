package example.berkeleydb.berkeley_db_example;

import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.bind.serial.SerialBinding;
import com.sleepycat.collections.StoredEntrySet;
import com.sleepycat.collections.StoredSortedMap;

public class AppViews {
    private StoredSortedMap employeeMap;
    private StoredSortedMap deptMap;
    
    public AppViews(AppDatabase adb) {
    	ClassCatalog catalog = adb.getClassCatalog();
        EntryBinding employeeKeyBinding = new SerialBinding(catalog, Integer.class);
        EntryBinding employeeDataBinding = new SerialBinding(catalog, Employee.class);
        EntryBinding deptKeyBinding = new SerialBinding(catalog, Integer.class);
        EntryBinding deptDataBinding = new SerialBinding(catalog, Department.class);
        
        employeeMap = new StoredSortedMap(adb.getEmployeeDb(), employeeKeyBinding, employeeDataBinding, true);
        deptMap = new StoredSortedMap(adb.getDeptDb(), deptKeyBinding, deptDataBinding, true);
    }

	public StoredSortedMap getEmployeeMap() {
		return employeeMap;
	}

	public StoredSortedMap getDeptMap() {
		return deptMap;
	}
	
	
	public StoredEntrySet getUserEntrySet() {
		return (StoredEntrySet) employeeMap.entrySet();
	}
	
	public StoredEntrySet getWebContentEntrySet() {
		return (StoredEntrySet) deptMap.entrySet();
	}
}
