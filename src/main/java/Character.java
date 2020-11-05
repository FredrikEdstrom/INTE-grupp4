import java.util.HashMap;

public abstract class Character {

    protected final String name;
    protected int level = 1;
    protected int attack = 10;
    protected int defense = 10;
    protected int health = 100;
    protected int mana = 100;
    protected int intelligence = 10;
    protected int agility = 10;
    protected int experience = 0;
    protected boolean isAlive = true;

    private Weapon weapon;
    private final HashMap<String, Armor> armor = new HashMap<>();

    public Character(String name) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara tom eller blank
        this.name = name;
    }

    public Character(String name, int level, int attack, int defense, int health, int mana, int intelligence, int agility){
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara tom eller blank
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.mana = mana;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        int attack = this.attack;
        if(weapon != null)
            attack += weapon.getAttack();
        if(armor.get("Body Armor") != null)
            attack += armor.get("Body Armor").getAttack();
        if(armor.get("Hand Armor") != null)
            attack += armor.get("Hand Armor").getAttack();
        return attack;
    }

    public int getDefense() {
        int defense = this.defense;
        if(armor.get("Head Armor") != null)
            defense += armor.get("Head Armor").getDefense();
        if(armor.get("Body Armor") != null)
            defense += armor.get("Body Armor").getDefense();
        if(armor.get("Hand Armor") != null)
            defense += armor.get("Hand Armor").getDefense();
        if(armor.get("Leg Armor") != null)
            defense += armor.get("Leg Armor").getDefense();
        if(armor.get("Foot Armor") != null)
            defense += armor.get("Foot Armor").getDefense();
        return defense;
    }

    public int getHealth() {
        int health = this.health;
        if(armor.get("Head Armor") != null)
            health += armor.get("Head Armor").getHealth();
        if(armor.get("Body Armor") != null)
            health += armor.get("Body Armor").getHealth();
        if(armor.get("Hand Armor") != null)
            health += armor.get("Hand Armor").getHealth();
        if(armor.get("Leg Armor") != null)
            health += armor.get("Leg Armor").getHealth();
        if(armor.get("Foot Armor") != null)
            health += armor.get("Foot Armor").getHealth();
        return health;
    }

    public int getMana() {
        int mana = this.mana;
        if(armor.get("Head Armor") != null)
            mana += armor.get("Head Armor").getMana();
        if(armor.get("Body Armor") != null)
            mana += armor.get("Body Armor").getMana();
        if(armor.get("Hand Armor") != null)
            mana += armor.get("Hand Armor").getMana();
        if(armor.get("Leg Armor") != null)
            mana += armor.get("Leg Armor").getMana();
        if(armor.get("Foot Armor") != null)
            mana += armor.get("Foot Armor").getMana();
        return mana;
    }

    public int getIntelligence() {
        int intelligence = this.intelligence;
        if(weapon != null)
            intelligence += weapon.getIntelligence();
        if(armor.get("Body Armor") != null)
            intelligence += armor.get("Body Armor").getIntelligence();
        if(armor.get("Hand Armor") != null)
            intelligence += armor.get("Hand Armor").getIntelligence();
        return intelligence;
    }

    public int getAgility() {
        int agility = this.agility;
        if(armor.get("Leg Armor") != null)
            agility += armor.get("Leg Armor").getAgility();
        if(armor.get("Foot Armor") != null)
            agility += armor.get("Foot Armor").getAgility();
        return agility;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isAlive() { return isAlive;}

    public Weapon getWeapon() {
        return this.weapon;
    }

    public HeadArmor getHeadArmor() {
        return (HeadArmor) armor.get("Head Armor");
    }

    public BodyArmor getBodyArmor() {
        return (BodyArmor) armor.get("Body Armor");
    }

    public HandArmor getHandArmor() {
        return (HandArmor) armor.get("Hand Armor");
    }

    public LegArmor getLegArmor() {
        return (LegArmor) armor.get("Leg Armor");
    }

    public FootArmor getFootArmor() {
        return (FootArmor) armor.get("Foot Armor");
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health <= 0)
            setAlive();
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) {this.agility = agility;}

    public void setExperience(int experience) { this.experience = experience; }

    public void setAlive() {isAlive = !isAlive;}

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setHeadArmor(HeadArmor headArmor) {
        armor.put("Head Armor", headArmor);
    }

    public void setBodyArmor(BodyArmor bodyArmor) {
        armor.put("Body Armor", bodyArmor);
    }

    public void setHandArmor(HandArmor handArmor) {
        armor.put("Hand Armor", handArmor);
    }

    public void setLegArmor(LegArmor legArmor) {
        armor.put("Leg Armor", legArmor);
    }

    public void setFootArmor(FootArmor footArmor) {
        armor.put("Foot Armor", footArmor);
    }

    //A method that increases a Character objects level by 1 and its stats by a predefined amount
    public void levelUp() {
        if(level < 100) {
            level++;
            health += 20;
            mana += 20;
            attack += 5;
            defense += 5;
            intelligence += 5;
            agility += 5;
        }
    }
}