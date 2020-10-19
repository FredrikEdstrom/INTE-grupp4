public class Helmet extends HeadArmor {
    private int health = 10;
    private int defense = 5;

    public Helmet(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 5 * level; //Health och defense förändras med item level
            defense += 3 * level;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }
}
