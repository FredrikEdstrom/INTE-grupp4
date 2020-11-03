public class LegArmor extends Armor {
    private boolean isPlate = false;
    private boolean isTrousers = false;

    public LegArmor(String name, int level, boolean isPlate) {
        super(name, level);
        if (isPlate)
            this.isPlate = true;
        else
            isTrousers = true;
        setArmorStats();
    }

    public boolean isPlate() {
        return isPlate;
    }

    public boolean isTrousers() {
        return isTrousers;
    }

    //Leg plates gives health, defense, and small amount of mana and agility,
    // while trousers mana, agility, and small amount of health and defense.
    @Override
    protected void setArmorStats() {
        if (isPlate) {
            setHealth(10 * getLevel());
            setMana(getLevel() / 2);
            setDefense(3 * getLevel());
            setAgility(getLevel() / 2);
        } else if (isTrousers) {
            setHealth(getLevel() / 2);
            setMana(10 * getLevel());
            setDefense(getLevel() / 2);
            setAgility(3 * getLevel());
        }
    }

}
