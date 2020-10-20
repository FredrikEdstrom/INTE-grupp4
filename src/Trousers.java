public class Trousers extends LegArmor {
    private int health = 5;
    private int mana = 20;
    private int agility = 10;
    private int defense = 5;

    public Trousers(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += level; //Health, mana, agility och defense förändras med item level
            mana += 5 * level;
            agility += 3 * level;
            defense += level;
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
    public int getAgility() {
        return agility;
    }

    @Override
    public int getDefense() {
        return defense;
    }
}