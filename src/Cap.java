public class Cap extends HeadArmor {
    private int mana = 10;
    private int defense = 2;

    public Cap(String name, int level) {
        super(name, level);
        if (level != 1) {
            mana += 5 * level; //Mana och defense förändras med item level
            defense += level;
        }
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }
}
