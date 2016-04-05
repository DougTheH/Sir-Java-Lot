/**
 * 
 */
package assignment5;

/**
 * @author Doug
 *
 */
public class AppleAdventurer extends Enemy {

	/**
	 * 
	 */
	public AppleAdventurer() {
		super();
		health = 11 + rnd.nextInt(30);
		wpn = Weapon.SPEAR;
		STRENGTH = 3;
	}
	
	/**
	 * @param the damage taken
	 * @param the weapon type
	 * Computes the actual damage taken and reduces hitpoints.
	 * Sets alive to false if creature runs out of hitpoints.
	 */
	@Override
	public void takeDamage(int dmg, Weapon enemywpn) throws IllegalDamageException
	{
		//check for valid damage
		super.takeDamage(dmg, enemywpn);
		health -= dmg;
		
		if(0 >= health)
		{
			alive = false;
		}
	}
	
	/**
	 * @return the damage dealt by an attack
	 */
	@Override
	public int fight()
	{
		return STRENGTH + rnd.nextInt(5);
	}
	
	@Override
	public String toString()
	{
		return "Apple Adventurer";
	}
	
}

