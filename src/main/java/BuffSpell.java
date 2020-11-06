//Abstract subclass of Spell that groups spells intended to buff a character.
//Contains common properties of buffspells
public abstract class BuffSpell extends Spell {
    private final int buffValue;
    private final int duration;

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
