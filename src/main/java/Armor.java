public abstract class Armor {
    private final String name;
    private final int level;
    private int health;
    private int mana;
    private int attack;
    private int intelligence;
    private int agility;
    private int defense;
    private int durability = 100;

    public Armor(String name, int level) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Name is not allowed to be empty or blank
        this.name = name;
        //Level sets to 1 when the amount is smaller than 1 and
        //it sets 100 when the amount is bigger than 100
        if (level < 1)
            this.level = 1;
        else
            this.level = Math.min(level, 100);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMana() {
        return mana;
    }

    public int getAttack() {
        return attack;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setMana(int mana) {
        this.mana = mana;
    }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    protected void setAgility(int agility) {
        this.agility = agility;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    public void setDurability() {
        if (durability != 0)
            durability--;
    }
    public void setStatsToZero() {
        if (durability == 0) {
            health = 0;
            mana = 0;
            attack = 0;
            intelligence = 0;
            agility = 0;
            defense = 0;
        }
    }

    protected abstract void setArmorStats();

}
