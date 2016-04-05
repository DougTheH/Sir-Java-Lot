/**
 * 
 */
package assignment5;

/**
 * @author Doug
 *
 */
public class JavaJouster extends Enemy {

	/**
	 * 
	 */
	public JavaJouster() {
		super();
		health = 15 + rnd.nextInt(25);
		wpn = Weapon.SPEAR;
		STRENGTH = 7;
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
		if(Weapon.WARHAMMER == enemywpn)
		{
			dmg *= 2;
		}
		else if(Weapon.LONGSWORD == enemywpn || Weapon.BATTLEAXE == enemywpn || Weapon.MAGICMISSILE == enemywpn)
		{
			dmg /=2;
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
		return STRENGTH + 6 + rnd.nextInt(3);
	}

	
	@Override
	public String toString() {
		return "Java Jouster";
	}

}
