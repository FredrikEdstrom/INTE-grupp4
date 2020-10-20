public class Gloves extends HandArmor {
    private int mana = 10;
    private int intelligence = 5;
    private int defense = 3;

    public Gloves(String name, int level) {
        super(name, level);
        if (level != 1) {
            mana += 5 * level; //Mana, intelligence och defense förändras med item level
            intelligence += 3 * level;
            defense += 2 * level;
        }
    }

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getDefense() {
        return defense;
    }
}
