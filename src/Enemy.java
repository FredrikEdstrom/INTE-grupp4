public class Enemy extends Character {

    private boolean immunityToPhysicalAttack;
    private boolean immunityToMagicAttack;

    public Enemy(String name, int level, int attack, int defense, int health, int mana, int intelligence, int agility, boolean immunityToPhysicalAttack,
                 boolean immunityToMagicAttack) {
        super(name, level, attack, defense, health, mana, intelligence, agility);
        this.immunityToPhysicalAttack = immunityToPhysicalAttack;
        this.immunityToMagicAttack = immunityToMagicAttack;
    }

    public void setImmunityToPhysicalAttack(boolean immunityToPhysicalAttack) {
        this.immunityToPhysicalAttack = immunityToPhysicalAttack;
    }

    public void setImmunityToMagicAttack(boolean immunityToMagicAttack) {
        this.immunityToMagicAttack = immunityToMagicAttack;
    }

    public boolean getImmunityToPhysicalAttack() {
        return immunityToPhysicalAttack;
    }

    public boolean getImmunityToMagicAttack() {
        return immunityToMagicAttack;
    }
}

