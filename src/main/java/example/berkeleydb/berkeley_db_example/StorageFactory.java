package example.berkeleydb.berkeley_db_example;

import java.io.FileNotFoundException;

import com.sleepycat.je.DatabaseException;

public class StorageFactory {
    public static StorageInterface getDatabaseInstance(String directory) throws DatabaseException, FileNotFoundException {
    	return DatabaseManager.getInstance(directory);
    }
}
