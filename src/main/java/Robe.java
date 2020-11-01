public class Robe extends BodyArmor {
    private int health = 5;
    private int mana = 20;
    private int intelligence = 10;
    private int defense = 5;

    public Robe(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 0.5 * level; //Health, mana, intelligence och defense förändras med item level
            mana += 5 * level;
            intelligence += 3 * level;
            defense += 0.5 * level;
        }
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    public int getIntelligence() { return intelligence; }

}
