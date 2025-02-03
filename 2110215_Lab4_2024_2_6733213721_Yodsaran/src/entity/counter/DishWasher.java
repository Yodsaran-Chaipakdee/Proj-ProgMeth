package entity.counter;

import entity.base.Updatable;
import entity.container.Dish;
import entity.container.Pan;
import logic.Player;

public class DishWasher extends Counter implements Updatable {

	public DishWasher() {
		super("Dish Washer");
	}

	@Override
	public void interact(Player p) {
		if (p.getHoldingItem() instanceof Dish) {
			Dish d = (Dish) p.getHoldingItem();
			if (!isPlacedContentEmpty() || d.isDirty()) {
				super.interact(p);
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (getPlacedContent() instanceof Dish) {
			Dish d = (Dish) getPlacedContent();
			d.clean(15);
		}

	}

}