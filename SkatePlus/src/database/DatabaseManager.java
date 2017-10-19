package database;

public class DatabaseManager {

	private static DatabaseManager instance;
	
	static {
		instance = new DatabaseManager();
	}
	
	public static DatabaseManager getInstance() {
		return DatabaseManager.instance;
	}
	
	/* END OF STATIC DECLARATIONS */
	
	private DatabaseManager() {
		// EMPTY
	}
	
	public float query(String id, Col col) {
		
		float value = 0;
		
		// TODO value = database.query("SELECT " + col.toString() + " FROM SOV WHERE ID='" + id + "';";
		
		return value;
		
	}
	
}
