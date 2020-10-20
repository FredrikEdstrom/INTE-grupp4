public class Gauntlets extends HandArmor {
    private int health = 10;
    private int attack = 5;
    private int defense = 5;

    public Gauntlets(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 5 * level; //Health, attack och defense förändras med item level
            attack += 3 * level;
            defense += 3 * level;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    @Override
    public int getDefense() {
        return defense;
    }
}
