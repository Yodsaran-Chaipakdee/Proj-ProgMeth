package entity;

import java.util.Random;

import ability.UltimatePower;
import gamelogic.AttackZone;
import gui.EnemyPane;
import gui.EntityPane;
import gui.PlayerPane;

public class Player extends Entity implements UltimatePower {
	private int ultimateTurnCount;
	private int poisonTurnCount; // Tracks how long the player has been poisoned
	private boolean isPoisoned; // Indicates if the player is currently poisoned
	private Random rand;

	public Player(int maxHealth, int attackPower) {
		super("CEDT Student ", maxHealth, attackPower);
		this.ultimateTurnCount = 0;
		this.poisonTurnCount = 0;
		this.isPoisoned = false;
		this.rand = new Random();
	}

	// Attack For Player
	public String attack(Entity target, AttackZone sliderZone , EnemyPane enemyPane) {

		int dealDamage = this.getAttackPower() + plusDamageFromZone(sliderZone);
		String dialogueDealDamage ;
		// define range of value
		double failToAttack = rand.nextDouble();
		double successToAttack = rand.nextDouble();

		if (successToAttack > failToAttack) {
			double successCriticalHit = rand.nextDouble();
			double failCriticalHit = rand.nextDouble();
			if (successCriticalHit > failCriticalHit) {
				dealDamage *= 1;
			}
			target.takeDamage(dealDamage);
			dialogueDealDamage = "Deal Damage To " + target.getName() + " total " + dealDamage + " damage." ;
			
			// update UI health bar of enemy
			enemyPane.updateHealthBar();
			
			double failUltimateCharge = rand.nextDouble();
			double successUltimateCharge = rand.nextDouble();
			if (successUltimateCharge > failUltimateCharge) {
				if(this.ultimateTurnCount < 5) this.ultimateTurnCount++;
			}

		} else {
			String[] dialogueFailAttack = { " 5555555413347", " ,you have hit enemy or else you will get U.",
					" Pathetic" };
			int indexDialogue = rand.nextInt(3);
			dialogueDealDamage = target.getName() + " evades! " + dialogueFailAttack[indexDialogue] ;
		}
		
		System.out.println(dialogueDealDamage);
		System.out.println("current enemy hp is " + target.getCurrentHealth() + "\n");
		
		return dialogueDealDamage ;
	}

	@Override
	public String useUltimate(Entity target , EntityPane enemyPane) {
		String dialogue = "" ;
		if (this.canUseUltimate()) {
			int dealDamage = this.getAttackPower() * (rand.nextInt(3) + 1) * 5;
			target.takeDamage(dealDamage);
			this.ultimateTurnCount = 0 ;
			dialogue = "Ultimate!!! Deal Damage To " + target.getName() + " total " + dealDamage + " damage." ;
			// update UI health bar of enemy
			((EnemyPane)enemyPane).updateHealthBar();
		}
		return dialogue ;
	}

	public void evade(Enemy enemy) {
		double evadeChance = rand.nextDouble();
		if (evadeChance > enemy.getAttackAccuracy()) {
			System.out.println("Evade Success!!");
		} else {
			System.out.println("Evade Fail.");
			this.takeDamage(enemy.getAttackPower());
		}
	}

	public void applyPoison() {
		if (!isPoisoned && poisonTurnCount == 0) {
			isPoisoned = true;
			poisonTurnCount = 5;
		}
	}

	// parameter poisonDamage for Enemy that have poisonDamage deal to Player
	public String updateStatusEffects(int poisonDamage , PlayerPane playerPane) {
		boolean poisonCritical = false;
		if (isPoisoned) {
			String dialogue = "" ;
			if (rand.nextDouble() > 0.5) {
				poisonCritical = true;
				poisonDamage *= 2;
			}
			this.takeDamage(poisonDamage); // Poison damage each turn
			playerPane.updateHealthBar();
			poisonTurnCount--;

			if (poisonCritical) {
				dialogue += "Poison Critical Hit!\n" ;
			}
			
			dialogue += this.getName() + " takes " + poisonDamage + " poison damage! " + poisonTurnCount + " turns left.\n";
			System.out.println(dialogue);
			
			if (poisonTurnCount <= 0) {
				isPoisoned = false;
				dialogue += "you is no longer poisoned!";
			}
			return dialogue ;
		}
		return null ;
	}

	private int plusDamageFromZone(AttackZone sliderZone) {
		if (sliderZone == AttackZone.GREEN) {
			return 10;
		} else if (sliderZone == AttackZone.YELLOW) {
			return 5;
		}
		// Red Zone return 0
		return 0;
	}

	// check player can use ultimate or not
	@Override
	public boolean canUseUltimate() {
		return ultimateTurnCount >= 5;
	}

	// Getters & Setters
	public int getUltimateTurnCount() {
		return ultimateTurnCount;
	}

	public void setUltimateTurnCount(int ultimateTurnCount) {
		this.ultimateTurnCount = Math.max(ultimateTurnCount, 0);
	}

	public boolean isPoisoned() {
		return isPoisoned;
	}
}
