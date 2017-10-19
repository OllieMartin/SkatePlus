package scoring;

import routine.CombinationElement;
import routine.Component;
import routine.Element;
import routine.Routine;
import values.NoSuchElementException;
import values.ValuesManager;

public class ScoresManager {

	private static ScoresManager instance;

	static {
		ScoresManager.instance = new ScoresManager();
	}

	public static ScoresManager getInstance() {
		return ScoresManager.instance;
	}

	/* END OF STATIC DECLARATIONS */

	private ScoresManager() {
		// EMPTY
	}

	public float getScore(Element element) throws NoSuchElementException {

		float score = 0;

		if (element.isCombination()) {

			for (String combinationPart : ((CombinationElement) element).getCombinationParts()) {

				score += ValuesManager.getInstance().getValue(combinationPart, element.getGOE());

			}

		} else {

			score = ValuesManager.getInstance().getValue(element.getId(), element.getGOE());

		}

		if (element.inSecondHalf()) {
			// TODO APPLY SOME FACTOR
		}

		return score;

	}

	public float getScore(Component component) {

		return component.getScore() * component.getFactor();

	}

	public float getTechnicalScore(Routine routine) throws NoSuchElementException {

		float score = 0;

		for (Element element : routine.getElements()) {

			score += this.getScore(element);

		}
		
		return score;

	}
	
	public float getComponentsScore(Routine routine) {

		float score = 0;

		for (Component component : routine.getComponents()) {

			score += this.getScore(component);

		}
		
		return score;
	}
	
	public float getTotalScore(Routine routine) throws NoSuchElementException {
		
		return this.getTechnicalScore(routine) + this.getComponentsScore(routine);
		
	}

}
