public class Spell {
    private String name;
    private int cost;
    private int levelReq;

    public Spell(String name, int cost, int levelReq){
        this.name = name;
        this.cost = cost;
        this.levelReq = levelReq;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getLevelReq(){
        return levelReq;
    }
}
