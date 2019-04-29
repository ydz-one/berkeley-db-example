package example.berkeleydb.berkeley_db_example;

import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;

import java.io.File;
import java.io.FileNotFoundException;

public class AppDatabase {
	
    private Environment env;
    private static final String CLASS_CATALOG = "java_class_catalog";
    private StoredClassCatalog javaCatalog;
    
    private static final String EMPLOYEE_STORE = "employee_store";
    private static final String DEPT_STORE = "dept_store";
    
    private Database employeeDb;
    private Database deptDb;
    
    public AppDatabase(String homeDirectory) throws DatabaseException, FileNotFoundException {
        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(true);

        env = new Environment(new File(homeDirectory), envConfig);
        
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setTransactional(true);
        dbConfig.setAllowCreate(true);

        Database catalogDb = env.openDatabase(null, CLASS_CATALOG, dbConfig);
        employeeDb = env.openDatabase(null, EMPLOYEE_STORE, dbConfig);
        deptDb = env.openDatabase(null, DEPT_STORE, dbConfig);

        javaCatalog = new StoredClassCatalog(catalogDb);
    }
    
    public Database getEmployeeDb() {
    	return employeeDb;
    }
    
    public Database getDeptDb() {
    	return deptDb;
    }
        
    public StoredClassCatalog getClassCatalog() {
        return javaCatalog;
    }
    
    public Environment getEnvironment() {
        return env;
    }
    
    public void close() throws DatabaseException {
    	employeeDb.close();
    	deptDb.close();
    	javaCatalog.close();
    	env.close();
    }
}
