package entity.counter;

import logic.InvalidIngredientException;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter {
	private String myIngredient;

	public String getMyIngredient() {
		return myIngredient;
	}

	public void setMyIngredient(String myIngredient) {
		this.myIngredient = myIngredient;
	}

	public Crate(String s) {
		super(s + " Crate");
		setMyIngredient(s);
	}

	@Override
	public void interact(Player p) {
		if (!p.isHandEmpty() || !isPlacedContentEmpty()) {
			super.interact(p);
		} else {
			try {
				p.setHoldingItem(LogicUtil.createIngredientFromName(myIngredient));
			} catch (InvalidIngredientException e) {
				// TODO Auto-generated catch block
				p.setHoldingItem(null);
			}
		}
	}

}