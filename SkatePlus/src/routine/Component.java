package routine;

public class Component {

	private String id;
	private float score;
	private float factor;
	
	public Component(String id, float score, float factor) {
		this.id = id;
		this.score = score;
		this.factor = factor;
	}
	
	public String getId() {
		return this.id;
	}
	
	public float getScore() {
		return this.score;
	}
	
	public float getFactor() {
		return this.factor;
	}
	
}
