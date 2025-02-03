package entity.counter;

import entity.base.Item;
import entity.base.Updatable;
import entity.container.Pan;
import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Stove extends Counter implements Updatable {

	public Stove() {
		super("Stove");
	}

	public Stove(Item content) {
		super("Stove");
		setPlacedContent(content);
	}

	@Override
	public void interact(Player p) {
		if (!isPlacedContentEmpty() || p.getHoldingItem() instanceof Pan) {
			super.interact(p);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (getPlacedContent() instanceof Pan) {
			Pan p = (Pan) getPlacedContent();
			p.cook();
		}

	}

}