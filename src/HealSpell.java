public class HealSpell extends Spell {
    private int healValue;

    public HealSpell(String name, int cost, int levelReq,int healValue) {
        super(name,cost,levelReq);
        this.healValue = healValue;
    }

    public int getHealValue(){
        return healValue;
    }

}
