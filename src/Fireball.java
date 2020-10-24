public class Fireball {
    private static final String DAMAGE_TYPE = "Fire";
    private static final int DEFAULT_DAMAGE = 20;
    private static final int LEVEL_REQUIREMENT = 1;

    public String getDamageType(){
        return DAMAGE_TYPE;
    }

    public int getDefaultDamage(){
        return DEFAULT_DAMAGE;
    }

    public int getLevelRequirement(){
        return LEVEL_REQUIREMENT;
    }

    public int getModifiedDamage(int intelligence){
        return DEFAULT_DAMAGE + intelligence * 2;
    }
}
