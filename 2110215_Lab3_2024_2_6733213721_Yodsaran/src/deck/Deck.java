package deck;

import java.util.Arrays;

import card.base.Card;

public class Deck {
	// TODO: constructor

	private String name;
	private int deckSize;
	private Card[] deckList;

	public Deck(String name, Card[] deckList) {
		this.name = name;
		this.deckSize = deckList.length;
		this.deckList = deckList.clone();
	}

	// Getters & Setters

	public String getName() {
		return name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public void setDeckSize(int deckSize) {
		Card[] newDeckList = Arrays.copyOf(this.deckList, deckSize);
		this.deckList = newDeckList;
		this.deckSize = deckSize;
	}

	public Card[] getDeckList() {
		return deckList;
	}

	// You CAN modify the first line
	public int insertCard(Card card) throws InsertCardFailedException {
		int count = 0;
		for (int i = 0; i < deckList.length; i++) {
			if (deckList[i].equals(card)) {
				count++;
			}
		}
		if (count >= 4)
			throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size
		// Must return new deckSize
		else {
			Card[] newDeckList = Arrays.copyOf(this.deckList, this.deckSize + 1);
			newDeckList[deckSize] = card;
			this.deckList = newDeckList;
			this.deckSize = deckList.length;
		}
		return this.deckSize;
	}

	// You CAN modify the first line
	public Card removeCard(int slotNumber) throws RemoveCardFailedException {
		if (this.deckList.length <= slotNumber) {
			throw new RemoveCardFailedException("Number you insert exceed deck size");
		}
		if (this.deckList[slotNumber] == null) {
			throw new RemoveCardFailedException("There is no card in that slot");
		}
		// FILL CODE HERE
		// You can use Arrays.copyOf(Original Array, New Length) to create new arrays
		// with bigger size (Added slot is empty)
		// Once card is removed, other card down the list must rearrange to the empty
		// slot
		// Must return card that was removed

		Card removeCard = deckList[slotNumber];
		Card[] newDeckList = new Card[this.deckList.length - 1];
		int index = 0;
		for (int i = 0; i < deckList.length; i++) {
			if (i != slotNumber) {
				newDeckList[index] = deckList[i];
				index++;
			}
		}
		this.deckList = newDeckList;
		this.deckSize = deckList.length;
		return removeCard;
	}

	@Override
	public String toString() {
		return new StringBuilder().append("{").append(this.getName()).append("}").append("(").append(this.getDeckSize())
				.append(" deck size)").toString();
	}

	/* GETTERS & SETTERS */

}