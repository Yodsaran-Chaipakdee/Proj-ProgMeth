package card.type;

import card.base.UnitCard;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {

	private int buffPower;
	private int buffHealth;

	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower,
			int buffHealth) {
		super(name, flavorText, bloodCost, power, health);
		setBuffPower(buffPower);
		setBuffHealth(buffHealth);
	}

	public int getBuffPower() {
		return buffPower;
	}

	public void setBuffPower(int buffPower) {
		this.buffPower = buffPower < 0 ? 0 : buffPower;
	}

	public int getBuffHealth() {
		return buffHealth;
	}

	public void setBuffHealth(int buffHealth) {
		this.buffHealth = buffHealth < 0 ? 0 : buffHealth;
	}

	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + " | POW Inc: "
				+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}

	@Override
	public int attackUnit(UnitCard unitCard) {
		int fullHP = unitCard.getHealth();
		unitCard.setHealth(fullHP - this.getPower());
		return fullHP > this.getPower() ? this.getPower() : fullHP;
	}

	public void buffUnit(UnitCard[] alliesCard) {
		for (int i = 0; i < alliesCard.length; i++) {
			if (alliesCard[i] != null) {
				alliesCard[i].setPower(alliesCard[i].getPower() + this.buffPower);
				alliesCard[i].setHealth(alliesCard[i].getHealth() + this.buffHealth);
			}
		}
	}

}