
package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {

	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost, power, health);
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		int fullHP = unitCard.getHealth();
		unitCard.setHealth(fullHP - this.getPower());
		return fullHP > this.getPower() ? this.getPower() : fullHP;
	}

}
