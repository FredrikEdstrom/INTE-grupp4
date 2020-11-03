public class FootArmor extends Armor{
    private boolean isBoots = false;
    private boolean isShoes = false;

    public FootArmor(String name, int level, boolean isBoots) {
        super(name, level);
        if(isBoots)
            this.isBoots = true;
        else
            this.isShoes = true;
        setArmorStats();
    }

    public boolean isBoots() {
        return isBoots;
    }

    public boolean isShoes() {
        return isShoes;
    }

    //Boots gives health, defense, and small amount of agility,
    //while shoes gives mana, agility, and small amount of defense.
    @Override
    protected void setArmorStats() {
        if(isBoots) {
            setHealth(5 * getLevel());
            setDefense(3 * getLevel());
            setAgility(getLevel() / 2);
        } else if (isShoes) {
            setMana(5 * getLevel());
            setDefense(getLevel() / 2);
            setAgility(3 * getLevel());
        }
    }
}
