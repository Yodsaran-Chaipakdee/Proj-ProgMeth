package card.base;

//You CAN modify the first line
public abstract class Card implements Cloneable {

	/// You can modify code below ///

	private String name;
	private String flavorText;
	private int bloodCost;

	public Card(String name, String flavorText, int bloodCost) {
		setName(name);
		setFlavorText(flavorText);
		setBloodCost(bloodCost);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public void setBloodCost(int bloodCost) {
		this.bloodCost = bloodCost < 0 ? 0 : bloodCost;
	}

	public String getName() {
		return this.name;
	}

	public int getBloodCost() {
		return this.bloodCost;
	}

	public String getFlavorText() {
		return this.flavorText;
	}

	public abstract String toString();

	/// You can modify code above ///

	public boolean equals(UnitCard other) {
		return this.getName().equals(other.getName());
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}