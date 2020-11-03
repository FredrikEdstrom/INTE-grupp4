public class HandArmor extends Armor {
    private boolean isGauntlets = false;
    private boolean isGloves = false;

    public HandArmor(String name, int level, boolean isGauntlets) {
        super(name, level);
        if (isGauntlets)
            this.isGauntlets = true;
        else
            isGloves = true;
        setArmorStats();
    }

    public boolean isGauntlets() {
        return isGauntlets;
    }

    public boolean isGloves() {
        return isGloves;
    }

    //Gauntlets gives health, attack, and defense, while
    //gloves gives mana, intelligence and small amount of defense
    @Override
    protected void setArmorStats() {
        if (isGauntlets) {
            setHealth(5 * getLevel());
            setDefense(3 * getLevel());
            setAttack(3 * getLevel());
        } else if (isGloves) {
            setMana(5 * getLevel());
            setDefense(getLevel() / 2);
            setIntelligence(3 * getLevel());
        }
    }
}
