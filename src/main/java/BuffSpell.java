public abstract class BuffSpell extends Spell {
    private int buffValue;
    private int duration;

    public BuffSpell(String name, int cost, int levelReq,int buffValue,int duration) {
        super(name,cost,levelReq);
        this.buffValue = buffValue;
        this.duration = duration;
    }

    public int getBuffValue(){
        return buffValue;
    }

    public int getDuration() {
        return duration;
    }
}
