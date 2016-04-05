package assignment5;

public class OracleOgre extends Enemy {

	public OracleOgre() {
		super();
		health = 21 + rnd.nextInt(40);
		wpn = Weapon.WARHAMMER;
		STRENGTH = 8;
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
			dmg *= 2;
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
	public int fight()
	{
		return STRENGTH + rnd.nextInt(15);
	}
	
	@Override
	public String toString()
	{
		return "Oracle Ogre";
	}

}
