package card.base;

//You CAN modify the first line
public abstract class SpellCard extends Card {
	private boolean isBurstSpeed;

	public SpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed) {
		super(name, flavorText, bloodCost);
		this.isBurstSpeed = isBurstSpeed;
	}

	// Getters & Setters

	public boolean isBurstSpeed() {
		return isBurstSpeed;
	}

	public void setBurstSpeed(boolean isBurstSpeed) {
		this.isBurstSpeed = isBurstSpeed;
	}

	// Method

	public abstract void castSpell(UnitCard unitCard);

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getName() + "\tCost: " + this.getBloodCost() + "\t(" + (this.getFlavorText()) + ")";
	}

}