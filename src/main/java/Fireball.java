//Damaging spell with predefined default values not intended to be changeable,
// but useable in calculating modified values
public class Fireball extends AttackSpell {
    private static final String NAME = "Fireball";
    private static final int DEFAULT_MANA_COST = 5;
    private static final int LEVEL_REQUIREMENT = 1;
    private static final String DAMAGE_TYPE = "Fire";
    private static final int DEFAULT_DAMAGE = 20;
    
    public Fireball(){
        super(NAME, DEFAULT_MANA_COST,LEVEL_REQUIREMENT,DAMAGE_TYPE,DEFAULT_DAMAGE);
    }

    //A getter of modified damage value of the spell, affected by the supplied intelligence modifier
    public int getModifiedDamage(int intelligence){
        return getDefaultDamage() + intelligence * 2;
    }

    //Overridden equals and hashCode for use of Fireball in HashSet
    @Override
    public boolean equals(Object other){
        if (other instanceof Fireball){
            Fireball f = (Fireball)other;
            return NAME == f.NAME && DAMAGE_TYPE == f.DAMAGE_TYPE && DEFAULT_DAMAGE == f.DEFAULT_DAMAGE
            && DEFAULT_MANA_COST == f.DEFAULT_MANA_COST && LEVEL_REQUIREMENT == f.LEVEL_REQUIREMENT;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        return NAME.hashCode() + DAMAGE_TYPE.hashCode() * 10000 + DEFAULT_MANA_COST + DEFAULT_DAMAGE + LEVEL_REQUIREMENT;
    }

}
