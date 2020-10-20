public class Robe extends BodyArmor {
    private int health = 10;
    private int mana = 20;
    private int intelligence = 10;
    private int defense = 5;

    public Robe(String name, int level) {
        super(name, level);
        if(level != 1) {
            health += 2 * level; //Health, mana, intelligence och defense förändras med item level
            mana += 5 * level;
            intelligence += 3 * level;
            defense += 2 * level;
        }
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

    public int getDefense() {
        return defense;
    }
}
