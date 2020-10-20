
public class Hero implements Actions {

	private int level = 1;
	private int attack = 10;
	private int defense = 10;
	private int intelligence = 10;
	private int speed = 10;
	private int health = 100;
	private int mana = 100;
	private int experience = 0;
	
	public Hero(int attack, int defense, int health, int mana) {
//		this.setLevel(level);
//		this.setAttack(attack);
//		this.setDefense(defense);
//		this.setHealth(health);
//		this.setMana(mana);
//		this.setExperience(experience);
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.mana = mana;
	}
	
	public Hero() {
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.mana = mana;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getLevel() {
			return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
			return experience;	
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void immunityToMagic() {
		
	}

	public void immunityToPhysicalAttacks() {
		
	}
	
	@Override
	public String toString() {
		return "Character [level=" + level + ", attack=" + attack + ", defense=" + defense + ", health=" + health
				+ ", mana=" + mana + ", experience=" + experience + "]";
	}

	@Override
	public void attackOrder(Hero a, Hero b) {
		b.setHealth(b.getHealth()-(a.getAttack()/b.getDefense()));
	}

	@Override
	public void defenseOrder(Hero a, Hero b) {
		a.setHealth(a.getHealth()-(b.getAttack()/(a.getDefense()*2)));
	}

	@Override
	public void magicAttack(Hero a, Hero b) {
		a.setMana(a.getMana()-20);
		b.setHealth(b.getHealth()-2*a.getAttack());
	}
		
}
