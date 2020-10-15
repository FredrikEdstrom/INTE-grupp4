public abstract class Weapon {
    private String name;
    private int level = 1;

    public Weapon (String name, int level) {
     this.name = name;
     if(level < 1 || level > 100)
         throw new IllegalArgumentException("level: " + level);
     this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
