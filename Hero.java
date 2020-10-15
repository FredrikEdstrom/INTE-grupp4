public class Hero {

    private String name;
    private int level = 1;
    private int attack = 10;
    private int defense = 10;
    private int health = 100;
    private int mana = 100;
    private int intelligence = 10;
    private int experience = 0;

    public Hero (String name, int level, int attack, int defense, int health, int intelligence, int experience) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.intelligence = intelligence;
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

}