package values;

import java.util.HashSet;
import java.util.Set;

import database.Col;
import database.DatabaseManager;

public class ValuesManager {
	
	private static ValuesManager instance;

	static {
		
		ValuesManager.instance = new ValuesManager();
		
	}
	
	public static ValuesManager getInstance() {
		return instance;
	}
	
	/* END OF STATIC DECLARATIONS */
	
	private Set<String> validElements;
	
	private ValuesManager() {
		
		validElements = new HashSet<String>();
		//TODO Read in a list of all valid elements to add to this set
		
	}
	
	public boolean isValidElement(String id) {
		return validElements.contains(id);
	}
	
	public float getValue(String id, int gradeOfExecution) throws NoSuchElementException {
		
		float baseValue = 0;
		float goeValue = 0;
		Col dbGOE;
		
		if (!isValidElement(id)) throw new NoSuchElementException(id);
		
		dbGOE = Col.getFromInt(gradeOfExecution);
		if (dbGOE == null) dbGOE = Col.BASE;
		
		if (dbGOE != Col.BASE) {
			goeValue = DatabaseManager.getInstance().query(id, dbGOE);
		}
		
		baseValue = DatabaseManager.getInstance().query(id, Col.BASE);
		
		return baseValue + goeValue;
		
	}
	
}
