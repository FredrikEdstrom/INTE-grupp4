
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
    private HeadArmor headArmor;
    private BodyArmor bodyArmor;
    private HandArmor handArmor;
    private LegArmor legArmor;
    private FootArmor footArmor;

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
        if(bodyArmor != null)
            attack += bodyArmor.getAttack();
        if(handArmor != null)
            attack += handArmor.getAttack();
        return attack;
    }

    public int getDefense() {
        int defense = this.defense;
        if(headArmor != null)
            defense += headArmor.getDefense();
        if(bodyArmor != null)
            defense += bodyArmor.getDefense();
        if(handArmor != null)
            defense += handArmor.getDefense();
        if(legArmor != null)
            defense += legArmor.getDefense();
        if(footArmor != null)
            defense += footArmor.getDefense();
        return defense;
    }

    public int getHealth() {
        int health = this.health;
        if(headArmor != null)
            health += headArmor.getHealth();
        if(bodyArmor != null)
            health += bodyArmor.getHealth();
        if(handArmor != null)
            health += handArmor.getHealth();
        if(legArmor != null)
            health += legArmor.getHealth();
        if(footArmor != null)
            health += footArmor.getHealth();
        return health;
    }

    public int getMana() {
        int mana = this.mana;
        if(headArmor != null)
            mana += headArmor.getMana();
        if(bodyArmor != null)
            mana += bodyArmor.getMana();
        if(handArmor != null)
            mana += handArmor.getMana();
        if(legArmor != null)
            mana += legArmor.getMana();
        if(footArmor != null)
            mana += footArmor.getMana();
        return mana;
    }

    public int getIntelligence() {
        int intelligence = this.intelligence;
        if(weapon != null)
            intelligence += weapon.getIntelligence();
        if(bodyArmor != null)
            intelligence += bodyArmor.getIntelligence();
        if(handArmor != null)
            intelligence += handArmor.getIntelligence();
        return intelligence;
    }

    public int getAgility() {
        int agility = this.agility;
        if(legArmor != null)
            agility += legArmor.getAgility();
        if(footArmor != null)
            agility += footArmor.getAgility();
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
        return this.headArmor;
    }

    public BodyArmor getBodyArmor() {
        return this.bodyArmor;
    }

    public HandArmor getHandArmor() {
        return this.handArmor;
    }

    public LegArmor getLegArmor() {
        return this.legArmor;
    }

    public FootArmor getFootArmor() {
        return this.footArmor;
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
        this.headArmor = headArmor;
    }

    public void setBodyArmor(BodyArmor bodyArmor) {
        this.bodyArmor = bodyArmor;
    }

    public void setHandArmor(HandArmor handArmor) {
        this.handArmor = handArmor;
    }

    public void setLegArmor(LegArmor legArmor) {
        this.legArmor = legArmor;
    }

    public void setFootArmor(FootArmor footArmor) {
        this.footArmor = footArmor;
    }

    //A method that increases a Character objects level by 1 and its stats by a predefined amount
    public void levelUp() {
        if(level != 100) {
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