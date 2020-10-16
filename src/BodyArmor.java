public class BodyArmor {
    private final String name;
    private final int level;
    private int health = 20;
    private int mana = 20;
    private int defense = 10;

    public BodyArmor(String name, int level) {
        if (name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("Name: empty"); //Namn får inte vara blank eller tom
        this.name = name;
        if (level < 1 || level > 100)
            throw new IllegalArgumentException("Level: " + level); //Level får inte vara lägre än 1 eller högre än 100
        this.level = level;
        if(level != 1) {
            health += 1.5 * level; //Health, mana, och defense förändras med item level
            mana += 1.5 * level;
            defense += 1.5 * level;
        }
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

    public int getDefense() {
        return defense;
    }
}
