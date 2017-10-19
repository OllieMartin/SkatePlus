package routine;

import java.util.List;

import scoring.ScoresManager;
import values.NoSuchElementException;

public class Routine {
	
	private List<Element> elements;
	private List<Component> components;

	public Routine(List<Element> elements, List<Component> components) {
		
		this.elements = elements;
		this.components = components;
		
	}
	
	public List<Element> getElements() {
		return this.elements;
	}
	
	public List<Component> getComponents() {
		return this.components;
	}
	
	public float getTechnicalScore() throws NoSuchElementException {
		return ScoresManager.getInstance().getTechnicalScore(this);
	}
	
	public float getComponentsScore() {
		return ScoresManager.getInstance().getComponentsScore(this);
	}
	
	public float getTotalScore() throws NoSuchElementException {
		return ScoresManager.getInstance().getTotalScore(this);
	}
	
}
