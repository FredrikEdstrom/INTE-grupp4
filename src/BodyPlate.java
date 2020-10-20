public class BodyPlate extends BodyArmor {
    private int health = 20;
    private int mana = 5;
    private int attack = 10;
    private int defense = 10;


    public BodyPlate(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 5 * level; //Health, mana, attack och defense förändras med item level
            mana += level;
            attack += 3 * level;
            defense += 3 * level;
        }
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

    public int getDefense() {
        return defense;
    }
}
