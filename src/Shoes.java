public class Shoes extends FootArmor {
    private int mana = 10;
    private int defense = 3;
    private int agility = 5;

    public Shoes(String name, int level) {
        super(name, level);
        if (level != 1) {
            mana += 5 * level; //Mana, agility och defense förändras med item level
            defense += 2 * level;
            agility += 3 * level;
        }
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }

    public int getAgility() {
        return agility;
    }
}
