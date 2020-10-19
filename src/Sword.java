public class Sword extends Weapon {
    private int attack = 20;

    public Sword(String name, int level) {
        super(name, level);
        if (level != 1)
            attack += 5 * level; //Attack förändras med item level
    }

    public int getAttack() {
        return attack;
    }
}
