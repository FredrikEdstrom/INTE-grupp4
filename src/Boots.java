public class Boots extends FootArmor {
    private int health = 10;
    private int defense = 5;
    private int agility = 2;

    public Boots(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 5 * level; //Health, agility och defense förändras med item level
            defense += 3 * level;
            agility += level;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getDefense() {
        return defense;
    }

    public int getAgility() { return  agility; }

}
