package routine;

import java.util.List;

public class CombinationElement extends Element {
	
	private List<String> combinationParts;

	public CombinationElement(String id, int gradeOfExecution, boolean secondHalf, List<String> combinationParts) {
		super(id, gradeOfExecution, secondHalf, true);
		this.combinationParts = combinationParts;
	}
	
	public List<String> getCombinationParts() {
		return this.combinationParts;
	}

}
