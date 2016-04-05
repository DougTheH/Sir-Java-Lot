/**
 * 
 */
package assignment5;

/**
 * @author Doug
 *
 */


import java.util.Random;

/**
 * Superclass for various enemy types
 */
abstract class Enemy {
	
	protected int health;
	protected int STRENGTH;
	protected static Random rnd = new Random();
	protected boolean alive;
	protected Weapon wpn;
	
	/**
	 * Suppressed constructor, use static method factory.
	 */
	protected Enemy() {
		alive = true;
	}
	
	/**
	 * @param the damage taken
	 * @param the weapon type
	 * Computes the actual damage taken and reduces hitpoints.
	 * Sets alive to false if creature runs out of hitpoints.
	 */
	public void takeDamage(int dmg, Weapon enemywpn) throws IllegalDamageException
	{
		if(0 > dmg)
		{
			throw new IllegalDamageException("Attacked for Negative Damage!");
		}
	}
	
	/**
	 * @return the damage dealt by an attack
	 */
	public abstract int fight();
	
	/**
	 * static method factory
	 */
	public static final Enemy EnemyGenerator()
	{
		int tmp = rnd.nextInt(4);
		switch(tmp)
		{
			case 1: return new OracleOgre();
			case 2: return new AppleAdventurer();
			case 3: return new MicrosoftMage();
			case 4: default: return new JavaJouster();
		}
	}
	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	/**
	 * @return the alive status
	 */
	public boolean isAlive() {
		return alive;
	}

	/**
	 * @param alive the living status to set
	 */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	/**
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return wpn;
	}
	/**
	 * @param wpn the weapon to set
	 */
	public void setWeapon(Weapon wpn) {
		this.wpn = wpn;
	}
	
	public abstract String toString();
	
}
