package assignment5;

/**
 * @author Doug
 *
 */

import java.util.Random;

public class Knight {

	private String name;
	private int health;
	private int numBattles;
	private int age;
	private int gold;
	private Weapon wpn;
	private Armor amr;
	private static Random rnd = new Random();
	private final int STRENGTH = 5;
	boolean alive;
	private String[] names = {"Arthur", "Bedivere", "Bertrand", "Bruce", "Charles", "Daniel", "Edward", "Frederick", "Galahad", "Gawain", "Geoffroi", "Godfrey", "Jacques", "Joan", "John", "Joseph", "Karl", "Lancelot", "Olivier", "Nevsky", "Percival", "Richard", "Robert", "Roland", "Tancred", "Ulrich", "William"};
	
	
	/**
	 * Constructor which auto generates random Knight
	 */
	public Knight(){
		name = names[rnd.nextInt(names.length)];
		health = 150 + rnd.nextInt(20);
		numBattles = 0;
		age = 15 + rnd.nextInt(26);
		gold = 0;
		int tmp = 1 + rnd.nextInt(5);
		
		switch(tmp)
		{
			case 1:	setWeapon(Weapon.LONGSWORD);
			case 2:	setWeapon(Weapon.BATTLEAXE);
			case 3:	setWeapon(Weapon.SPEAR);
			case 4:	setWeapon(Weapon.WARHAMMER);
			case 5:	setWeapon(Weapon.MAGICMISSILE);
			default:	setWeapon(Weapon.LONGSWORD);
		}
		
		tmp = 1 + rnd.nextInt(3);
		switch(tmp)
		{
			case 1: setArmor(Armor.ROBES);
			case 2: setArmor(Armor.LEATHER);
			case 3: setArmor(Armor.PLATE);
			default: setArmor(Armor.LEATHER);
		}
		alive = true;
	}
	
	/**
	 * Constructor which generates Knight to exact user specification
	 * Meant for debugging
	 */
	public Knight(String n, int h, int nB, int a, int g, Weapon w, Armor ac){
		name = n;
		health = h;
		numBattles = nB;
		age = a;
		gold = g;
		wpn = w;
		amr = ac;
		alive = true;
	}
	
	/**
	 * Constructor which generates Knight for user to play
	 * 
	 */
	public Knight(String n, int a, Weapon w, Armor ac){
		this();
		name = n;
		age = a;
		wpn = w;
		amr = ac;
		alive = true;
	}
	
	
	public int fight()
	{
		int damage = WeaponDamage();
		//user choices go here:
		
		
		
		return damage;
	}
	
	public void takeDamage(int damage, Weapon enemywpn)
	{
		switch(amr)
		{
		case ROBES:
			if(Weapon.MAGICMISSILE == enemywpn)
			{
				damage /= 2;
			}
			break;
		case LEATHER: default:
			break;
		case PLATE:
			if(Weapon.LONGSWORD == enemywpn || Weapon.BATTLEAXE == enemywpn || Weapon.SPEAR == enemywpn)
			{
				damage /= 2;
			}
			else if(Weapon.WARHAMMER == enemywpn)
			{
				damage *= 2;
			}
		}
		
		health -= damage;
		if(0 >= health)
		{
			alive = false;
			health = 0;
		}
	}
	
	
	/**
	 *  @return String representation of this knight's attributes
	 */
	public void print(){
		System.out.println("Knight Name: " + name);
		System.out.println("Knight Health: " + health);
		System.out.println("Knight Battles: " + numBattles);
		System.out.println("Knight Age: " + age);
		System.out.println("Knight Gold: " + gold);
		System.out.println("Knight Weapon: " + weaponName());
		System.out.println("Knight Armor: " + armorName());
	}
	
	public String toString()
	{
		return (name);
	}
	
	
	//calculates the weapon damage of an attack
	int WeaponDamage()
	{
		//should always have average damage of 8;
		switch(wpn)
		{
			case LONGSWORD: return STRENGTH + 4 + rnd.nextInt(7);
			case BATTLEAXE: return STRENGTH + 2 + rnd.nextInt(11);
			case SPEAR: return STRENGTH + 6 + rnd.nextInt(3);
			case WARHAMMER: return STRENGTH + rnd.nextInt(15);
			case MAGICMISSILE: 
				if(rnd.nextInt(1)%2 == 0)
				{
					return 1 + rnd.nextInt(4);
				}
				else
				{
					return 16 - rnd.nextInt(4);
				}
			default: return 8;
		}
	}
	
	
	
	private String weaponName()
	{
		switch(wpn)
		{
		case LONGSWORD: return "Longsword";
		case BATTLEAXE: return "BattleAxe";
		case SPEAR: return "Spear";
		case WARHAMMER: return "Warhammer";
		case MAGICMISSILE: return "Magic Missile";
		default: return "Longsword";
		}
	}
	
	private String armorName()
	{
		switch(amr)
		{
		case ROBES: return "Robes";
		case LEATHER: return "Leather";
		case PLATE: return "Full Plate";
		default: return "Leather";
		}
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the numBattles
	 */
	public int getNumBattles() {
		return numBattles;
	}
	/**
	 * @param numBattles the numBattles to set
	 */
	public void setNumBattles(int numBattles) {
		this.numBattles = numBattles;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the gold
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * @param gold the gold to set
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}

	/**
	 * @return the armor
	 */
	public Armor getArmor() {
		return amr;
	}

	/**
	 * @param armor the armor to set
	 */
	public void setArmor(Armor amr) {
		this.amr = amr;
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
}//end class Knight
