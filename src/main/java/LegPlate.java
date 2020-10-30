public class LegPlate extends LegArmor {
    private int health = 20;
    private int mana = 5;
    private int agility = 5;
    private int defense = 10;

    public LegPlate(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 5 * level; //Health, mana, agility och defense förändras med item level
            mana += 0.5 * level;
            agility += 0.5 * level;
            defense += 3 * level;
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