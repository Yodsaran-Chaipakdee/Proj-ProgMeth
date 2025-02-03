package entity.ingredient;
import entity.base.Choppable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
	private boolean chopState;

	public Lettuce() {
		super("Lettuce");
		this.chopState = false;
		this.setEdible(true);
	}

	public boolean isChopped() {
		return this.chopState;
	}

	public void chop() {
		if (!isChopped()) {
			this.chopState = true;
			this.setName("Chopped Lettuce");
		}
	}

}