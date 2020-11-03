public class HeadArmor extends Armor {
    private boolean isHelmet = false;
    private boolean isCap = false;

    public HeadArmor(String name, int level, boolean isHelmet) {
        super(name, level);
        if(isHelmet)
            this.isHelmet = true;
        else
            isCap = true;
        setArmorStats();
    }

    public boolean isHelmet() {
        return isHelmet;
    }

    public boolean isCap() {
        return isCap;
    }

    //Helmet gives health, defense, while
    //cap gives mana and small amount of defense
    @Override
    protected void setArmorStats() {
        if(isHelmet) {
            setHealth(5 * getLevel());
            setDefense(3 * getLevel());
        } else if (isCap) {
            setMana(5 * getLevel());
            setDefense(getLevel() / 2);
        }
    }
}
