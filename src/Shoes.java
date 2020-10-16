public class Shoes extends FootArmor {
    private int mana = 10;
    private int defense = 5;

    public Shoes(String name, int level) {
        super(name, level);
        if(level != 1) {
            mana += 1.5 * level; //Mana och defense förändras med item level
            defense += 1.5 * level;
        }
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }
}
