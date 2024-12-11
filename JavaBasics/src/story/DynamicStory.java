package story;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ledger.LoggedTest;

/**
 * @author <Jaime>
 */
public class DynamicStory extends LoggedTest
{
	private static final String CODE_FILE= "src/story/DynamicStory";

	public static void main(String[] args) throws IOException, InterruptedException
	{
		LoggedTest.grabCode(CODE_FILE); // This logs your code in the ledger.  If you take this out the ledger will not fill!
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("                      WELCOME TO THE STICK OF TRUTH           ");
		Thread.sleep(1000);
		
		System.out.println("Humans and elves have been fighting for thousands of years. The humans fight");
		Thread.sleep(3000);
		
		System.out.println("but they struggle to stay alive as they are attacked by the drowed elves.");
		Thread.sleep(3000);
		
		System.out.println("News of a new kid spreads throught the land. In order to save the humans the");
		Thread.sleep(3000);
		
		System.out.println("grand wizard must get to the new kids before the elves get to him and manipulate");
		Thread.sleep(3000);
		
		System.out.println("him and use him to take the sacred relif of human hands. For whomever controls");
		Thread.sleep(3000);
		
		System.out.println("the stick, controls the universe. ");
		Thread.sleep(2500);
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println("Parents: This is a new beginning for us. I wonder how our kid is doing.");
		Thread.sleep(3000);
		
		System.out.println("You: Ugh I hate the montains. I'm going outside to make friends.");
		Thread.sleep(3000);
		
		System.out.println("Butters: Hi there! My name is Butter. I'm a paladin. The grand wizard has");
		Thread.sleep(3000);
		
		System.out.println("been talking about your arrival. He lives right over here.");
		Thread.sleep(3000);
		
		System.out.println("Butters: ALL HAIL THE GRAND WIZARD!");
		Thread.sleep(2500);
		
		System.out.println("Cartman: So you are the new kid. I am the wizard king. Let me show you my kingdom");
		Thread.sleep(3000);
		
		System.out.println("Cartman: Welcome to the kingdom of Kupa Keep. We have sought out for you new kid");
		Thread.sleep(3000);
		
		System.out.println("because humans everywhere are in great danger. If you help us, I will allow you");
		Thread.sleep(3000);
		
		System.out.println("into our kingdom. Please tell us thy name.");
		
		String uselessName = in.readLine();
		System.out.println("Cartman: You entered Loser. Is that correct?");
		System.out.println("YES     NO");
		String uselessDecision = in.readLine();
		System.out.println("Cartman: Are you sure you want to keep the name Loser?");
		System.out.println("YES     NO");
		String uselessDecision1 = in.readLine();
		
		System.out.println("Cartman: Very well, Loser. You will now choose a class. ");
		Thread.sleep(1500);
		
		System.out.println("        FIGHTER   MAGE   THIEF   PALADIN");
		String fightingStyle = "";
		
		while (true) {
			fightingStyle = in.readLine().toUpperCase();
			if (fightingStyle.equals("FIGHTER") || fightingStyle.equals("MAGE") || fightingStyle.equals("THIEF") || fightingStyle.equals("PALADIN")) {
				break; 
			} else { System.out.println("Cartman: Nah braw that isn't kewl. Do it right."); }
		}

		boolean fightingStyle1 = fightingStyle.contains("FIGHTER");
		boolean fightingStyle2 = fightingStyle.contains("MAGE");
		boolean fightingStyle3 = fightingStyle.contains("THIEF");
		boolean fightingStyle4 = fightingStyle.contains("PALADIN");
		
		
		if (fightingStyle1) { System.out.println("Cartman: We welcome to our kingdom Loser the fighter!") ;}
		if (fightingStyle2) { System.out.println("Cartman: We welcome to our kingdom Loser the mage!") ;}
		if (fightingStyle3) { System.out.println("Cartman: We welcome to our kingdom Loser the thief!") ;}
		if (fightingStyle4) { System.out.println("Cartman: We welcome to our kingdom Loser the paladin!") ;}
		Thread.sleep(2100);
		
		
		System.out.println("Butters: Hurray!!");
		Thread.sleep(1100);
		
		System.out.println("Cartman: Now go to the weapon shop so that we can teach you to fight.");
		Thread.sleep(3000);
		
		System.out.println("Here at the weapons table you can get weapons, consumables, and equipment.");
		Thread.sleep(3000);
		
		System.out.println("You need a weapon. As a " + fightingStyle + " you can only choose this for now.");
		Thread.sleep(3000); 
		
		if (fightingStyle1) { System.out.println("WARRIOR'S BLADE"); }
		if (fightingStyle2) { System.out.println("MAGIC WAND"); }
		if (fightingStyle3) { System.out.println("ROGUE'S DAGGER"); }
		if (fightingStyle4) { System.out.println("PALADIN STAFF"); }
		Thread.sleep(2000);
		
		System.out.println("You're going to need to get some consumables if you want to battle.");
		System.out.println("YES     NO");
		String consumablesDecision = "";
		
		while (true) {
			consumablesDecision = in.readLine().toUpperCase();
			if (consumablesDecision.equals("YES") || consumablesDecision.equals("NO")) {
				break;
			} else { System.out.println("C'mon kid. Do it right.") ; }
		}
		boolean consumablesDecisionNo = consumablesDecision.contains("NO");
		boolean consumablesDecisionYes = consumablesDecision.contains("YES");
		
		if (consumablesDecisionNo) { System.out.println("Kewl. Seems like you have battle experience, Loser"); }
		
		
		
		String whichConsumable = "";
		
		boolean whichConsumable1 = whichConsumable.contains("SMALL HEALTH POTION");
		boolean whichConsumable2 = whichConsumable.contains("REVIVE POTION");
		boolean whichConsumable3 = whichConsumable.contains("POWER POTION");
		boolean whichConsumable4 = whichConsumable.contains("SPEED POTION");
		

		
		
		System.out.println("You can only choose one for now. Choose your consumable:");
		System.out.println("SMALL HEALTH POTION    REVIVE POTION    POWER POTION    SPEED POTION"); 
			while (true) {
				whichConsumable = in.readLine().toUpperCase();
				if (whichConsumable.equals("SMALL HEALTH POTION") || whichConsumable.equals("REVIVE POTION") || whichConsumable.equals("POWER POTION")
						|| whichConsumable.equals("SPEED POTION")) {
					break;
				} else { System.out.println("C'mon type it in right. I don't got all day to train you."); }
			} 
		if (whichConsumable1) { System.out.println("A health potion restores some of your health. Duh."); }
		if (whichConsumable2) { System.out.println("A revive potion revives you if you die."); }
		if (whichConsumable3) { System.out.println("A power potion gives you 50% more strength. Pretty kewl, right?"); }
		if (whichConsumable4) { System.out.println("A speed potion let's you attack faster and get off more attacks."); }
		
		System.out.println("Cartman: It's time to teach you how to fight. I want you to take your new");
		Thread.sleep(3000);
		
		System.out.println("weapon and with the bravery of a novel night... beat up Clyde");
		Thread.sleep(3000);
		
		System.out.println("Clyde: What?? What'd I do??");
		Thread.sleep(2300);
		
		System.out.println("Cartman: I'm the king Clyde. And the king wishes to be amuzed. Go on new kid.");
		Thread.sleep(3000);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
}