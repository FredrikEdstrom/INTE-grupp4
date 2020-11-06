//Attack-increasing spell with predefined default values not intended to be changeable,
//but useable in calculating modified values
public class IncreaseAttack extends BuffSpell{
    private static final String NAME = "Increase Attack";
    private static final int DEFAULT_COST = 25;
    private static final int LEVEL_REQUIREMENT = 2;
    private static final int DEFAULT_BUFF_VALUE = 50;
    private static final int DURATION = 3;

    public IncreaseAttack(){
        super(NAME,DEFAULT_COST,LEVEL_REQUIREMENT,DEFAULT_BUFF_VALUE,DURATION);
    }

    //Overridden equals and hashCode for use of IncreaseAttack in HashSet
    public boolean equals(Object other){
        if (other instanceof IncreaseAttack){
            IncreaseAttack i = (IncreaseAttack) other;
            return NAME.equals(i.NAME) && DEFAULT_COST == i.DEFAULT_COST && LEVEL_REQUIREMENT == i.LEVEL_REQUIREMENT
                    && DEFAULT_BUFF_VALUE == i.DEFAULT_BUFF_VALUE && DURATION == i.DURATION;
        }
        else
            return false;
    }

    public int hashCode(){
        return NAME.hashCode() + DEFAULT_COST * 10000 + LEVEL_REQUIREMENT + DEFAULT_BUFF_VALUE + DURATION;
    }
}
