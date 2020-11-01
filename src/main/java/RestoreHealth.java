//Healing spell with predefined default values not intended to be changeable,
//but useable in calculating modified values
public class RestoreHealth extends HealSpell{
    private static final String NAME = "Restore Health";
    private static final int DEFAULT_COST = 20;
    private static final int LEVEL_REQUIREMENT = 1;
    private static final int DEFAULT_HEAL_VALUE = 20;

    public RestoreHealth(){
        super(NAME,DEFAULT_COST,LEVEL_REQUIREMENT,DEFAULT_HEAL_VALUE);
    }

    //Getter for modified healingvalue of the spell, affected by the supplied intelligence modifier
    public int getModifiedHealValue(int intelligence){
        return getHealValue() + intelligence * 2;
    }

    //Overridden equals and hashCode for use of RestoreHealth in HashSet
    public boolean equals(Object other){
        if (other instanceof RestoreHealth){
            RestoreHealth r = (RestoreHealth) other;
            return NAME == r.NAME && DEFAULT_COST == r.DEFAULT_COST && LEVEL_REQUIREMENT == r.LEVEL_REQUIREMENT
                    && DEFAULT_HEAL_VALUE == r.DEFAULT_HEAL_VALUE;
        }
        else
            return false;
    }

    public int hashCode(){
        return NAME.hashCode() + DEFAULT_COST * 10000 + LEVEL_REQUIREMENT + DEFAULT_HEAL_VALUE;
    }
}
