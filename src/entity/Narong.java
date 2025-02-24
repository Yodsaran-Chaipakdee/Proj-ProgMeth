package entity;

import java.util.ArrayList;
import java.util.Random;

import ability.PoisonousPower;
import gui.EnemyPane;
import gui.PlayerPane;

public class Narong extends Enemy implements PoisonousPower {

	private Random rand = new Random();
	private int poisonDamage;

	public Narong(int maxHealth, int attackPower) {
		super(" Narongdech The DigLo ", maxHealth, attackPower);
		// set default as 10
		this.setPoisonDamage(2);
		this.setAttackAccuracy(0.4);
	}

	@Override
	public String[] attack(Entity target, PlayerPane playerPane, EnemyPane enemyPane) {
	    
	    ArrayList<String> dialogues = new ArrayList<String>();
	    
	    // Normal attack
	    target.takeDamage(this.getAttackPower());
	    playerPane.updateHealthBar();
	    
	    String[] message = { 
	        "\"Don't forget to submit your work, students.\"\n",
	        "\"Why don't I see you submit the project?\"\n",
	        "\"It's still not too late to transfer to another faculty.\"\n" 
	    };
	    String attackDialogue = message[rand.nextInt(message.length)] 
	            + this.getName() + " deals " + this.getAttackPower() + " damage to you.";
	    System.out.println(attackDialogue);
	    
	    dialogues.add(attackDialogue);
	    
	    // Apply poison if not already poisoned
	    if (target instanceof Player && rand.nextDouble() > 0.5 && !((Player) target).isPoisoned()) {
	        applyPoison((Player) target);
	        String poisonDialogue = this.getName() + " applied poison to you.";
	        System.out.println(poisonDialogue);
	        dialogues.add(poisonDialogue);
	    }
	    
//	    String dialoguePoisoned = ((Player)target).updateStatusEffects(this.getPoisonDamage(), playerPane);
//	    if(dialoguePoisoned != null) {
//	    	System.out.println(dialoguePoisoned);
//	    	dialogues.add(dialoguePoisoned);
//	    }
	    String[] allDialogues = dialogues.toArray(new String[0]);
	    
	    // Convert ArrayList to String[] and return
	    return allDialogues;
	}


	@Override
	public void applyPoison(Player player) {
		System.out.println(player.getName() + " is poisoned!");
		// make player poisoned
		player.applyPoison();
	}

	// Getter & Setter
	public int getPoisonDamage() {
		return poisonDamage;
	}

	public void setPoisonDamage(int poisonDamage) {
		this.poisonDamage = poisonDamage;
	}

}
