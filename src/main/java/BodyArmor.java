public class BodyArmor extends Armor {
    private boolean isPlate = false;
    private boolean isRobe = false;

    public BodyArmor(String name, int level, boolean isPlate) {
        super(name, level);
        if(isPlate)
            this.isPlate = true;
        else
            isRobe = true;
        setArmorStats();
    }

    public boolean isPlate() {
        return isPlate;
    }

    public boolean isRobe() {
        return isRobe;
    }

    //Plate armor gives attack, health, defense, and small amount of mana, while
    //robe gives intelligence, mana, and small amount of health and defense.
    @Override
    protected void setArmorStats() {
        if(isPlate) {
            setHealth(10 * getLevel());
            setMana(getLevel() / 2);
            setDefense(5 * getLevel());
            setAttack(3 * getLevel());
        } else if(isRobe) {
            setHealth(getLevel() / 2);
            setMana(10 * getLevel());
            setDefense(getLevel() / 2);
            setIntelligence(3 * getLevel());
        }
    }
}
