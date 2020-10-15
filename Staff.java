public class Staff extends Weapon {
    private int intelligence = 5;

    public Staff(String name, int level) {
        super(name, level);
        intelligence += 2 * level;
    }

    public int getIntelligence() {
        return intelligence;
    }

}
