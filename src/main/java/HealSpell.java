// Abstract subclass of Spell that groups spells intended to heal a character.
// Contains common properties of healing spells
public abstract class HealSpell extends Spell {
    private final int healValue;

    public HealSpell(String name, int cost, int levelReq,int healValue) {
        super(name,cost,levelReq);
        this.healValue = healValue;
    }

    public int getHealValue(){
        return healValue;
    }

    abstract int getModifiedHealValue(int intelligence);

}
