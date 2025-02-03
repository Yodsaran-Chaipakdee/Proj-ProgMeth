
package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
	private boolean chopState;
	private int cookedPercentage;

	public Meat() {
		super("Meat");
		this.chopState = false;
		this.cookedPercentage = 0;
	}

	public void chop() {
		if (!isChopped() && cookedPercentage == 0) {
			setChopState(true);
			setName("Minced Meat");
		}
	}

	public boolean isChopped() {
		return chopState;
	}

	public void cook() {
		if (!isChopped()) {
			setCookedPercentage(this.cookedPercentage + 10);
			if (this.cookedPercentage > 0 && this.cookedPercentage <= 50) {
				this.setName("Raw Meat");
				this.setEdible(false);
			} else if (this.cookedPercentage > 50 && this.cookedPercentage <= 80) {
				this.setName("Medium Rare Steak");
				this.setEdible(true);
			} else if (this.cookedPercentage > 80 && this.cookedPercentage <= 100) {
				this.setName("Well Done Steak");
				this.setEdible(true);
			} else if (this.cookedPercentage > 100) {
				this.setName("Burnt Steak");
				this.setEdible(false);
			}
		} else {
			setCookedPercentage(this.cookedPercentage + 15);
			if (this.cookedPercentage > 0 && this.cookedPercentage <= 80) {
				this.setName("Raw Burger");
				this.setEdible(false);
			} else if (this.cookedPercentage > 80 && this.cookedPercentage <= 100) {
				this.setName("Cooked Burger");
				this.setEdible(true);
			} else if (this.cookedPercentage > 100) {
				this.setName("Burnt Burger");
				this.setEdible(false);
			}
		}
	}

	public boolean isBurnt() {
		return this.cookedPercentage > 100;
	}

	@Override
	public String toString() {
		return StringUtil.formatNamePercentage(getName(), cookedPercentage);
	}

	// Getters & Setters

	public void setChopState(boolean chopState) {
		this.chopState = chopState;
	}

	public int getCookedPercentage() {
		return cookedPercentage;
	}

	public void setCookedPercentage(int cookedPercentage) {
		this.cookedPercentage = cookedPercentage;
	}

}
