import java.util.HashMap;

public abstract class Character {

    private final String name;
    private int level = 1;
    private int attack = 10;
    private int defense = 10;
    private int health = 100;
    private int mana = 100;
    private int intelligence = 10;
    private int agility = 10;
    private int experience = 0;
    private boolean isAlive = true;

    private Weapon weapon;
    private final HashMap<String, Armor> armor = new HashMap<>();

    public Character(String name) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara tom eller blank
        this.name = name;
    }

    public Character(String name, int level, int attack, int defense, int health, int mana, int intelligence, int agility) {
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
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isAlive() {
        return isAlive;
    }

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
        if (this.health > 0)
            this.health = health;
        if (this.health <= 0)
            setAlive();
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setAlive() {
        isAlive = !isAlive;
    }

    public void setWeapon(Weapon weapon) {
        if (this.weapon != null && weapon != null) {
            this.attack -= this.weapon.getAttack();
            this.intelligence -= this.weapon.getIntelligence();
        }
        this.weapon = weapon;
    }

    public void setHeadArmor(HeadArmor headArmor) {
        if (armor.get("Head Armor") != null && headArmor != null) {
            this.health -= armor.get("Head Armor").getHealth();
            this.mana -= armor.get("Head Armor").getMana();
            this.defense -= armor.get("Head Armor").getDefense();
        }
        armor.put("Head Armor", headArmor);
    }

    public void setBodyArmor(BodyArmor bodyArmor) {
        if (armor.get("Body Armor") != null && bodyArmor != null) {
            this.health -= armor.get("Body Armor").getHealth();
            this.mana -= armor.get("Body Armor").getMana();
            this.defense -= armor.get("Body Armor").getDefense();
            this.attack -= armor.get("Body Armor").getAttack();
            this.intelligence -= armor.get("Body Armor").getIntelligence();
        }
        armor.put("Body Armor", bodyArmor);
    }

    public void setHandArmor(HandArmor handArmor) {
        if (armor.get("Hand Armor") != null && handArmor != null) {
            this.health -= armor.get("Hand Armor").getHealth();
            this.mana -= armor.get("Hand Armor").getMana();
            this.defense -= armor.get("Hand Armor").getDefense();
            this.attack -= armor.get("Hand Armor").getAttack();
            this.intelligence -= armor.get("Hand Armor").getIntelligence();
        }
        armor.put("Hand Armor", handArmor);
    }

    public void setLegArmor(LegArmor legArmor) {
        if (armor.get("Leg Armor") != null && legArmor != null) {
            this.health -= armor.get("Leg Armor").getHealth();
            this.mana -= armor.get("Leg Armor").getMana();
            this.defense -= armor.get("Leg Armor").getDefense();
            this.agility -= armor.get("Leg Armor").getAgility();
        }
        armor.put("Leg Armor", legArmor);
    }

    public void setFootArmor(FootArmor footArmor) {
        if (armor.get("Foot Armor") != null && footArmor != null) {
            this.health -= armor.get("Foot Armor").getHealth();
            this.mana -= armor.get("Foot Armor").getMana();
            this.defense -= armor.get("Foot Armor").getDefense();
            this.agility -= armor.get("Foot Armor").getAgility();
            armor.put("Foot Armor", footArmor);
        }
        armor.put("Foot Armor", footArmor);
    }

    //A method that increases a Character objects level by 1 and its stats by a predefined amount
    public void levelUp() {
        if (level < 100) {
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