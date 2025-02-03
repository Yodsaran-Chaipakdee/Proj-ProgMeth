package entity.counter;

import entity.base.Choppable;
import entity.base.Ingredient;
import logic.Player;

public class ChoppingBoard extends Counter {

	public ChoppingBoard() {
		super("Chopping Board");
	}

	@Override
	public void interact(Player p) {
		if (p.getHoldingItem() instanceof Ingredient && p.getHoldingItem() instanceof Choppable) {
			Choppable ChopItem = (Choppable) p.getHoldingItem();
			ChopItem.chop();
		}
		if (!isPlacedContentEmpty() || p.getHoldingItem() instanceof Ingredient) {
			super.interact(p);
		}

	}

}