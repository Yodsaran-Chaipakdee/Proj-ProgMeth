package entity.ingredient;

import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
	private int cookedPercentage;

	public Egg() {
		super("Egg");
		this.cookedPercentage = 0;
	}

	public void cook() {
		setCookedPercentage(this.cookedPercentage + 12);
		if (this.cookedPercentage > 0 && this.cookedPercentage <= 50) {
			this.setName("Raw Egg");
			this.setEdible(false);
		} else if (this.cookedPercentage > 50 && this.cookedPercentage <= 80) {
			this.setName("Sunny Side Egg");
			this.setEdible(true);
		} else if (this.cookedPercentage > 80 && this.cookedPercentage <= 100) {
			this.setName("Fried Egg");
			this.setEdible(true);
		} else if (this.cookedPercentage > 100) {
			this.setName("Burnt Egg");
			this.setEdible(false);
		}
	}

	public boolean isBurnt() {
		return this.cookedPercentage > 100;
	}

	@Override
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage < 0 ? 0 : cookedPercentage;
	}

}