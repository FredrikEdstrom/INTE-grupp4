public class Fireball extends Spell {
    private static final String NAME = "Fireball";
    private static final String DAMAGE_TYPE = "Fire";
    private static final int DEFAULT_DAMAGE = 20;
    private static final int DEFAULT_MANA_COST = 5;
    private static final int LEVEL_REQUIREMENT = 1;


    public Fireball(){
        super(NAME, DEFAULT_MANA_COST,LEVEL_REQUIREMENT);
    }

    public String getDamageType(){
        return DAMAGE_TYPE;
    }

    public int getDefaultDamage(){
        return DEFAULT_DAMAGE;
    }

    public int getDefaultManaCost() {return DEFAULT_MANA_COST; }

    public int getLevelRequirement(){
        return LEVEL_REQUIREMENT;
    }

    public int getModifiedDamage(int intelligence){
        return DEFAULT_DAMAGE + intelligence * 2;
    }

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
        return NAME.hashCode() + DAMAGE_TYPE.hashCode() * 10000 + DEFAULT_MANA_COST + DEFAULT_DAMAGE;
    }
}
