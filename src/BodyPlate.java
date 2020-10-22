public class BodyPlate extends BodyArmor {
    private int health = 20;
    private int mana = 5;
    private int attack = 10;
    private int defense = 10;


    public BodyPlate(String name, int level) {
        super(name, level);
        if (level != 1) {
            health += 5 * level; //Health, mana, attack och defense förändras med item level
            mana += 0.5 * level;
            attack += 3 * level;
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
    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }
}
