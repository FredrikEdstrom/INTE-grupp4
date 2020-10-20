public class Cap extends HeadArmor {
    private int mana = 10;
    private int defense = 3;

    public Cap(String name, int level) {
        super(name, level);
        if (level != 1) {
            mana += 5 * level; //Mana och defense förändras med item level
            defense += 2 * level;
        }
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }
}
