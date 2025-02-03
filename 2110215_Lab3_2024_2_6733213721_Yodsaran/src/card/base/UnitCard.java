package card.base;

import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card {

	private int power;
	private int health;

	public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost);
		setPower(power);
		setHealth(health);
	}

	// Getters & Setters

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power < 0 ? 0 : power;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health < 0 ? 0 : health;
	}

	// Method
	public int attackPlayer(Player opponent) {
		/*
		 * Hint: Use takeDamage() from Player class
		 */
		opponent.takeDamage(power);
		return this.power;
	}

	public abstract int attackUnit(UnitCard u);

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getName() + "\tCost: " + this.getBloodCost() + "\t(POW: " + this.getPower() + ", HP: "
				+ this.getHealth() + ")";
	}

}