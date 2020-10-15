public class Cap extends HeadArmor {
    private int mana = 10;
    private int defense = 5;

    public Cap(String name, int level) {
        super(name, level);
        if (level != 1) {
            mana += 1.5 * level; //Mana ökar med level
            defense += 1.5 * level;   //Defense ökar med level
        }
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }
}
