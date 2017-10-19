package routine;

public abstract class Element {

	private String id;
	private int gradeOfExecution;
	private boolean secondHalf;
	private boolean combination;
	
	public Element(String id, int gradeOfExecution, boolean secondHalf, boolean combination) {
		
		this.id = id;
		this.gradeOfExecution = gradeOfExecution;
		this.secondHalf = secondHalf;
		this.combination = combination;
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getGOE() {
		return this.gradeOfExecution;
	}
	
	public boolean inSecondHalf() {
		return this.secondHalf;
	}
	
	public boolean isCombination() {
		return this.combination;
	}
	
}
