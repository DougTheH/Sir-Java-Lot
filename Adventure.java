/**
 * 
 */
package assignment5;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/**
 * @author Doug
 *
 */
public class Adventure {
	
	private static ArrayList<Enemy> Enemies= new ArrayList<Enemy>();
	
	/**
	 * @param args
	 * @throws IllegalDamageException 
	 */
	public static void main(String[] args) throws IllegalDamageException 
	{
		//vars
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		char input;
		Knight knight;
		int numEnemies = 0;
		int damage = 0;
		int hp = 0;
		int damagedealt = 0;
		int maxhealth;
		
		//Welcome the player
		System.out.println("Welcome to Adventure!");
		//create Player 1 Knight
		do{
			System.out.println("Would you like to design your own knight?(y/n)");
			input = sc.next().trim().toLowerCase().charAt(0);
		}while ('n' != input && 'y' != input);
		
		if('y' == input) //prompt user for input data
		{
			//ask for name
			String name;
			System.out.println("Please enter your knight's name:");
			name = sc.next();
			
			//ask for age
			int age = 15;
			try {
				System.out.println("Please enter your knight's age:");
				age = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Not a valid integer number!");
				e.printStackTrace();
			}
			
			//ask for weapon preference
			int weapon = 0;
			try {
				System.out.println("Please choose your knight's weapon:\n1)Longsword\n2)Battleaxe\n3)Spear\n4)Warhammer\n5)MagicMissile");
				weapon = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Not a valid integer number!");
				e.printStackTrace();
			}
			Weapon wpn;
			switch(weapon)
			{
				case 1: wpn = Weapon.LONGSWORD;
				break;
				case 2: wpn = Weapon.BATTLEAXE;
				break;
				case 3: wpn = Weapon.SPEAR;
				break;
				case 4: wpn = Weapon.WARHAMMER;
				break;
				case 5: default: wpn = Weapon.MAGICMISSILE;
			}
			
			//ask for armor preference
			int armor = 0;
			try {
				System.out.println("Please choose your knight's armor:\n1)Robes\n2)Leather\n3)Plate");
				armor = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Not a valid integer number!");
				e.printStackTrace();
			}
			Armor amr;
			switch(armor)
			{
				case 1: default: amr = Armor.ROBES;
				break;
				case 2: amr = Armor.LEATHER;
				break;
				case 3: amr = Armor.PLATE;
			}
			
			//generate knight
			knight = new Knight(name, age, wpn, amr);	
		}
		else	//generate random knight
		{
			knight = new Knight();
		}
		maxhealth = knight.getHealth();
		
		//Display the players character
		System.out.println("Your character:");
		knight.print();
		System.out.println("Time to adventure!!\nNobiscum deus!");
		
		//play the game
		boolean keepPlaying = true;
		while(keepPlaying)
		{
			//generate enemies.
			numEnemies = 1 + rnd.nextInt(4);
			for(int i = 0; i < numEnemies; ++i)
			{
				Enemies.add(Enemy.EnemyGenerator());
			}
			
			
			//fight loop
			while(0 < Enemies.size())
			{
				//if more than one enemy ask which foe to attack
				int targetedEnemy = 0;
				System.out.println("The following foes stand before you: ");
				displayEnemies();
				do{
					do{
						System.out.println("Choose which enemy to target: ");
					}while (!sc.hasNextInt());
					targetedEnemy = sc.nextInt();
				}while(0 >= targetedEnemy || targetedEnemy > Enemies.size() );
				--targetedEnemy;	//remove the offset for easier human readability
				
				//attack enemy
				System.out.println("You attack " + Enemies.get(targetedEnemy).toString() + " with your " + knight.getWeapon());
				damage = knight.fight();
				hp = Enemies.get(targetedEnemy).getHealth();
				Enemies.get(targetedEnemy).takeDamage(damage, knight.getWeapon());
				if(!Enemies.get(targetedEnemy).isAlive())
				{
					System.out.println("You have slain the " + Enemies.get(targetedEnemy).toString());
					Enemies.remove(targetedEnemy);
				}
				else
				{
					damagedealt = hp - Enemies.get(targetedEnemy).getHealth();
					System.out.println("You struck for " + damagedealt + " damage!");
					//did extra damage
					if(damage < damagedealt)
					{
						System.out.println("It's super effective!");
					}
					//did less damage
					else if(damage > damagedealt)
					{
						System.out.println("It's not very effective!");
					}
				}//end player attack enemy
				
				//enemy attacks
				for(int i = 0; i < Enemies.size(); ++i)
				{
					System.out.println(Enemies.get(i).toString() + " attacks you with " + Enemies.get(i).getWeapon()); 
					damage = Enemies.get(i).fight();
					hp = knight.getHealth();
					knight.takeDamage(damage, Enemies.get(i).getWeapon());
					if(!knight.isAlive())
					{
						System.out.println("You have been slain by the treacherous " + Enemies.get(i).toString() + "!");
						keepPlaying = false;
						break;
					}
					else
					{
						damagedealt = hp - knight.getHealth();
						System.out.println("It hits you for " + damagedealt + " damage!");
						//did extra damage
						if(damage < damagedealt)
						{
							System.out.println("It's super effective!");
						}
						//did less damage
						else if(damage > damagedealt)
						{
							System.out.println("It's not very effective!");
						}
						
						System.out.println("You have " + knight.getHealth() + " health remaining!");
					}
					
				}//end enemy attacks
				if(!knight.isAlive())
				{
					break;
				}
			}//end fight loop
			if(!knight.isAlive())
			{
				break;
			}
			
			//assign gold and update stats
			knight.setNumBattles(1 + knight.getNumBattles());
			knight.setGold(50 + knight.getGold());
			maxhealth += 10;
			System.out.println("You have improved as a warrior from this victory and gained 50 gold!\nDeus Vult!");
			
			//ask if keep playing
			do{
				System.out.println("Continue your adventure?(y/n)");
				input = sc.next().trim().toLowerCase().charAt(0);
			}while ('n' != input && 'y' != input);
			
			if('n' == input)
			{
				keepPlaying = false;
			}
			
			if('y' == input)
			{
				System.out.println("You have recovered to full health and continued your quest!");
				knight.setHealth(maxhealth);
			}
	
		}	//end game loop
		
		System.out.println("Your quest is at an end.");
		knight.setHealth(maxhealth);
		knight.print();
		
		
		
		sc.close();
	}//end main
	
	private static void displayEnemies()
	{
		for(int i = 0; i < Enemies.size();++i)
		{
			System.out.println((i + 1) + ") " +Enemies.get(i).toString() + "!");  //offset by one for easy human readability
		}
	}
	
}//end Class
