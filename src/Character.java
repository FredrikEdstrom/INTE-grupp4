
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

    public int getAgility() {return agility;}

    public int getExperience() {
        return experience;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) { this.agility = agility; }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void levelUp() {
        if(this.level < 100) {
            this.level++;
            health += 20;
            mana += 20;
            attack += 5;
            defense += 5;
            intelligence += 5;
            agility += 5;
        }
    }

    //Setter metod för level som används för testning
    protected void setLevel(int level) {
        if(level > 100) {
            level = 100;
        } else if(level < 1) {
            level = 1;
        }
        while (this.level != level)
            levelUp();
    }

}