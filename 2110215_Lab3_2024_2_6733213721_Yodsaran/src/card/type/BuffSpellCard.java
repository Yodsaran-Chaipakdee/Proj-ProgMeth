package card.type;

import card.base.SpellCard;

import card.base.UnitCard;

//You CAN modify the first line
public class BuffSpellCard extends SpellCard {

	private int powerIncrease;

	public BuffSpellCard(String name, String flavorText, int bloodCost, boolean isBurstSpeed, int powerIncrease) {
		super(name, flavorText, bloodCost, isBurstSpeed);
		setPowerIncrease(powerIncrease);
	}

	public int getPowerIncrease() {
		return powerIncrease;
	}

	public void setPowerIncrease(int powerIncrease) {
		this.powerIncrease = powerIncrease < 1 ? 1 : powerIncrease;
	}

	@Override
	public void castSpell(UnitCard unitCard) {
		// TODO Auto-generated method stub
		unitCard.setPower(unitCard.getPower() + powerIncrease);
	}

}