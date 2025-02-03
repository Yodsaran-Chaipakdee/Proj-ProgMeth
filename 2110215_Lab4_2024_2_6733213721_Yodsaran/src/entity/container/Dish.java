package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {

	private int dirty;

	public Dish() {
		super("Dish", 4);
		setDirty(0);
	}

	public Dish(int dirty) {
		super("Dish", 4);
		setDirty(dirty);
	}

	public boolean isDirty() {
		return dirty > 0;
	}

	public int getDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		this.dirty = dirty < 0 ? 0 : dirty;
		if (dirty > 0) {
			setName("Dirty Dish");
		} else {
			setName("Dish");
		}
	}

	public void clean(int amount) {
		setDirty(this.dirty - amount);
	}

	@Override
	public boolean verifyContent(Ingredient i) {
		// TODO Auto-generated method stub
		return !isDirty() && i.isEdible();
	}

	@Override
	public String toString() {
		if (isDirty()) {
			return StringUtil.formatNamePercentage(getName(), dirty);
		} else {
			return super.toString();
		}
	}

}