package values;

public class NoSuchElementException extends Exception {

	private static final long serialVersionUID = 3709075858334764973L;

	public NoSuchElementException(String id) {
		super ("No such element with ID: " + id + ", exists in the database.");
	}

}