// Abstract subclass of Spell that groups spells intended do deal damage to an opponent.
// Contains common properties for attacking spells
public abstract class AttackSpell extends Spell{
    private final String damageType;
    private final int defaultDamage;

    public AttackSpell(String name, int cost, int levelReq, String damageType,int defaultDamage) {
        super(name,cost,levelReq);
        this.damageType = damageType;
        this.defaultDamage = defaultDamage;
    }

    public String getDamageType(){
        return damageType;
    }

    public int getDefaultDamage(){
        return defaultDamage;
    }

    public abstract int getModifiedDamage(int intelligence);

}
