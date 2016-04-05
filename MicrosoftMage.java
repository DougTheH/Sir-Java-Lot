/**
 * 
 */
package assignment5;

/**
 * @author Doug
 *
 */
public class MicrosoftMage extends Enemy {

	/**
	 * 
	 */
	public MicrosoftMage() {
		super();
		health = 11 + rnd.nextInt(20);
		wpn = Weapon.MAGICMISSILE;
		STRENGTH = 1;
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
		if(Weapon.MAGICMISSILE == enemywpn)
		{
			dmg /= 2;
		}
		
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
	public int fight() {
		//magic missile either does a lot of damage or almost no damage
		//very unreliable, like Microsoft products.
		if(rnd.nextInt(1)%2 == 0)
		{
			return 1 + rnd.nextInt(4);
		}
		else
		{
			return 16 - rnd.nextInt(4);
		}
	}

	
	@Override
	public String toString() {
		return "Microsoft Mage";
	}

}
