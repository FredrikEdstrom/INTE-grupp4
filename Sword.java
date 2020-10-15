public class Sword extends Weapon {
    private int attack = 5;

    public Sword(String name, int level) {
        super(name, level);
        attack += 2 * level; //Attack ökar med item level
    }

    public int getAttack() {
        return attack;
    }
}
